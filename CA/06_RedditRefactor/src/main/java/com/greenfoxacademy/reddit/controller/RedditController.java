package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.enums.VoteDirection;
import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.dtos.PostDTO;
import com.greenfoxacademy.reddit.dtos.SimpleError;
import com.greenfoxacademy.reddit.services.PostService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/reddit")
public class RedditController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PostService postService;

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> getPosts(@RequestParam(required = false) String pageIn,
                                      @RequestParam(required = false) String sizeIn) {
        try {
            return new ResponseEntity<>(postService.getByPageAndSize(pageIn, sizeIn), HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
        }
    }

    @RequestMapping(path = "/posts", method = RequestMethod.POST)
    public ResponseEntity<?> postPost(@RequestBody(required = false) PostDTO data) {
        Post post;
        try {
            post = postService.createPost(data);
        } catch (RuntimeException exception){
            return new ResponseEntity<>(new SimpleError(exception.getMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @RequestMapping(path = "/posts/{id}/upvote", method = RequestMethod.PUT)
    @Transactional
    public ResponseEntity<?> upvotePost(@PathVariable String id) {
        Post post;
         try {
             post = postService.voteForPost(id, VoteDirection.UP);
         } catch (RuntimeException exception){
             return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
         }

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @RequestMapping(path = "/posts/{id}/downvote", method = RequestMethod.PUT)
    @Transactional
    public ResponseEntity<?> downvotePost(@PathVariable String id) {
        Post post;
        try {
            post = postService.voteForPost(id, VoteDirection.DOWN);
        } catch (RuntimeException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.DELETE)
    @Transactional
    public ResponseEntity<?> deletePost(@PathVariable String id) {
        String errorMessage = getErrorForBadId(id);
        if (errorMessage != null) {
            return new ResponseEntity<>(new SimpleError(errorMessage), HttpStatus.BAD_REQUEST);
        }

        Post post = entityManager.find(Post.class, id);

        errorMessage = getErrorForNullPost(post, id);
        if (errorMessage != null) {
            return new ResponseEntity<>(new SimpleError(errorMessage), HttpStatus.BAD_REQUEST);
        }

        entityManager.remove(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.PUT)
    @Transactional
    public ResponseEntity<?> updatePost(@PathVariable String id, @RequestBody(required = false) PostDTO data) {
        String errorMessage = getErrorForBadId(id);
        if (errorMessage != null) {
            return new ResponseEntity<>(new SimpleError(errorMessage), HttpStatus.BAD_REQUEST);
        }

        errorMessage = getErrorForBadData(data);
        if (errorMessage != null) {
            return new ResponseEntity<>(new SimpleError(errorMessage), HttpStatus.BAD_REQUEST);
        }

        if (!isValid(data.getUrl())) {
            return new ResponseEntity<>(new SimpleError("Invalid URL"), HttpStatus.BAD_REQUEST);
        }

        Post post = entityManager.find(Post.class, id);

        errorMessage = getErrorForNullPost(post, id);
        if (errorMessage != null) {
            return new ResponseEntity<>(new SimpleError(errorMessage), HttpStatus.BAD_REQUEST);
        }

        post.setTitle(data.getTitle());
        post.setUrl(data.getUrl());
        entityManager.persist(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    private String getErrorForBadId(String idIn) {
        long id;
        try {
            id = Long.parseLong(idIn);
        } catch (NumberFormatException exception) {
            return "Provided id is not a number";
        }
        return null;
    }

    private String getErrorForNullPost(Post post, String id) {
        if (post == null) {
            return "No post with provided id " + id + " exists";
        }
        return null;
    }



    private String getErrorForBadData(PostDTO data) {
        if (data == null) {
            return "No post data provided";
        } else {
            String errorMessage = "";
            if (data.getTitle() == null || data.getTitle().equals("")) {
                errorMessage = "No post title provided";
            }
            if (data.getUrl() == null || data.getUrl().equals("")) {
                errorMessage += (errorMessage.equals("")) ? "No post url provided" : " and no post url provided";
            }
            if (!errorMessage.equals("")) {
                return errorMessage;
            }
        }
        return null;
    }

    private boolean isValid(String url) {
        return url.matches(
                "^(https?://)(www\\.)?[a-zA-Z0-9]+\\.([a-z]{2,}){1,2}" +
                        "(/[a-zA-Z0-9]*)*(\\.[a-z]{3,4}$)?" +
                        "(\\?[a-zA-Z0-9]+=[a-zA-Z0-9]+)?($|(&[a-zA-Z0-9]+=[a-zA-Z0-9]+)+)$");
    }
}



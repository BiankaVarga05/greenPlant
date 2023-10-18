package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.enums.VoteDirection;
import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.dtos.PostDTO;
import com.greenfoxacademy.reddit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getByPageAndSize(String pageIn, String sizeIn){
        long page = Long.parseLong(pageIn);
        long size = Long.parseLong(sizeIn);

        return postRepository.findByPageAndSize(page, size);
    }

    public Iterable<Post> findAll(){
        return postRepository.findAll();
    }

    public Post createPost(PostDTO data){
        String errorMessage = getErrorForBadData(data);
        if (errorMessage != null) {
            throw new RuntimeException(errorMessage);
        }

        if (!isValid(data.getUrl())) {
            throw new RuntimeException("Invalid URL");
        }

        Post post = new Post(data.getTitle(), data.getUrl());
        postRepository.save(post);
        return post;
    }

    public Post voteForPost (String idText, VoteDirection direction){
        String errorMessage = getErrorForBadId(idText);
        if (errorMessage != null) {
            throw new RuntimeException(errorMessage);
        }

        Long id = Long.parseLong(idText);
        Post post = postRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No post with provided id " + id + " exists"));


        post.setScore(post.getScore() + (direction == VoteDirection.UP ? 1 :-1));
        postRepository.save(post);
        return post;
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

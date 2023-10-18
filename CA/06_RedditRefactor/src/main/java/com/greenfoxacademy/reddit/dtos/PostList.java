package com.greenfoxacademy.reddit.dtos;

import com.greenfoxacademy.reddit.model.Post;

import java.util.List;

public class PostList {
    private List<Post> posts;

    public PostList(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

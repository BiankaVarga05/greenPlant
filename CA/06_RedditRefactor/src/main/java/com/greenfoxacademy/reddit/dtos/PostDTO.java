package com.greenfoxacademy.reddit.dtos;

public class PostDTO {
    private String title;
    private String url;

    public PostDTO() {
    }

    public PostDTO(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

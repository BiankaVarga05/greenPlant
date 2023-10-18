package com.greenfoxacademy.reddit.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleError {
    @JsonProperty("error-message")
    private final String message;

    public SimpleError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

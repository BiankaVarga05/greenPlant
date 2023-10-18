package com.example.movietracker.dtos;

public class MovieDTO {
    private String title;
    private String genre;
    private Integer rating;

    public MovieDTO(String title, String genre, Integer rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getRating() {
        return rating;
    }
}

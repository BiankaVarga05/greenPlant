package com.example.movietracker.controllers;

import com.example.movietracker.dtos.MovieDTO;
import com.example.movietracker.models.ErrorMessage;
import com.example.movietracker.models.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @PersistenceContext
    private EntityManager entityManager;

    //public MovieController(){}

    @Transactional
    @PostMapping(path = "/api/movies")
    public ResponseEntity<?> addMovie(@RequestBody MovieDTO movieDTO){
        // nullcheck
        if(movieDTO.getTitle() == null || movieDTO.getRating() == null){
            ErrorMessage errorMessage = new ErrorMessage("Please provide a title and/or rating");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        // title is used
        Query query = entityManager.createNativeQuery("SELECT * FROM movies WHERE title = '" + movieDTO.getTitle() + "'", Movie.class);
        List<Movie> movies = query.getResultList();
        if(!movies.isEmpty()) {
            ErrorMessage errorMessage = new ErrorMessage("Title is already in use!");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        // raing outside of the range
        if(movieDTO.getRating() < 1 || movieDTO.getRating() > 5){
            ErrorMessage errorMessage = new ErrorMessage("Rating must be between 1-5!");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        // genre is empty
        if(movieDTO.getGenre() == null || movieDTO.getGenre().equals("")){
            movieDTO.setGenre("unknown");
        }

        Movie movie =
                new Movie(movieDTO.getTitle(), movieDTO.getGenre(), movieDTO.getRating());
        entityManager.persist(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping(path = "/api/movies")
    public ResponseEntity<?> getAllMovies(@RequestParam String order){
        if(!(order.equals("title") || order.equals("rating"))){
            ErrorMessage errorMessage = new ErrorMessage("Only title or rating is expected!");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        Query query = entityManager.createNativeQuery("SELECT * FROM movies ORDER BY " + order + " ASC", Movie.class);
        List<Movie> movies = query.getResultList();
        List<MovieDTO> moviesWithoutId = new ArrayList<>();
        for (Movie movie : movies){
            MovieDTO movieWithoutId = new MovieDTO(movie.getTitle(), movie.getGenre(), movie.getRating());
            moviesWithoutId.add(movieWithoutId);
        }
        return new ResponseEntity<>(moviesWithoutId, HttpStatus.OK);
    }

}

package com.ironhack.movieinfoservice.controller;

import com.ironhack.movieinfoservice.model.Movie;
import com.ironhack.movieinfoservice.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
@Slf4j
public class MovieController {

    @Autowired
    public MovieRepository movieRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/movies/{movieId}")
    @ResponseStatus(HttpStatus.OK)
    public Movie getMovieInfo(@PathVariable String movieId) {
        log.info("Running in port - " + port);
        return movieRepository.findById(movieId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
    }

    @GetMapping("/movies/test")
    @ResponseStatus(HttpStatus.OK)
    public String getMovieInfo() {
        log.info("Running in port - " + port);
        return port;
    }
}

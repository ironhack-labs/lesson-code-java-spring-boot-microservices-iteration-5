package com.ironhack.moviecatalogservice.client;

import com.ironhack.moviecatalogservice.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("movie-info-service")
public interface MovieInfoService {
    @GetMapping("/api/movies/{movieId}")
    Movie getMovieInfo(@PathVariable String movieId);

    @GetMapping("/api/movies/test")
    String getMovieInfo();
}

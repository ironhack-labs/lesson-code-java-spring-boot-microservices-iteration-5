package com.ironhack.moviecatalogservice.service.impl;

import com.ironhack.moviecatalogservice.client.MovieInfoService;
import com.ironhack.moviecatalogservice.client.RatingsDataService;
import com.ironhack.moviecatalogservice.model.*;
import com.ironhack.moviecatalogservice.service.interfaces.CatalogServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CatalogService implements CatalogServiceInterface {

    @Autowired
    private MovieInfoService movieInfoService;

    @Autowired
    private RatingsDataService ratingsDataService;

    public Catalog getCatalog(int userId) {
        User user = ratingsDataService.getUserById(userId);
        UserRating userRatings = ratingsDataService.getUserRatings(userId);
        String port = movieInfoService.getMovieInfo();
        log.info("Movie Service Running in port - " + port);
        Catalog catalog = new Catalog();
        catalog.setUsername(user.getUsername());
        List<MovieRating> movieRatings = new ArrayList<>();

        //Loop over all user ratings and get the movie information for each rating
        for (Rating rating : userRatings.getRatings()) {
            Movie movie = movieInfoService.getMovieInfo(rating.getMovieId());
            movieRatings.add(new MovieRating(movie.getName(), movie.getDescription(), rating.getRating()));
        }

        catalog.setMovieRatings(movieRatings);
        return catalog;
    }
}

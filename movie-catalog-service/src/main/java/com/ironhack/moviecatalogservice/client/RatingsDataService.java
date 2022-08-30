package com.ironhack.moviecatalogservice.client;

import com.ironhack.moviecatalogservice.model.Rating;
import com.ironhack.moviecatalogservice.model.User;
import com.ironhack.moviecatalogservice.model.UserRating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("ratings-data-service")
public interface RatingsDataService {
    @GetMapping("/api/ratings")
    List<Rating> getRatings(@RequestParam Optional<String> movieId);

    @GetMapping("/api/users/{userId}/ratings")
    UserRating getUserRatings(@PathVariable int userId);

    @GetMapping("/api/users/{userId}")
    User getUserById(@PathVariable int userId);
}

package com.ironhack.moviecatalogservice.controller;

import com.ironhack.moviecatalogservice.model.*;

import com.ironhack.moviecatalogservice.service.interfaces.CatalogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CatalogController {

    @Autowired
    private CatalogServiceInterface catalogService;

    @GetMapping("/catalogs/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public Catalog getCatalog(@PathVariable int userId) {
        return catalogService.getCatalog(userId);
    }
}

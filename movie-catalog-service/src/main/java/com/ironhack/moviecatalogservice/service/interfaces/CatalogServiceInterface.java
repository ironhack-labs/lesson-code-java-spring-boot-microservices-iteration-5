package com.ironhack.moviecatalogservice.service.interfaces;

import com.ironhack.moviecatalogservice.model.Catalog;

public interface CatalogServiceInterface {
    Catalog getCatalog(int userId);
}

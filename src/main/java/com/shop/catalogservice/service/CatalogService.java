package com.shop.catalogservice.service;

import com.shop.catalogservice.dto.ResponseCatalog;

import java.util.List;

public interface CatalogService {
    List<ResponseCatalog> findAll();
}

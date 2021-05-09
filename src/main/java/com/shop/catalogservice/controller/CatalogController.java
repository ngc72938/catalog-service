package com.shop.catalogservice.controller;

import com.shop.catalogservice.dto.ResponseDTO;
import com.shop.catalogservice.service.CatalogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/catalog-service")
public class CatalogController {
    private final Environment environment;
    private final CatalogService catalogService;

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in Catalog Service on Port "+ environment.getProperty("local.server.port");
    }

    @GetMapping("/welcome")
    public String welcome() {
        return environment.getProperty("greeting.message");
    }

    @GetMapping("/catalogs")
    public ResponseEntity<Map<String, Object>> getCatalogs() {
        var responseCatalogs = catalogService.findAll();

        var responseDto = new ResponseDTO("상품 조회 성공", responseCatalogs).getResponseEntity();

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }




}

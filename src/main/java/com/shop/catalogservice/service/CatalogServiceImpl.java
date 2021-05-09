package com.shop.catalogservice.service;

import com.shop.catalogservice.dto.ResponseCatalog;
import com.shop.catalogservice.repository.CatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService{
    private final CatalogRepository catalogRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ResponseCatalog> findAll() {
        var catalogList = catalogRepository.findAll();
        var responseCatalogList = new ArrayList<ResponseCatalog>();

        catalogList.forEach(catalog ->
            responseCatalogList.add(
                modelMapper.map(catalog, ResponseCatalog.class)))
            ;

        return responseCatalogList;
    }
}

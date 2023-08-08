package com.princeton.catalogservice.service;

import com.princeton.catalogservice.dto.response.ResponseCatalogDto;
import com.princeton.catalogservice.entity.Catalog;
import com.princeton.catalogservice.repository.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.princeton.catalogservice.mapper.CatalogMapper.*;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    @Override
    public List<ResponseCatalogDto> getCatalogs() {
        List<Catalog> findCatalogs = catalogRepository.findAll();

        return findCatalogs.stream()
                .map(INSTANCE::entityToResponseCatalogDto)
                .toList();
    }
}

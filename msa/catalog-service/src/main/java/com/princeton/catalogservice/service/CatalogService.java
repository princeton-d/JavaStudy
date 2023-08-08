package com.princeton.catalogservice.service;

import com.princeton.catalogservice.dto.response.ResponseCatalogDto;

import java.util.List;

public interface CatalogService {

    List<ResponseCatalogDto> getCatalogs();

}

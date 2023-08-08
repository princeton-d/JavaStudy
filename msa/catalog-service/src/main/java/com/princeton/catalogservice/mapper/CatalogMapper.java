package com.princeton.catalogservice.mapper;

import com.princeton.catalogservice.dto.response.ResponseCatalogDto;
import com.princeton.catalogservice.entity.Catalog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CatalogMapper {

    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);

    ResponseCatalogDto entityToResponseCatalogDto(Catalog catalog);

}

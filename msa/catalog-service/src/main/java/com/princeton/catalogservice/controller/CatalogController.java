package com.princeton.catalogservice.controller;

import com.princeton.catalogservice.dto.response.ResponseCatalogDto;
import com.princeton.catalogservice.global.response.ResponseDataDto;
import com.princeton.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/catalog-service")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("/catalogs")
    public ResponseEntity<ResponseDataDto<List<ResponseCatalogDto>>> getCatalogs() {
        List<ResponseCatalogDto> responseCatalogDtos = catalogService.getCatalogs();

        return ResponseEntity
                .status(OK)
                .body(new ResponseDataDto<>(responseCatalogDtos));
    }

}

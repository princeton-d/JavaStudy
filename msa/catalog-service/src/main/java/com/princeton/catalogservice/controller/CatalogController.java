package com.princeton.catalogservice.controller;

import com.princeton.catalogservice.dto.response.ResponseCatalogDto;
import com.princeton.catalogservice.global.response.ResponseDataDto;
import com.princeton.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/catalogs/{testNumber}")
    public ResponseEntity<ResponseDataDto<Map<Integer, String>>> getTest(@PathVariable Integer testNumber) {
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(testNumber, "testValue");

        return ResponseEntity.status(OK).body(new ResponseDataDto<>(testMap));
    }

}

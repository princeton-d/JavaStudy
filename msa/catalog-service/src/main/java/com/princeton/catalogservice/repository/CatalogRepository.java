package com.princeton.catalogservice.repository;

import com.princeton.catalogservice.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {

    List<Catalog> findAll();

}

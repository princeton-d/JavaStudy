package com.princeton.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ItemRepository extends ElasticsearchRepository<ItemDocument, String> {

    List<ItemDocument> findByName(String name);

    List<ItemDocument> findByPrice(Long price);

    List<ItemDocument> findByPriceBetween(Long low, Long high);

}

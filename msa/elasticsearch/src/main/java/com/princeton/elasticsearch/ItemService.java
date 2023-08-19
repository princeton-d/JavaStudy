package com.princeton.elasticsearch;

import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ElasticsearchOperations elasticsearchOperations;

    private final ItemRepository itemRepository;

    public ItemDocument save(ItemDocument itemDocument) {
        return itemRepository.save(itemDocument);
    }

    public Iterable<ItemDocument> all() {

        return itemRepository.findAll();
    }

    public List<ItemDocument> between(Long low, Long high) {
        return itemRepository.findByPriceBetween(low, high);
    }

    public Iterable<ItemDocument> delete() {
        itemRepository.deleteAll();
        return itemRepository.findAll();
    }

    public String make() {
        for (long i = 0L; i < 10000L; i++) {
            itemRepository.save(ItemDocument.builder().name("name" + i).price(i).build());
        }

        return "OK";
    }

}

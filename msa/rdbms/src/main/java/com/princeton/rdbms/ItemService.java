package com.princeton.rdbms;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public String make() {
        for (long i = 0L; i < 10000L; i++) {
            itemRepository.save(Item.builder().name("name" + i).price(i).build());
        }

        return "OK";
    }

    public List<Item> findAllName(String name) {
        return itemRepository.findAllByName(name);
    }

    public List<Item> all() {
        return itemRepository.findAll();
    }

}

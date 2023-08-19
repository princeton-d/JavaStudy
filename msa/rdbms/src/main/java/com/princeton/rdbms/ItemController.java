package com.princeton.rdbms;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/make")
    public String make() {
        return itemService.make();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Item>> findAllName(@PathVariable String name) {
        List<Item> allName = itemService.findAllName(name);

        return ResponseEntity.status(HttpStatus.OK).body(allName);
    }

    @GetMapping("/all")
    public List<Item> test() {
        long startTime = System.currentTimeMillis();
        List<Item> all = itemService.all();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return all;
    }

}

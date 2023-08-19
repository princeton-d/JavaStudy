package com.princeton.elasticsearch;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/save")
    public ItemDocument test(@RequestBody ItemDocument itemDocument) {
        return itemService.save(itemDocument);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<ItemDocument>> test() {
        long startTime = System.currentTimeMillis();
        Iterable<ItemDocument> all = itemService.all();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

    @GetMapping
    public ResponseEntity<List<ItemDocument>> between(@RequestParam Long low, @RequestParam Long high) {
        long startTime = System.currentTimeMillis();
        List<ItemDocument> between = itemService.between(low, high);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        return ResponseEntity.status(HttpStatus.OK).body(between);
    }

    @DeleteMapping("/delete")
    public Iterable<ItemDocument> delete() {
        return itemService.delete();
    }

    @GetMapping("/make")
    public String make() {
        return itemService.make();
    }

}

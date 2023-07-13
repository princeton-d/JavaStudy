package princeton.postapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import princeton.postapi.domain.dto.request.RequestItemDto;
import princeton.postapi.domain.dto.response.ResponseAllItemDto;
import princeton.postapi.domain.dto.response.ResponseDeleteDto;
import princeton.postapi.domain.dto.response.ResponseItemDto;
import princeton.postapi.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ResponseItemDto> createItem(@RequestBody RequestItemDto requestItemDto) {
        ResponseItemDto createItem = itemService.createItem(requestItemDto);

        return ResponseEntity.ok(createItem);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ResponseItemDto> getItem(@PathVariable Long postId) {
        ResponseItemDto findItem = itemService.getItem(postId);

        return ResponseEntity.ok(findItem);
    }

    @GetMapping
    public ResponseEntity<List<ResponseAllItemDto>> getAllItems() {
        List<ResponseAllItemDto> findItems = itemService.getAllItems();

        return ResponseEntity.ok(findItems);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<ResponseItemDto> updateItem(@PathVariable Long postId, @RequestBody RequestItemDto requestDto) {
        ResponseItemDto responseDto = itemService.updateItem(postId, requestDto);

        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<ResponseDeleteDto> deleteItem(@PathVariable Long postId) {
        ResponseDeleteDto responseDto = itemService.deleteItem(postId);

        return ResponseEntity.ok(responseDto);
    }

}
package princeton.postapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import princeton.postapi.domain.dto.request.RequestItemDto;
import princeton.postapi.domain.dto.response.ResponseAllItemDto;
import princeton.postapi.domain.dto.response.ResponseDeleteDto;
import princeton.postapi.domain.dto.response.ResponseItemDto;
import princeton.postapi.domain.entity.Item;
import princeton.postapi.repository.ItemRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ResponseItemDto createItem(RequestItemDto requestDto) {
        Item createdItem = Item.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .price(requestDto.getPrice())
                .username(requestDto.getUsername())
                .build();

        Item savedItem = itemRepository.save(createdItem);

        return ResponseItemDto.builder()
                .id(savedItem.getId())
                .title(savedItem.getTitle())
                .content(savedItem.getContent())
                .price(savedItem.getPrice())
                .username(savedItem.getUsername())
                .build();
    }

    public ResponseItemDto getItem(Long postId) {
        Item findItem = findItemById(postId);

        return ResponseItemDto.builder()
                .id(findItem.getId())
                .title(findItem.getTitle())
                .content(findItem.getContent())
                .price(findItem.getPrice())
                .username(findItem.getUsername())
                .build();
    }

    public List<ResponseAllItemDto> getAllItems() {
        List<Item> findItems = itemRepository.findAll();
        List<ResponseAllItemDto> dtos = findItems.stream()
                .map(item -> ResponseAllItemDto.builder()
                        .id(item.getId())
                        .title(item.getTitle())
                        .username(item.getUsername())
                        .price(item.getPrice())
                        .build())
                .toList();

        return dtos;
    }

    public ResponseItemDto updateItem(Long postId, RequestItemDto requestDto) {
        Item findItem = findItemById(postId);
        findItem.updateItem(
                requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getPrice(),
                requestDto.getUsername()
        );

        return ResponseItemDto.builder()
                .id(findItem.getId())
                .title(findItem.getTitle())
                .content(findItem.getContent())
                .price(findItem.getPrice())
                .username(findItem.getUsername())
                .build();
    }

    public ResponseDeleteDto deleteItem(Long postId) {
        Item findItem = findItemById(postId);
        itemRepository.delete(findItem);
        String msg = "삭제완료";

        return ResponseDeleteDto.builder()
                .msg(msg)
                .build();
    }

    private Item findItemById(Long postId) {
        return itemRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("없는 게시물입니다."));
    }

}
package com.princeton.catalogservice.global.response;

import lombok.*;

import static lombok.AccessLevel.*;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class ResponseDataDto<T> {

    private T data;

    public ResponseDataDto(T data) {
        this.data = data;
    }
}

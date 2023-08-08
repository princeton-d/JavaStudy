package com.princeton.catalogservice.dto.request;

import lombok.*;

import java.io.Serializable;

import static lombok.AccessLevel.*;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class RequestCatalogDto implements Serializable {

    private Integer productUid;
    private Integer quantity;
    private Integer price;
    private Integer totalPrice;

    private String orderUid;
    private String memberUid;

}

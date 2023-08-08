package com.princeton.catalogservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class Catalog implements Serializable {

    @Id
    @Column(name = "catalog_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String productUid;
    private String name;
    private Integer stock;
    private Integer price;

}

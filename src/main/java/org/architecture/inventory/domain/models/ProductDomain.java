package org.architecture.inventory.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class ProductDomain {
    private String uuid;
    private String name;
    private Integer price;
    private Integer stock;

    public ProductDomain(String name, Integer price, Integer stock) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

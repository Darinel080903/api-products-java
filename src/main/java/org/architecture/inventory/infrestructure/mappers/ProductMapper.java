package org.architecture.inventory.infrestructure.mappers;

import lombok.Getter;
import lombok.Setter;
import org.architecture.inventory.domain.models.ProductDomain;
import org.architecture.inventory.infrestructure.entity.ProductsEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter @Setter
public class ProductMapper {
    public ProductDomain toDomain (ProductsEntity productsEntity) {
        return new ProductDomain(productsEntity.getName(), productsEntity.getPrice(), productsEntity.getStock());
    }

    public ProductsEntity toDBo (ProductDomain productDomain) {
        ProductsEntity productsEntity = new ProductsEntity();
        productsEntity.setName(productDomain.getName());
        productsEntity.setPrice(productDomain.getPrice());
        productsEntity.setStock(productDomain.getStock());
        return productsEntity;
    }
}

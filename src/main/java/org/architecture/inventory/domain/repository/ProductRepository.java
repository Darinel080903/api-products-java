package org.architecture.inventory.domain.repository;

import org.architecture.inventory.domain.models.ProductDomain;

import java.util.List;

public interface ProductRepository {
    ProductDomain create(ProductDomain productDomain);
    List<ProductDomain> findAll();
    void deleteById(String uuid);
}

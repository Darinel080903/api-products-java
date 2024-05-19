package org.architecture.inventory.domain.repository;

import org.architecture.inventory.domain.models.ProductDomain;

import java.util.List;

public interface ProductRepository {
    ProductDomain create(ProductDomain productDomain);
    List<ProductDomain> findAll();
    ProductDomain update(ProductDomain productDomain, String uuid);
    ProductDomain getById(String uuid);
    void deleteById(String uuid);
}

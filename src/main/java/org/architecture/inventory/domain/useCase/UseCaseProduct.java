package org.architecture.inventory.domain.useCase;

import org.architecture.inventory.domain.models.ProductDomain;

import java.util.List;

public interface UseCaseProduct {
    List<ProductDomain> findAll();
    List<ProductDomain> create(List<ProductDomain> productDomain);
    List<ProductDomain> update(List<ProductDomain> productDomain);
    ProductDomain getById(String uuid);
    void deleteById(String uuid);
}

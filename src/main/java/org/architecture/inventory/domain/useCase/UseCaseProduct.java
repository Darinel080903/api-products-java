package org.architecture.inventory.domain.useCase;

import org.architecture.inventory.domain.models.ProductDomain;

import java.util.List;

public interface UseCaseProduct {
    List<ProductDomain> findAll();
    List<ProductDomain> create(List<ProductDomain> productDomain);
    void deleteById(String uuid);
}

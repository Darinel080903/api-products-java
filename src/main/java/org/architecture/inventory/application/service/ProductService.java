package org.architecture.inventory.application.service;

import org.architecture.inventory.domain.models.ProductDomain;
import org.architecture.inventory.domain.repository.ProductRepository;
import org.architecture.inventory.domain.useCase.UseCaseProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements UseCaseProduct {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDomain> findAll() {
        var products = productRepository.findAll();
        return products.stream().toList();
    }

    @Override
    public List<ProductDomain> create(List<ProductDomain> productDomains) {
        List<ProductDomain> createdProducts = new ArrayList<>();
        for (ProductDomain productDomain : productDomains) {
            ProductDomain createdProduct = productRepository.create(productDomain);
            createdProducts.add(createdProduct);
        }
        return createdProducts;
    }

    @Override
    public void deleteById(String uuid) {
        productRepository.deleteById(uuid);
    }
}

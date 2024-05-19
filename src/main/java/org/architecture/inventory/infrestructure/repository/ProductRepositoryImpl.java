package org.architecture.inventory.infrestructure.repository;


import jakarta.transaction.Transactional;
import org.architecture.inventory.domain.models.ProductDomain;
import org.architecture.inventory.domain.repository.ProductRepository;
import org.architecture.inventory.infrestructure.mappers.ProductMapper;
import org.architecture.inventory.infrestructure.repository.JPA.ProductJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductMapper ProductMapper;

    public ProductRepositoryImpl(ProductJpaRepository productJpaRepository, org.architecture.inventory.infrestructure.mappers.ProductMapper productMapper) {
        this.productJpaRepository = productJpaRepository;
        this.ProductMapper = productMapper;
    }

    @Override
    public ProductDomain create(ProductDomain productDomain) {
        var ProductToSave = ProductMapper.toDBo(productDomain);
        var ProductSaved = productJpaRepository.save(ProductToSave);
        return ProductMapper.toDomain(ProductSaved);
    }

    @Override
    public List<ProductDomain> findAll() {
        return productJpaRepository.findAll()
                .stream()
                .map(ProductMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(String uuid) {
        productJpaRepository.deleteById(uuid);
    }
}

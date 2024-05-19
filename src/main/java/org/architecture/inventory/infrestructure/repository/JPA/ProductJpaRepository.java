package org.architecture.inventory.infrestructure.repository.JPA;

import org.architecture.inventory.infrestructure.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductsEntity, String> {

}

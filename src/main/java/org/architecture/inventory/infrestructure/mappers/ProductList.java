package org.architecture.inventory.infrestructure.mappers;

import lombok.Getter;
import lombok.Setter;
import org.architecture.inventory.domain.models.ProductDomain;
import java.util.List;

@Getter @Setter
public class ProductList {
    private List<ProductDomain> products;

}
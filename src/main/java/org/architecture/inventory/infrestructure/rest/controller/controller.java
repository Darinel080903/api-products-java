package org.architecture.inventory.infrestructure.rest.controller;

import org.architecture.inventory.application.service.ProductService;
import org.architecture.inventory.domain.models.ProductDomain;
import org.architecture.inventory.infrestructure.entity.ProductsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class controller {
    private final ProductService productService;

    @Autowired
    public controller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDomain> findAll(){
        return productService.findAll();
    }

    @PostMapping("/create")
    public List<ProductDomain> create(@RequestBody List<ProductDomain> productDomain){
        return productService.create(productDomain);
    }

    @DeleteMapping("/delete/{uuid}")
    public void deleteById(@PathVariable String uuid){
        productService.deleteById(uuid);
    }
}

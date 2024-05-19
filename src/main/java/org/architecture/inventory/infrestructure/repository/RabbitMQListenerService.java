package org.architecture.inventory.infrestructure.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.architecture.inventory.application.service.ProductService;
import org.architecture.inventory.domain.models.ProductDomain;
import org.architecture.inventory.infrestructure.mappers.ProductList;
import org.architecture.inventory.infrestructure.mappers.ProductMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class RabbitMQListenerService {

    private final ProductService productService;
    private final ObjectMapper objectMapper;

    public RabbitMQListenerService(ProductService productService, ObjectMapper objectMapper) {
        this.productService = productService;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "order_update")
    public void listen(String message) {
        try {
            ProductList productList = objectMapper.readValue(message, ProductList.class);
            List<ProductDomain> productDomains = productList.getProducts();
            productService.update(productDomains);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
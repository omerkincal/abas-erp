package org.omarkincal.abaserpinterview.service;

import org.omarkincal.abaserpinterview.dto.ProductDto;
import org.omarkincal.abaserpinterview.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl {
    private OrderRepository repository;
    private ProductServiceImpl productService;
    public OrderServiceImpl(OrderRepository repository, ProductServiceImpl productService) {
        this.repository = repository;
        this.productService = productService;
    }

    public List<ProductDto> getAllProductsByOrderId(Integer orderId) {
        return productService.getAllByOrderId(orderId);
    }
}

package org.omarkincal.abaserpinterview.controller;

import org.omarkincal.abaserpinterview.controller.mapper.ProductMapper;
import org.omarkincal.abaserpinterview.response.ProductResponse;
import org.omarkincal.abaserpinterview.service.OrderServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("orders")
public class OrderController {
    private OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping("{orderId}")
    public List<ProductResponse> getAllProductsByOrderId(@PathVariable Integer orderId) {
        return orderService.getAllProductsByOrderId(orderId)
                .stream()
                .map(productDto -> ProductMapper.toResponse(productDto))
                .collect(Collectors.toList());
    }
}

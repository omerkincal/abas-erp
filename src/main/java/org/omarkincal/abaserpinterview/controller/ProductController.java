package org.omarkincal.abaserpinterview.controller;

import org.omarkincal.abaserpinterview.controller.mapper.ProductMapper;
import org.omarkincal.abaserpinterview.request.ProductRequest;
import org.omarkincal.abaserpinterview.response.ProductResponse;
import org.omarkincal.abaserpinterview.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductServiceImpl productService;
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
        productService.calculateTotalAmountOfAllProducts();
        productService.calculateAveragePriceOfAllProducts();
        productService.calculateAveragePriceBasedOnProduct();
        productService.calculateProductQuantityAccordingToOrder();
    }

    // 2. soru
    @GetMapping
    public List<ProductResponse> getAll() {
        return productService.getAll().stream()
                .map(product -> ProductMapper.toResponse(product))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest request) {
        return ProductMapper.toResponse(productService.create(ProductMapper.toDto(request)));
    }


}

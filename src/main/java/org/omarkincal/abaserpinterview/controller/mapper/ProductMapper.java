package org.omarkincal.abaserpinterview.controller.mapper;

import org.omarkincal.abaserpinterview.dto.ProductDto;
import org.omarkincal.abaserpinterview.entity.Product;
import org.omarkincal.abaserpinterview.request.ProductRequest;
import org.omarkincal.abaserpinterview.response.ProductResponse;

public class ProductMapper {
    public ProductMapper() {

    }

    public static ProductDto toDto(ProductRequest request) {
        return ProductDto.builder()
                .quantity(request.getQuantity())
                .productNo(request.getProductNo())
                .unitPrice(request.getUnitPrice())
                .orderId(request.getOrderId())
                .build();
    }

    public static ProductResponse toResponse(ProductDto product) {
        return ProductResponse.builder()
                .id(product.getId())
                .productNo(product.getProductNo())
                .orderId(product.getOrderId())
                .unitPrice(product.getUnitPrice())
                .quantity(product.getQuantity())
                .build();
    }
}

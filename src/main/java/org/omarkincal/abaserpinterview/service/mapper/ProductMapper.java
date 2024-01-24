package org.omarkincal.abaserpinterview.service.mapper;

import org.omarkincal.abaserpinterview.dto.ProductDto;
import org.omarkincal.abaserpinterview.entity.Product;

public class ProductMapper {
    public ProductMapper() {

    }

    public static Product toEntity(Product product, ProductDto productDto) {
        product.setProductNo(productDto.getProductNo());
        product.setUnitPrice(productDto.getUnitPrice());
        product.setQuantity(productDto.getQuantity());
        product.setOrderId(productDto.getOrderId());
        return product;
    }

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .productNo(product.getProductNo())
                .orderId(product.getOrderId())
                .unitPrice(product.getUnitPrice())
                .quantity(product.getQuantity())
                .build();
    }
}

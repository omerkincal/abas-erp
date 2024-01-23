package org.omarkincal.abaserpinterview.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int id;
    private int productNo;
    private int quantity;
    private double unitPrice;
    private int orderId;
}

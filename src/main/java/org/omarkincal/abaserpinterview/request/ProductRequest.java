package org.omarkincal.abaserpinterview.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private int productNo;
    private int quantity;
    private double unitPrice;
    private int orderId;
}

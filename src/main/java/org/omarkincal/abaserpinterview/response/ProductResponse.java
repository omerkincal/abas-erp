package org.omarkincal.abaserpinterview.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private int id;
    private int productNo;
    private int quantity;
    private double unitPrice;
    private int orderId;
}

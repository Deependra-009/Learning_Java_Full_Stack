package com.shopping.product_service.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private Long productID;
    private String productName;
    private String productPrice;
    private String productQuantity;

}

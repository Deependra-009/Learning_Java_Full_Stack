package com.shopping.order_service.dto;

import com.shopping.order_service.enums.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private PaymentMode paymentMode;
    private List<ProductsListRequest> productsList;

}

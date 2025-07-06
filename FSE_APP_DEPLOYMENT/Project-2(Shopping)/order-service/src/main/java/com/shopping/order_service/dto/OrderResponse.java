package com.shopping.order_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.shopping.order_service.dto.payment.PaymentReceiptResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {

    private Long id;
    private String orderID;
    private List<ProductResponse> products;
    private PaymentReceiptResponse paymentReceiptResponse;

}

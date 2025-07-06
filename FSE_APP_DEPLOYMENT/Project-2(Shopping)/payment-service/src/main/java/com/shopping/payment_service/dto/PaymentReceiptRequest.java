package com.shopping.payment_service.dto;

import com.shopping.payment_service.enums.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentReceiptRequest {

    private PaymentMode paymentMode;
    private String totalAmount;
    private String orderId;

}

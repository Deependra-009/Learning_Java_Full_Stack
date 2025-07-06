package com.shopping.payment_service.dto;

import com.shopping.payment_service.enums.PaymentMode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentReceiptResponse {
    private String referenceId;
    private String orderId;
    private String totalAmount;
    private PaymentMode paymentMode;
}

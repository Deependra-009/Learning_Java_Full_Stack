package com.shopping.order_service.dto.payment;

import com.shopping.order_service.enums.PaymentMode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentReceiptRequest {

    private PaymentMode paymentMode;
    private String totalAmount;
    private String orderId;

}

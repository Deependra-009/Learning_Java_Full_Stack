package com.shopping.order_service.feignClient;

import com.shopping.order_service.dto.payment.PaymentReceiptRequest;
import com.shopping.order_service.dto.payment.PaymentReceiptResponse;
import com.shopping.order_service.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceFallback implements PaymentServiceFeignClient {

    @Override
    public ResponseEntity<PaymentReceiptResponse> generatePaymentReceipt(PaymentReceiptRequest request) {
        throw new CustomException("Payment Service is unavailable: " , "UNAVAILABLE", 503);
    }
}

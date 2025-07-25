package com.shopping.order_service.feignClient;

import com.shopping.order_service.dto.payment.PaymentReceiptRequest;
import com.shopping.order_service.dto.payment.PaymentReceiptResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "PAYMENT-SERVICE",
        fallback = PaymentServiceFallback.class
)
public interface PaymentServiceFeignClient {

    @PostMapping("/payment/generate-receipt")
    public ResponseEntity<PaymentReceiptResponse> generatePaymentReceipt(@RequestBody PaymentReceiptRequest paymentReceiptRequest);

}

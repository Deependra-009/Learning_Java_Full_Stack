package com.shopping.payment_service.controller;

import com.shopping.payment_service.dto.PaymentReceiptRequest;
import com.shopping.payment_service.dto.PaymentReceiptResponse;
import com.shopping.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/generate-receipt")
    public ResponseEntity<PaymentReceiptResponse> generatePaymentReceipt(@RequestBody PaymentReceiptRequest paymentReceiptRequest){
        return new ResponseEntity<>(this.paymentService.generatePaymentReceipt(paymentReceiptRequest), HttpStatus.CREATED);
    }

}

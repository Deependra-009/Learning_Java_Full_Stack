package com.shopping.payment_service.service;

import com.shopping.payment_service.dto.PaymentReceiptRequest;
import com.shopping.payment_service.dto.PaymentReceiptResponse;
import com.shopping.payment_service.entity.PaymentEntity;
import com.shopping.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentReceiptResponse generatePaymentReceipt(PaymentReceiptRequest paymentReceiptRequest){
        PaymentEntity paymentEntity=PaymentEntity
                .builder()
                .paymentMode(paymentReceiptRequest.getPaymentMode())
                .referenceId(UUID.randomUUID().toString())
                .orderId(paymentReceiptRequest.getOrderId())
                .totalAmount(paymentReceiptRequest.getTotalAmount())
                .build();

        this.paymentRepository.save(paymentEntity);

        return PaymentReceiptResponse
                .builder()
                .orderId(paymentReceiptRequest.getOrderId())
                .referenceId(paymentEntity.getReferenceId())
                .totalAmount(paymentEntity.getTotalAmount())
                .paymentMode(paymentReceiptRequest.getPaymentMode())
                .build();


    }

}

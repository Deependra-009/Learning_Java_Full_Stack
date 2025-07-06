package com.shopping.payment_service.entity;

import com.shopping.payment_service.enums.PaymentMode;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;

    private String referenceId;
    private String orderId;
    private String totalAmount;
    private PaymentMode paymentMode;

}

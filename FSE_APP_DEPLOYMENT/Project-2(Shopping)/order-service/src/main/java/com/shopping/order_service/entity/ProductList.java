package com.shopping.order_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class ProductList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderProductsID;
    private Long productID;
    private String quantity;
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

}

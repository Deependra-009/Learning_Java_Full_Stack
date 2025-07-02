package com.shopping.order_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ProductList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderProductsID;
    private Long productID;
    private String quantity;

    @ManyToOne
    private OrderEntity orderEntity;

}

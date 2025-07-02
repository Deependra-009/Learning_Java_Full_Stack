package com.shopping.order_service.entity;

import com.shopping.order_service.dto.ProductResponse;
import com.shopping.order_service.dto.ProductsListRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderID;

    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    private List<ProductList> productsList;

}

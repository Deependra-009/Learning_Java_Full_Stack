package com.shopping.order_service.repository;

import com.shopping.order_service.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

    @Query("SELECT p FROM OrderEntity p WHERE p.orderID=:orderId")
    public OrderEntity getOrderDetails(@Param("orderId") String orderId);


}

package com.shopping.order_service.repository;

import com.shopping.order_service.entity.OrderEntity;
import com.shopping.order_service.entity.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductListRepository extends JpaRepository<ProductList,Long> {

}

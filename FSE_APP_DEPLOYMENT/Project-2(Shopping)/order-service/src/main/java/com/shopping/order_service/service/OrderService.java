package com.shopping.order_service.service;

import com.shopping.order_service.dto.OrderRequest;
import com.shopping.order_service.dto.OrderResponse;
import com.shopping.order_service.dto.ProductResponse;
import com.shopping.order_service.dto.ProductsListRequest;
import com.shopping.order_service.feignClient.ProductServiceFeignClient;
import com.shopping.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private ProductServiceFeignClient productService;

    @Autowired
    private OrderRepository orderRepository;

    public OrderResponse placeOrder(OrderRequest orderRequest){

        List<ProductResponse> productResponses=new ArrayList<>();

        for(ProductsListRequest productsListRequest:orderRequest.getProductsList()){
            productResponses.add(this.productService.updateInventory(productsListRequest).getBody());
        }



        return OrderResponse.builder()
                
                .build();

    }

}

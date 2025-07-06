package com.shopping.order_service.controller;

import com.shopping.order_service.dto.OrderRequest;
import com.shopping.order_service.dto.OrderResponse;
import com.shopping.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/test-api")
    public String testAPI(){
        return "ORDER-API FINE";
    }

    @PostMapping("/place-order")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        return new ResponseEntity<>(this.orderService.placeOrder(orderRequest), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-order/{id}")
    public ResponseEntity<OrderResponse> getOrdeDetails(@PathVariable("id") String orderId) throws Exception {
        return new ResponseEntity<>(this.orderService.getOrdeDetails(orderId),HttpStatus.OK);
    }



}

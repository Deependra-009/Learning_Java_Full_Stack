package com.shopping.order_service.service;

import com.shopping.order_service.dto.OrderRequest;
import com.shopping.order_service.dto.OrderResponse;
import com.shopping.order_service.dto.ProductResponse;
import com.shopping.order_service.dto.ProductsListRequest;
import com.shopping.order_service.dto.payment.PaymentReceiptRequest;
import com.shopping.order_service.dto.payment.PaymentReceiptResponse;
import com.shopping.order_service.entity.OrderEntity;
import com.shopping.order_service.entity.ProductList;
import com.shopping.order_service.enums.PaymentMode;
import com.shopping.order_service.exception.CustomException;
import com.shopping.order_service.feignClient.PaymentServiceFeignClient;
import com.shopping.order_service.feignClient.ProductServiceFeignClient;
import com.shopping.order_service.repository.OrderRepository;
import com.shopping.order_service.repository.ProductListRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private ProductServiceFeignClient productService;

    @Autowired
    private PaymentServiceFeignClient paymentServiceFeignClient;

    @Autowired
    private ProductListRepository productListRepository;

    @Autowired
    private OrderRepository orderRepository;


    public OrderResponse placeOrder(OrderRequest orderRequest){

        List<ProductResponse> productResponses=new ArrayList<>();

        // Update Inventory
        for(ProductsListRequest productsListRequest:orderRequest.getProductsList()){
            productResponses.add(this.productService.updateInventory(productsListRequest).getBody());
        }

        // Step 1: Create the order entity first (without saving yet)
        OrderEntity orderEntity = OrderEntity.builder()
                .orderID(UUID.randomUUID().toString())
                .build();

        // Step 2: Create and associate ProductList entities
        List<ProductList> productLists = new ArrayList<>();
        double totalAmount=0;
        for (ProductResponse productResponse : productResponses) {
            totalAmount+= Double.parseDouble(productResponse.getProductPrice());
            ProductList product = ProductList.builder()
                    .productID(productResponse.getProductID())
                    .price(productResponse.getProductPrice())
                    .quantity(productResponse.getProductQuantity())
                    .orderEntity(orderEntity) // associate with orderEntity here!
                    .build();

            productLists.add(product);
        }

        // Step 3: Set the product list in the order entity
        orderEntity.setProductsList(productLists);

        // Step 4: Save the order (cascading will save all ProductList too)
        orderEntity = this.orderRepository.save(orderEntity);

        // Step 5: Payment receipt generated
        PaymentReceiptRequest request = PaymentReceiptRequest.builder()
                .totalAmount(String.valueOf(totalAmount))
                .orderId(orderEntity.getOrderID())
                .paymentMode(orderRequest.getPaymentMode())
                .build();

        PaymentReceiptResponse paymentReceiptResponse = generatePaymentReceipt(request);

        return OrderResponse.builder()
                .orderID(orderEntity.getOrderID())
                .products(productResponses)
                .paymentReceiptResponse(paymentReceiptResponse)
                .build();
    }

    public PaymentReceiptResponse generatePaymentReceipt(PaymentReceiptRequest request){
        return this.paymentServiceFeignClient.generatePaymentReceipt(request).getBody();
    }

    public OrderResponse getOrdeDetails(String orderId) throws Exception {

        OrderEntity orderEntity = this.orderRepository.getOrderDetails(orderId);

        List<ProductResponse> productResponseList = new ArrayList<>();

        for(ProductList productList:orderEntity.getProductsList()){
            ProductResponse productResponse=this.productService.getProductDetails(productList.getProductID()).getBody();
            productResponseList.add(productResponse);
        }

        return OrderResponse.builder()
                .orderID(orderEntity.getOrderID())
                .products(productResponseList)
                .build();


    }


}

package com.shopping.order_service.feignClient;

import com.shopping.order_service.dto.ProductResponse;
import com.shopping.order_service.dto.ProductsListRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductServiceFeignClient {

    @PostMapping("/update-inventory")
    public ResponseEntity<ProductResponse> updateInventory(@RequestBody ProductsListRequest productListRequest);

}

package com.shopping.order_service.feignClient;

import com.shopping.order_service.dto.ProductResponse;
import com.shopping.order_service.dto.ProductsListRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductServiceFeignClient {

    @PostMapping("/product/update-inventory")
    public ResponseEntity<ProductResponse> updateInventory(@RequestBody ProductsListRequest productListRequest);

    @GetMapping("/product/get-product/{productID}")
    public ResponseEntity<ProductResponse> getProductDetails(@PathVariable("productID") Long productID) throws Exception;

}

package com.shopping.product_service.controller;

import com.shopping.product_service.dto.MessageResponse;
import com.shopping.product_service.dto.ProductListRequest;
import com.shopping.product_service.dto.ProductRequest;
import com.shopping.product_service.dto.ProductResponse;
import com.shopping.product_service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/test-api")
    public String testAPI(){
        return "PRODUCT-API FINE";
    }

    @PostMapping("/add-product")
    public ResponseEntity<MessageResponse> addProduct(@RequestBody ProductRequest productRequest){
        return new ResponseEntity<>(this.productService.addProduct(productRequest), HttpStatus.CREATED);
    }

    @GetMapping("/get-product/{productID}")
    public ResponseEntity<ProductResponse> getProductDetails(@PathVariable("productID") Long productID) throws Exception {
        return new ResponseEntity<>(this.productService.getProductDetails(productID), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-product")
    public ResponseEntity<List<ProductResponse>> getAllProduct(){
        return new ResponseEntity<>(this.productService.getAllProducts(),HttpStatus.OK);
    }

    @PostMapping("/update-inventory")
    public ResponseEntity<ProductResponse> updateInventory(@RequestBody ProductListRequest productListRequest) throws Exception {
        return new ResponseEntity<>(this.productService.updateInventory(productListRequest), HttpStatus.CREATED);
    }
}

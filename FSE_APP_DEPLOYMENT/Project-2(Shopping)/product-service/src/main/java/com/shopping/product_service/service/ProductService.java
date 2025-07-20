package com.shopping.product_service.service;

import com.shopping.product_service.dto.MessageResponse;
import com.shopping.product_service.dto.ProductListRequest;
import com.shopping.product_service.dto.ProductRequest;
import com.shopping.product_service.dto.ProductResponse;
import com.shopping.product_service.entity.ProductEntity;
import com.shopping.product_service.exception.ProductServiceCustomException;
import com.shopping.product_service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public MessageResponse addProduct(ProductRequest productRequest){

        ProductEntity productEntity=this.productRepository.save(
                ProductEntity.builder()
                        .productName(productRequest.getProductName())
                        .productPrice(productRequest.getProductPrice())
                        .productQuantity(productRequest.getProductQuantity())
                        .build()
        );

        log.info("ADD PRODUCT SUCCESSFULLY");

        return MessageResponse.builder()
                .data(
                        ProductResponse.builder()
                                .productID(productEntity.getProductID())
                                .productName(productRequest.getProductName())
                                .productPrice(productRequest.getProductPrice())
                                .productQuantity(productRequest.getProductQuantity())
                                .build()
                )
                .message("PRODUCT ADD SUCCESSFULLY")
                .build();
    }

    public ProductResponse getProductDetails(long id) throws Exception {

        ProductEntity productData=this.productRepository
                .findById(id)
                .orElseThrow(()->new ProductServiceCustomException("Product with given ID not found","PRODUCT_NOT_FOUND"));

        return ProductResponse.builder()
                .productID(productData.getProductID())
                .productName(productData.getProductName())
                .productQuantity(productData.getProductQuantity())
                .productPrice(productData.getProductPrice())
                .build();

    }

    public List<ProductResponse> getAllProducts(){
        List<ProductEntity> productEntityList=this.productRepository.findAll();

        return productEntityList.stream().map(
                product -> ProductResponse.builder()
                        .productID(product.getProductID())
                        .productName(product.getProductName())
                        .productPrice(product.getProductPrice())
                        .productQuantity(product.getProductQuantity())
                        .build()
        ).toList();
    }

    public ProductResponse updateInventory(ProductListRequest productListRequest) throws Exception{

        ProductEntity productEntity=this.productRepository.findById(productListRequest.getProductID())
                .orElseThrow(()->new ProductServiceCustomException("Product with given ID not found","PRODUCT_NOT_FOUND"));

        long productQuantity=Long.parseLong(productEntity.getProductQuantity());

        if(productQuantity<Long.parseLong(productListRequest.getQuantity())){
            throw new ProductServiceCustomException("Product does not sufficient quantity","INSUFFICIENT_QUANTITY");
        }
//        productEntity.setProductQuantity(""+(productQuantity - Long.parseLong(productListRequest.getQuantity())));
        productEntity = this.productRepository.save(productEntity);

        return ProductResponse
                .builder()
                .productID(productEntity.getProductID())
                .productName(productEntity.getProductName())
                .productPrice(productEntity.getProductPrice())
                .productQuantity(productListRequest.getQuantity())
                .build();
    }

}

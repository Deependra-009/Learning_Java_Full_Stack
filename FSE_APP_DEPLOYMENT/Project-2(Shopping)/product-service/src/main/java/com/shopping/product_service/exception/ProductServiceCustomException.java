package com.shopping.product_service.exception;

import lombok.Getter;

@Getter
public class ProductServiceCustomException extends Exception{

    private String errorCode;

    public ProductServiceCustomException(String message,String errorCode){
        super(message);
        this.errorCode=errorCode;
    }
}

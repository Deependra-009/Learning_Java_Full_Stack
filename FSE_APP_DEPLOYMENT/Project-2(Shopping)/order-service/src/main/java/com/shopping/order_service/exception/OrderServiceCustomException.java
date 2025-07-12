package com.shopping.order_service.exception;

import lombok.Getter;

@Getter
public class OrderServiceCustomException extends Exception{

    private String errorCode;

    public OrderServiceCustomException(String message, String errorCode){
        super(message);
        this.errorCode=errorCode;
    }
}

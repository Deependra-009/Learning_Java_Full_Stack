package com.shopping.order_service.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private String errorCode;
    private int status;

    public CustomException(String message,String errorCode,int status){
        super(message);
        this.errorCode=errorCode;
        this.status=status;
    }
}

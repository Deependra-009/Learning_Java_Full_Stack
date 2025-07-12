package com.shopping.product_service.exception;

import com.shopping.product_service.dto.ErrorMessage;
import com.shopping.product_service.dto.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductServiceCustomException.class)
    public ResponseEntity<ErrorMessage> handleProductServiceException(ProductServiceCustomException exception){
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .errorMessage(exception.getMessage())
                        .errorCode(exception.getErrorCode())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

}

package com.shopping.order_service.exception;

import com.shopping.order_service.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorMessage> handleCustomException(CustomException exception){
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .errorMessage(exception.getMessage())
                        .errorCode(exception.getErrorCode())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.valueOf(exception.getStatus())
        );
    }

}

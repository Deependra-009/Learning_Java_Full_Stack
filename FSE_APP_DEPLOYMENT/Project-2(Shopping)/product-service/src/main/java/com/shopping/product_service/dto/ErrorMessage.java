package com.shopping.product_service.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessage {

    private String errorMessage;
    private String errorCode;
    private LocalDateTime timestamp;
}

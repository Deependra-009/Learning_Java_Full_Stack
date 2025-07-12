package com.shopping.order_service.feignClient.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.shopping.order_service.dto.ErrorMessage;
import com.shopping.order_service.exception.CustomException;
import com.shopping.order_service.exception.OrderServiceCustomException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // ✅ fix for LocalDateTime
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Optional: Use ISO format

        log.info("::{}",response.request().url());
        log.info("::{}",response.request().headers());

        try(InputStream inputStream = response.body().asInputStream()) {
            String responseBody = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            log.error("Feign Error Response Body: {}", responseBody);

            ErrorMessage errorResponse = objectMapper.readValue(responseBody, ErrorMessage.class);
            return new CustomException(errorResponse.getErrorMessage(), errorResponse.getErrorCode(), response.status());
        } catch (IOException e) {
            throw new CustomException("Internal Server Error","INTERNAL_SERVER_ERROR",500);
        }

    }
}

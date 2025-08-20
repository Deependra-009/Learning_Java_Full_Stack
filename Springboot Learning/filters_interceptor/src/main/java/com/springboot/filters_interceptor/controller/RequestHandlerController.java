package com.springboot.filters_interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestHandlerController {

    @GetMapping("/api")
    public String requestHandler(){
        System.out.println("----------------------------");
        System.out.println("From Controller Class");
        System.out.println("----------------------------");
        return "Hi,I'm from microservice";
    }
}

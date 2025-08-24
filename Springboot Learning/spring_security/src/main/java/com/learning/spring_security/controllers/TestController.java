package com.learning.spring_security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hi")
    public String hi(){
        return "Hi Everyone";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Everyone";
    }

    @GetMapping("/bye")
    public String bye(){
        return "bye Everyone";
    }

}

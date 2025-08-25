package com.learning.spring_security.controllers;

import com.learning.spring_security.dto.LoginDTO;
import com.learning.spring_security.jwt.JwtUtility;
import com.learning.spring_security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.username(),
                loginDTO.password()
        ));

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(loginDTO.username());


        String token = this.jwtUtility.generateToken(userDetails);

        return new ResponseEntity<>(token, HttpStatus.OK);


    }

}



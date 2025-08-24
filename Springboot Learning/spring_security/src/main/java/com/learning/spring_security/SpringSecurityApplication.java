package com.learning.spring_security;

import com.learning.spring_security.entity.UserEntity;
import com.learning.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;



	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
        this.userService.createUser(
                UserEntity
                        .builder()
                        .username("deepu")
                        .password(this.passwordEncoder.encode("deepu123"))
                        .role("user")
                        .build()
        );
    }
}

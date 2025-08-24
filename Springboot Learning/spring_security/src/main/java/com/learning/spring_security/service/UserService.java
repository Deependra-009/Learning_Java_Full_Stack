package com.learning.spring_security.service;

import com.learning.spring_security.entity.UserEntity;
import com.learning.spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserEntity userEntity){
        this.userRepository.save(userEntity);
        System.out.println("USER CREATE SUCCESSFULLY");
    }

}

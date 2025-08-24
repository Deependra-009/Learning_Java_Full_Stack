package com.learning.spring_security.service;

import com.learning.spring_security.entity.UserEntity;
import com.learning.spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity=this.userRepository.findByUsername(username);

        if(userEntity==null){
            throw new RuntimeException("UsernameNotFoundException");
        }

        return userEntity;
    }
}

package com.learning.spring_security.config;

import com.learning.spring_security.constant.Permission;
import com.learning.spring_security.constant.Role;
import com.learning.spring_security.jwt.JwtAuthFilter;
import com.learning.spring_security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    JwtAuthFilter jwtAuthFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth->{
                    auth
                            .requestMatchers("/auth/**").permitAll()
                            .requestMatchers(HttpMethod.GET,"/student/get-particular-student/**").hasAuthority(Permission.READ.name())
                            .requestMatchers(HttpMethod.GET,"/student/get-all-student").hasRole(Role.ADMIN.name())
                            .requestMatchers(HttpMethod.POST,"/student/add").hasAuthority(Permission.WRITE.name())
                            .requestMatchers(HttpMethod.DELETE,"/student/delete/**").hasAuthority(Permission.DELETE.name())

                            .anyRequest().authenticated();
                });

        httpSecurity.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);


        return httpSecurity.build();

    }


    @Bean
    public AuthenticationManager authenticationManager(PasswordEncoder passwordEncoder,CustomUserDetailsService userDetailsService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(daoAuthenticationProvider);
    }

    /**
     * {@link InMemoryUserDetailsManager is used to save user in memory}
     * Internally it is using HashMap
     * */
//    @Bean
//    InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails userDetails = User.withUsername("deepu").password("deepu123").roles("user").build();
//        return new InMemoryUserDetailsManager(userDetails);
//    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

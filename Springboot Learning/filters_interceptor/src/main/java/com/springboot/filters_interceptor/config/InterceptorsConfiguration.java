package com.springboot.filters_interceptor.config;

import com.springboot.filters_interceptor.interceptors.Interceptor1;
import com.springboot.filters_interceptor.interceptors.Interceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor1())
                .addPathPatterns("/**");

        registry.addInterceptor(new Interceptor2())
                .addPathPatterns("/**");

    }
}

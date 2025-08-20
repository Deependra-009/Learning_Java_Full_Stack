package com.springboot.filters_interceptor.config;

import com.springboot.filters_interceptor.filters.Filter1;
import com.springboot.filters_interceptor.filters.Filter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiltersConfiguration {

    @Bean
    public FilterRegistrationBean<Filter1> filter1FilterRegistrationBean(){
        FilterRegistrationBean<Filter1> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new Filter1());
        registrationBean.setOrder(1);
        registrationBean.setName("Filter_1");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<Filter2> filter2FilterRegistrationBean(){
        FilterRegistrationBean<Filter2> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new Filter2());
        registrationBean.setOrder(2);
        registrationBean.setName("Filter_2");
        return registrationBean;
    }

}

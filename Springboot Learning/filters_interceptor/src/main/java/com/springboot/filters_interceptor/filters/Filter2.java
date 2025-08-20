package com.springboot.filters_interceptor.filters;

import jakarta.servlet.*;

import java.io.IOException;

public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter 2 started");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Filter 2 completed");
    }
}

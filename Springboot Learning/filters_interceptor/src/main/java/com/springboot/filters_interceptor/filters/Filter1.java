package com.springboot.filters_interceptor.filters;

import jakarta.servlet.*;

import java.io.IOException;

public class Filter1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter 1 started");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Filter 1 completed");
    }
}

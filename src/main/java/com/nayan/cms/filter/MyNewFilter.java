package com.nayan.cms.filter;

import org.springframework.stereotype.Controller;

import javax.servlet.*;
import java.io.IOException;

@Controller
public class MyNewFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("My New Filter");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}

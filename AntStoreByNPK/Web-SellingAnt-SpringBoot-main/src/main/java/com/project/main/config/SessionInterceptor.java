package com.project.main.config;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SessionInterceptor implements HandlerInterceptor {

    protected static final String[] EXCLUDED_URLS = {"/login", "/","/styles.css","/register","/store"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        // Check if the request URI is in the excluded URLs list
        for (String excludedUrl : EXCLUDED_URLS) {
            if (requestURI.equals(excludedUrl)) {
                return true; // Allow access without checking session
            }
        }

        // Check if the loggedincustomer session attribute is not null
        Object loggedInCustomer = request.getSession().getAttribute("loginCustomer");

        if (loggedInCustomer == null) {
            // Redirect to a login page or perform other actions as needed
            response.sendRedirect("/login"); // You can customize the login page URL
            return false; // Request processing should stop
        }

        // Continue processing the request
        return true;
    }
}
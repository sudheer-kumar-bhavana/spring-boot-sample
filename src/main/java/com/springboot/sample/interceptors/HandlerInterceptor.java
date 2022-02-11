package com.springboot.sample.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerInterceptor implements org.springframework.web.servlet.HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Request came for "+request.getRequestURI()
                + "\n Session Id :" + request.getSession(true).getId()  );
        long start = System.currentTimeMillis();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("Request Complete "+ request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("Response sent to Client for "+request.getRequestURI());
    }
}

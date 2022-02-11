package com.springboot.sample.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class JPACourseWebRequestInterceptor implements WebRequestInterceptor {

    Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);

    @Override
    public void preHandle(WebRequest webRequest) throws Exception {
        logger.info("\n Request came from User: "+ webRequest.getUserPrincipal().getName()
                   +"\n For URL " + webRequest.getContextPath()
                   +"\n Session Id :" + webRequest.getSessionId());
        //long start = System.currentTimeMillis();
    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {
        logger.info("\n Request complete for User: "+ webRequest.getUserPrincipal().getName()
                +"\n For URL " + webRequest.getHeader("Request URL")
                +"\n Session Id :" + webRequest.getSessionId());
    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

    }
}

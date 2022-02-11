package com.springboot.sample.configuration;

import com.springboot.sample.interceptors.HandlerInterceptor;
import com.springboot.sample.interceptors.JPACourseWebRequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new HandlerInterceptor());
        registry.addWebRequestInterceptor(new JPACourseWebRequestInterceptor()).addPathPatterns("/jpa/**");
    }
}

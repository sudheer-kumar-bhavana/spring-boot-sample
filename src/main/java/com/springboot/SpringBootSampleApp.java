package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.sample",
                               "com.springboot.data.jpa",
                               "com.springboot.misc"})
public class SpringBootSampleApp {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApp.class, args);
    }
}

package com.springboot.sample;

import com.springboot.sample.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private TopicService topicService;

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String sayHello(){
        SecurityContext sc  = SecurityContextHolder.getContext();
        String userName = null;
        if(sc != null){
            if(sc.getAuthentication().isAuthenticated()){
                userName = sc.getAuthentication().getName();
            }
        }

        if(userName != null){
            return "<p>Hello <strong>" + userName +"</strong></p>";
        }

        return null;
    }

}

package com.springboot.misc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/error")
@RestController
public class MyErrorController implements org.springframework.boot.web.servlet.error.ErrorController {


    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping(value="/error", produces = MediaType.TEXT_HTML_VALUE)
    public String getErrorDetails(){
        return "<!DOCTYPE html>" +
                "<html>" +
                "<body>" +
                //"<h1 style='color:red'>Something went wrong </h1>" +
                //"<h2 style='color:blue'>Our Engineers are on it</h2>" +
                "<img src='../../images/error.png'>" +
                "</body>" +
                "</html>";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

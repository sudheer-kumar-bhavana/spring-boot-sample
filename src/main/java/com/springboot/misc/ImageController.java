package com.springboot.misc;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImageController {


    @GetMapping("/{name}")
    public ResponseEntity<InputStreamResource> getImage(@PathVariable String name) throws IOException {

        ClassPathResource imgFile = new ClassPathResource("images/"+name);

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }
}

package com.springboot.sample;

import com.springboot.sample.model.Topic;
import com.springboot.sample.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class HelloController {


    @Autowired
    private TopicService topicService;

    @RequestMapping("/hello")
    public String sayHello(){
        return  "Hello there !!";
    }

    @GetMapping("/hi")
    public String sayHi(){
        return "Hi There !!";
    }

    @GetMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping("/topic/{topicId}")
    public Topic getATopic(@PathVariable("topicId") String topicId){
        return topicService.getATopic(Integer.valueOf(topicId));
    }

    @PostMapping("/topic")
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic){

        Topic t = topicService.addTopic(topic);

        return ResponseEntity.ok(topic);
    }
}

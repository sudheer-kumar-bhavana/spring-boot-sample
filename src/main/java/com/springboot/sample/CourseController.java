package com.springboot.sample;

import com.springboot.sample.model.Course;
import com.springboot.sample.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return courseService.getACourse(Integer.valueOf(courseId));
    }

    @PostMapping("/course")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course c = courseService.addCourse(course);
        return ResponseEntity.ok(c);
    }

    @PutMapping("/course")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        Course c = courseService.updateCourse(course);
        return ResponseEntity.ok(c);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/course/{courseId}")
    public void deleteCourse(@PathVariable String courseId){
        courseService.deleteCourse(Integer.valueOf(courseId));
    }
}

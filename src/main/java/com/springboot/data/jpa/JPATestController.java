package com.springboot.data.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa")
public class JPATestController {

    @Autowired
    @Qualifier("jpaCourseService")
    private JPACourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){

        return courseService.getAllCourses();
    }

    @GetMapping("/course/{courseId}")
    public Course getCourse(@PathVariable String courseId) throws Exception {
        return courseService.getACourse(Integer.valueOf(courseId));
    }

    @GetMapping("/course")
    public List<Course> getCourseByName(@RequestParam String name) throws Exception {
        return courseService.getACourseByName(name);
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

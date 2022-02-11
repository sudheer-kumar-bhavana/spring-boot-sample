package com.springboot.sample.service;

import com.springboot.sample.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private static final List<Course> courses = new ArrayList<>();

    public Course addCourse(Course course){
        course.setId(courses.size() == 0 ? 1: courses.size()+1);
        courses.add(course);
        return course;
    }

    public List<Course> getAllCourses(){
        return courses;
    }

    public Course getACourse(int id){
        return courses.stream()
                .filter(course -> id == course.getId() )
                .findFirst()
                .get();
    }

    public Course updateCourse(Course updatedCourse) {
        for (int i=0; i< courses.size(); i++){
            if (updatedCourse.getId() == courses.get(i).getId()){
                courses.set(i, updatedCourse);
            }
        }
        return updatedCourse;
    }

    public void deleteCourse(int courseId){
        courses.removeIf(course -> courseId == course.getId() );
    }
}

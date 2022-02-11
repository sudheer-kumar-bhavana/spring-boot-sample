package com.springboot.data.jpa;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("jpaCourseService")
public class JPACourseService implements InitializingBean {

    @Autowired
    private CourseRepository courseRepository;


    private static final List<Course> courses = new ArrayList<>();

    public Course addCourse(Course course){
        courseRepository.save(course);
        return course;
    }

    public List<Course> getAllCourses(){
        List<Course> list = new ArrayList<>();
        courseRepository.findAll().forEach(item -> list.add(item));
        return list;
    }

    public Course getACourse(int id) throws Exception {
       Optional<Course> optionalCourse = courseRepository.findById(id);
       if(optionalCourse.isPresent())
           return optionalCourse.get();
       else
           throw new Exception("Not Found");
    }

    public Course updateCourse(Course updatedCourse) {
        courseRepository.save(updatedCourse);
        return updatedCourse;
    }

    public void deleteCourse(int courseId){

        courseRepository.deleteById(courseId);
        //courses.removeIf(course -> courseId == course.getId() );
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Course c = new Course();
        c.setId(1);c.setName("C1");c.setDuration("60 days");
        courseRepository.save(c);
        c.setId(2);c.setName("C2");c.setDuration("30 days");
        courseRepository.save(c);

    }

    public List<Course> getACourseByName(String name) {
        return courseRepository.findByname(name);
    }
}

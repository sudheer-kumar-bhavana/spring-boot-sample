package com.springboot.data.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {


    List<Course> findByname(String name);
}

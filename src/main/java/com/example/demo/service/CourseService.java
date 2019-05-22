package com.example.demo.service;


import com.example.demo.modal.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> findAllCourses(){

        return courseRepository.findAllClasses();
    }

    public Course searchByCourseName(String input){

        return courseRepository.findCourseByName(input);
    }
    public List<Course> DeleteByCourseName(String input){

        return courseRepository.DeleteCourseByName(input);
    }
    public List<Course> addCourse(Course course){
        return courseRepository.AddCourse(course);
    }
    public List<Course> updateCourse(Course course){
        return courseRepository.updateCourse(course);
    }
}

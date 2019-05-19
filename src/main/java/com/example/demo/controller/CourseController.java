package com.example.demo.controller;

import com.example.demo.modal.Course;
import com.example.demo.modal.dto.CourseDto;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// single function interface
@RestController
@RequestMapping
public class CourseController {
    @Autowired // IOC
            CourseService courseService; // Singleton

    @GetMapping(path = "/", produces = "application/json")
    public HttpEntity findAllCourses() {
        List<Course> allCourses = courseService.findAllCourses();

        return new ResponseEntity<>(allCourses, HttpStatus.OK);
    }

//    @GetMapping(path = "/api/course/findAllCourses", produces = "application/json")
//    public HttpEntity<List<CourseDto>> findAllCourses(){
//        List<CourseDto> allCourses = courseService.findAllCourses();
//
//        return new ResponseEntity<>(allCourses, HttpStatus.OK);
//    }

    @GetMapping(path = "/look-up/{inputString}", produces = "application/json")
    public HttpEntity<Course> searchCourse(@PathVariable("inputString") String inputString) {

        Course findedCourse = courseService.searchByCourseName(inputString);

        return new ResponseEntity(findedCourse, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{inputString}", produces = "application/json")
    public HttpEntity<Course> deleteCourse(@PathVariable("inputString") String inputString) {

        List<Course> CoursesAfterDeleted = courseService.DeleteByCourseName(inputString);

        return new ResponseEntity(CoursesAfterDeleted, HttpStatus.OK);
    }

    @PostMapping(path = "/post/{inputString}", produces = "application/json")
    public HttpEntity<Course> postCourse(@PathVariable("inputString") String inputString) {

        List<Course> CoursesAfterAdded = courseService.AddCourse(inputString);

        return new ResponseEntity(CoursesAfterAdded, HttpStatus.OK);
    }

    @PutMapping(path = "/update/office", produces = "application/json")
    public HttpEntity<Course> UpdateOffice() {

        List<Course> CoursesAfterUpdated = courseService.UpdateOffice();

        return new ResponseEntity(CoursesAfterUpdated, HttpStatus.OK);
    }

    @PutMapping(path = "/update/{CourseName}/{OfficeTime}", produces = "application/json")
    public HttpEntity<Course> ChangeTime(@PathVariable("CourseName") String CourseName, @PathVariable("OfficeTime") String OfficeTime) {

        List<Course> CoursesAfterUpdated = courseService.ChangeTime(CourseName, OfficeTime);

        return new ResponseEntity(CoursesAfterUpdated, HttpStatus.OK);
    }
}
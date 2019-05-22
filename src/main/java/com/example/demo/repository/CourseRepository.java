package com.example.demo.repository;

import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        Course javaOne = Course.builder()
                .className("JavaI")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

        courses.add(javaOne);
        Course javaTwo = Course.builder()
                .className("JavaII")
                .instructor(new Instructor("Steve", "Adams", "Phd", "TownHall347"))
                .startDate(new Date("8/1/2015"))
                .endDate(new Date("12/24/2015"))
                .timeFrame("6am-10am")
                .build();

        courses.add(javaTwo);
    }


    public List<Course> findAllClasses(){
        //链接数据库
        //返回数据库的信息
        return  courses;
    }

    public List<Course> findAllCourse(String searchByCourseName){

        return new ArrayList<Course>();
    }

    public Course findCourseByName(String courseName) {
        for(Course course : courses){
            if(course.getClassName().equals(courseName)){
                return course;
            }
        }

        return null;
    }
    public List<Course> DeleteCourseByName(String courseName) {
        for(Course course : courses) {
            if (course.getClassName().equals(courseName)) {
                courses.remove(course);
                break;
            }
        }
        return courses;
    }
    public List<Course> AddCourse(Course course) {
        courses.add(course);
        return courses;
    }
    public List<Course> updateCourse(Course new_course) {
        for(Course course : courses){
            if(course.getClassName().equals(new_course.getClassName())){
                courses.remove(course);
                courses.add(new_course);
                break;
            }
        }
        return courses;
    }

}

package com.example.studentcourseenrollment.Service;

import com.example.studentcourseenrollment.Entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CourseService {

    List<Course> getAllCourses();
    Optional<Course> getCourseById(Long courseId);
    Course addCourse(Course course);
    Course updateCourse(Course course);
    void deleteCourse(Long courseId);

}

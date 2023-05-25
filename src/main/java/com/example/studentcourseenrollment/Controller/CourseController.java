package com.example.studentcourseenrollment.Controller;

import com.example.studentcourseenrollment.Entity.Course;
import com.example.studentcourseenrollment.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class CourseController {

    @Autowired
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("/getAllCourses")
    public List<Course> getAllCourse(){
        return courseService.getAllCourses();
    }

    @GetMapping("/getCourseById/{courseId}")
    public Optional<Course> getCourseById(@PathVariable("courseId") Long courseId){
        return courseService.getCourseById(courseId);
    }

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @PutMapping("/updateCourse")
    public Course updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId){
        courseService.deleteCourse(courseId);
        System.out.print("Course deleted successfully .");
    }
}

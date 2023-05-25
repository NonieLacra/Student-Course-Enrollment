package com.example.studentcourseenrollment.Service.Implementation;

import com.example.studentcourseenrollment.Entity.Course;
import com.example.studentcourseenrollment.Repository.CourseRepository;
import com.example.studentcourseenrollment.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        Course existingCourse = courseRepository.findById(course.getCourseId()).orElse(null);
        existingCourse.setCourse_name(course.getCourse_name());
        return courseRepository.save(existingCourse);
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}

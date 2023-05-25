package com.example.studentcourseenrollment.Service.Implementation;

import com.example.studentcourseenrollment.Entity.Course;
import com.example.studentcourseenrollment.Entity.Student;
import com.example.studentcourseenrollment.Repository.CourseRepository;
import com.example.studentcourseenrollment.Repository.StudentRepository;
import com.example.studentcourseenrollment.Service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final CourseRepository courseRepository;


    public EnrollmentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public void enrollStudent(Long studentId, Long courseId){
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Student not found."));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new IllegalArgumentException("Course not found."));

        student.setCourse(course);
        studentRepository.save(student);
    }


    public void dropStudent(Long studentId){
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Student not found"));

        student.setCourse(null);
        studentRepository.save(student);
    }


}

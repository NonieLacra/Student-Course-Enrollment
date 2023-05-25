package com.example.studentcourseenrollment.Service;

import org.springframework.stereotype.Service;


public interface EnrollmentService {

    void enrollStudent(Long studentId, Long courseId);
    void dropStudent(Long studentId);
}

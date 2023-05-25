package com.example.studentcourseenrollment.Service;

import com.example.studentcourseenrollment.Entity.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> getById(Long studentId);
    Student addStudent(Student student);
    Student updateById(Long studentId, Student updatedStudent);
    void deleteById(Long studentId);

}

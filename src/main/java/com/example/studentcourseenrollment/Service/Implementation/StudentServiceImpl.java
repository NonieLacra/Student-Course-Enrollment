package com.example.studentcourseenrollment.Service.Implementation;

import com.example.studentcourseenrollment.Entity.Student;
import com.example.studentcourseenrollment.Repository.StudentRepository;
import com.example.studentcourseenrollment.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateById(Long studentId, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Student ID not found ."));
        existingStudent.setFirstname(updatedStudent.getFirstname());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setLastname(updatedStudent.getLastname());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteById(Long studentId) {
        studentRepository.deleteById(studentId);

    }
}

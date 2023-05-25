package com.example.studentcourseenrollment.Controller;

import com.example.studentcourseenrollment.Entity.Student;
import com.example.studentcourseenrollment.Service.EnrollmentService;
import com.example.studentcourseenrollment.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private final StudentService studentService;
    @Autowired
    private final EnrollmentService enrollmentService;

    public StudentController(StudentService studentService, EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.enrollmentService = enrollmentService;
    }



    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getById/{studentId}")
    public Optional<Student> getById(@PathVariable Long studentId){
        return studentService.getById(studentId);
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/updateById/{studentId}")
    public ResponseEntity<Student> updateById(@PathVariable Long studentId, @RequestBody Student updatedStudent){
        Student updated = studentService.updateById(studentId, updatedStudent);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/deleteById/{studentId}")
    public void deleteById(@PathVariable Long studentId){
        studentService.deleteById(studentId);
        System.out.print("Student deleted successfully .");
    }

    @PostMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<String> enrollStudent(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId) {
        enrollmentService.enrollStudent(studentId, courseId);
        return ResponseEntity.ok("Student enrolled successfully .");
    }

    @PostMapping("/drop/{studentId}")
    public ResponseEntity<String> dropStudent(@PathVariable("studentId") Long studentId) {
        enrollmentService.dropStudent(studentId);
        return ResponseEntity.ok("Student dropped successfully .");
    }

}

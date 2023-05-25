package com.example.studentcourseenrollment.Repository;

import com.example.studentcourseenrollment.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

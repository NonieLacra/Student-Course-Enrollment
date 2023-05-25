package com.example.studentcourseenrollment.Repository;

import com.example.studentcourseenrollment.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

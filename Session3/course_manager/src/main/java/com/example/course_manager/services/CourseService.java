package com.example.course_manager.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.course_manager.models.Course;
import com.example.course_manager.repositories.CourseRepository;
import com.example.course_manager.repositories.EnrollmentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService {
    private CourseRepository courseRepository;
    private EnrollmentRepository enrollmentRepository;

    public List<Course> getAll() throws Exception {
        return courseRepository.findAll().orElseThrow(() -> new Exception("Courses not found"));
    }

    public Course getCourseById(String id){
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course createCourse(Course course){
        return courseRepository.create(course).orElseThrow(() -> new RuntimeException("Course already exists"));
    }

    public Course updateCourse(Course course, String id) throws Exception {
        return courseRepository.findById(id).orElseThrow(() -> new Exception("Course not found"));
    }

    public Course deleteCourse(String id){
        return courseRepository.delete(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public List<Course> getActiveCoursesWithEnrollmentsByInstructorId(String instructorId) {
        return courseRepository.findByInstructorId(instructorId)
                .orElse(List.of())
                .stream()
                .filter(course -> course.getStatus().equalsIgnoreCase("ACTIVE"))
                .filter(course -> enrollmentRepository.findByCourseId(course.getId()).isPresent())
                .collect(Collectors.toList());
    }
}

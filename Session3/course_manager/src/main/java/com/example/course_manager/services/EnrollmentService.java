package com.example.course_manager.services;

import com.example.course_manager.dto.enrollment.EnrollCourseRequest;
import com.example.course_manager.models.Course;
import com.example.course_manager.models.Enrollment;
import com.example.course_manager.repositories.CourseRepository;
import com.example.course_manager.repositories.InstructorRepository;
import com.example.course_manager.models.Instructor;
import org.springframework.stereotype.Service;

import com.example.course_manager.repositories.EnrollmentRepository;

import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class EnrollmentService{
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private EnrollmentRepository enrollmentRepository;

    public List<Enrollment> getAllEnrollments(){
        return enrollmentRepository.findAll().orElseThrow(() -> new RuntimeException("Enrollments not found"));
    }

    public Enrollment getEnrollmentById(String id){
        return enrollmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }

    public Enrollment createEnrollment(Enrollment enrollment){
        return enrollmentRepository.create(enrollment).orElseThrow(() -> new RuntimeException("Enrollment not created"));
    }

    public Enrollment updateEnrollment(Enrollment enrollment, String id){
        return enrollmentRepository.update(enrollment, id).orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }

    public Enrollment deleteEnrollmentById(String id){
        return enrollmentRepository.delete(id).orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }

    public Enrollment enrollCourse(EnrollCourseRequest request) {
        Course course = courseRepository.findById(request.getCourseId()).orElseThrow(() -> new RuntimeException("Course not found"));
        if (!course.getStatus().equalsIgnoreCase("ACTIVE")){
            throw new RuntimeException("Course is not active");
        }
        Instructor instructor = instructorRepository.findById(course.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        Enrollment enrollment = new Enrollment(request.getId(), request.getStudentName(), request.getCourseId());
        return enrollmentRepository.create(enrollment).orElseThrow(() -> new RuntimeException("Enrollment not created"));
    }
}
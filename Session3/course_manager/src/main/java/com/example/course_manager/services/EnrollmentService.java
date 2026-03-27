package com.example.course_manager.services;

import com.example.course_manager.models.Enrollment;
import org.springframework.stereotype.Service;

import com.example.course_manager.repositories.EnrollmentRepository;

import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class EnrollmentService{
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
}
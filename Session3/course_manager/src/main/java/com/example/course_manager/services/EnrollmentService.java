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
        return enrollmentRepository.findAll();
    }

    public Enrollment getEnrollmentById(String id){
        return enrollmentRepository.findById(id);
    }

    public Enrollment createEnrollment(Enrollment enrollment){
        Enrollment enrollmentFound = enrollmentRepository.findById(enrollment.getId());
        if(enrollmentFound == null){
            return enrollmentRepository.create(enrollment);
        }
        return null;
    }

    public Enrollment updateEnrollment(Enrollment enrollment, String id){
        return enrollmentRepository.update(enrollment, id);
    }

    public Enrollment deleteEnrollmentById(String id){
        return enrollmentRepository.delete(id);
    }
}
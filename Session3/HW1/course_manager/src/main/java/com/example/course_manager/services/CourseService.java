package com.example.course_manager.services;

import org.springframework.stereotype.Service;

import com.example.course_manager.repositories.EnrollmentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService {
    private EnrollmentRepository enrollmentRepository;
}

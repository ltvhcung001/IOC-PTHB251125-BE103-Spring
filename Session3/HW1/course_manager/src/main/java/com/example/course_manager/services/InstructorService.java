package com.example.course_manager.services;

import org.springframework.stereotype.Service;

import com.example.course_manager.repositories.InstructorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InstructorService {
    private InstructorRepository instructorRepository;
}

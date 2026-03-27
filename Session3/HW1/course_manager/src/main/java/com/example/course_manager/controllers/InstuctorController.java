package com.example.course_manager.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.course_manager.services.InstructorService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class InstuctorController {
    private InstructorService instructorService;
}

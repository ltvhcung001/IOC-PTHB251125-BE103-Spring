package com.example.course_manager.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.course_manager.services.CourseService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CourseController {
    private CourseService courseService;
}

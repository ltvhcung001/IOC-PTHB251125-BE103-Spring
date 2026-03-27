package com.example.course_manager.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.course_manager.models.Instructor;

@Repository
public class InstructorRepository {
    List<Instructor> instructors;
}

package com.example.course_manager.services;

import com.example.course_manager.dto.instructor.InstructorDetail;
import com.example.course_manager.models.Instructor;
import org.springframework.stereotype.Service;

import com.example.course_manager.repositories.InstructorRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructorService {
    private InstructorRepository instructorRepository;
    private CourseService courseService;

    public List<Instructor> findAll(){
        return instructorRepository.findAll().orElseThrow(() -> new RuntimeException("Instructors not found"));
    }

    public Instructor findById(String id){
        return instructorRepository.findById(id).orElseThrow(() -> new RuntimeException("Instructor not found"));
    }

    public Instructor createInstructor(Instructor instructor){
        return instructorRepository.findById(instructor.getId()).orElseThrow(() -> new RuntimeException("Instructor not found"));
    }

    public Instructor updateInstructor(Instructor instructor){
        return instructorRepository.update(instructor).orElseThrow(() -> new RuntimeException("Instructor not found"));
    }

    public Instructor deleteInstructor(String id){
        return instructorRepository.delete(id).orElseThrow(() -> new RuntimeException("Instructor not found"));
    }

    public List<InstructorDetail> getAllInstructorsWithFilteredCourses() {
        return instructorRepository.findAll()
                .orElseThrow(() -> new RuntimeException("Instructors not found"))
                .stream()
                .map(instructor -> new InstructorDetail(
                        instructor,
                        courseService.getActiveCoursesWithEnrollmentsByInstructorId(instructor.getId())
                ))
                .collect(Collectors.toList());
    }
}

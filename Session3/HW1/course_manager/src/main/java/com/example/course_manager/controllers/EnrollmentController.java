package com.example.course_manager.controllers;

import com.example.course_manager.models.Enrollment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.course_manager.services.EnrollmentService;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
public class EnrollmentController {
    private EnrollmentService enrollmentService;

    @GetMapping("/enrollments")
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        return ResponseEntity.status(HttpStatus.OK).body(enrollments);
    }

    @PostMapping("/enrollments")
    public ResponseEntity<Enrollment> addEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment newEnrollment = enrollmentService.createEnrollment(enrollment);
        if (newEnrollment != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(newEnrollment);
        else
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }

    @PutMapping("/enrollments/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable String id, @RequestBody Enrollment enrollment) {
        Enrollment updatedEnrollment =enrollmentService.updateEnrollment(enrollment);
        if (updatedEnrollment != null)
            return ResponseEntity.status(HttpStatus.OK).body(updatedEnrollment);
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("enrollments/{id}")
    public ResponseEntity<Enrollment> deleteEnrollment(@PathVariable String id) {
        Enrollment deletedEnrollment = enrollmentService.deleteEnrollmentById(id);
        if (deletedEnrollment != null){
            return ResponseEntity.status(HttpStatus.OK).body(deletedEnrollment);
        }
        else
            return ResponseEntity.notFound().build();
    }
}

package com.example.course_manager.controllers;

import com.example.course_manager.models.Instructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.course_manager.services.InstructorService;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
public class InstuctorController {
    private InstructorService instructorService;

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return ResponseEntity.ok(instructorService.findAll());
    }

    @PostMapping("/instructors")
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        Instructor newInstructor = instructorService.createInstructor(instructor);
        if (newInstructor != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newInstructor);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }

    @PutMapping("/instructors/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable String id, @RequestBody Instructor instructor) {
        Instructor updatedInstructor = instructorService.updateInstructor(instructor);
        if (updatedInstructor != null) {
            return ResponseEntity.ok(updatedInstructor);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/instructors/{id}")
    public ResponseEntity<Instructor> deleteInstructor(@PathVariable String id) {
        Instructor deletedInstructor = instructorService.deleteInstructor(id);
        if (deletedInstructor != null) {
            return ResponseEntity.ok(deletedInstructor);
        }
        return ResponseEntity.notFound().build();
    }
}
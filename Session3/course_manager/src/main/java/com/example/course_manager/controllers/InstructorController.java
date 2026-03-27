package com.example.course_manager.controllers;

import com.example.course_manager.common.api.ApiResponse;
import com.example.course_manager.models.Instructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.course_manager.services.InstructorService;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
public class InstructorController {
    private InstructorService instructorService;

    @GetMapping("/instructors")
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true,
                            "Instructors retrieved successfully",
                            instructorService.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false,
                    e.getMessage(),
                    null));
        }
    }

    @PostMapping("/instructors")
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody Instructor instructor) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true,
                    "Instructor created successfully",
                    instructorService.createInstructor(instructor)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiResponse<>(false,
                    e.getMessage(),
                    null));
        }
    }

    @PutMapping("/instructors/{id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructor(@PathVariable String id,
                                                                    @RequestBody Instructor instructor) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>(true,
                    "Instructor updated successfully",
                    instructorService.updateInstructor(instructor)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false,
                    e.getMessage(),
                    null));
        }
    }

    @DeleteMapping("/instructors/{id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructor(@PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true,
                            "Instructor deleted successfully",
                            instructorService.deleteInstructor(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false,
                            e.getMessage(),
                            null));
        }
    }
}
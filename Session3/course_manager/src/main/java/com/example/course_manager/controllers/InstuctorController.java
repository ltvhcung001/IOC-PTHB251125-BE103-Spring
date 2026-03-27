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
public class InstuctorController {
    private InstructorService instructorService;

    @GetMapping("/instructors")
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>(true,
                        "Instructors retrival successfully",
                        instructorService.findAll()));
    }

    @PostMapping("/instructors")
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody Instructor instructor) {
        Instructor newInstructor = instructorService.createInstructor(instructor);
        if (newInstructor != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true,
                            "Instructor created successfully",
                            newInstructor));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiResponse<>(false,
                        "Instructor not found",
                        null));
    }

    @PutMapping("/instructors/{id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructor(@PathVariable String id,
            @RequestBody Instructor instructor) {
        Instructor updatedInstructor = instructorService.updateInstructor(instructor);
        if (updatedInstructor != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true,
                            "Instructor updated successfully",
                            updatedInstructor));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false,
                        "Instructor not found",
                        null));
    }

    @DeleteMapping("/instructors/{id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructor(@PathVariable String id) {
        Instructor deletedInstructor = instructorService.deleteInstructor(id);
        if (deletedInstructor != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true,
                            "Instructor deleted successfully",
                            deletedInstructor));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false,
                        "Instructor not found",
                        null));
    }
}
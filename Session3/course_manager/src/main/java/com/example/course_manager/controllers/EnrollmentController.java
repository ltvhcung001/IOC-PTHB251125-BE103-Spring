package com.example.course_manager.controllers;

import com.example.course_manager.common.api.ApiResponse;
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
    public ResponseEntity<ApiResponse<List<Enrollment>>> getAllEnrollments() {
        return ResponseEntity.status(HttpStatus.OK)
                            .body(new ApiResponse<>(true,
                                                        "Enrollments retrieved successfully",
                                                            enrollmentService.getAllEnrollments()));
    }

    @PostMapping("/enrollments")
    public ResponseEntity<ApiResponse<Enrollment>> addEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment newEnrollment = enrollmentService.createEnrollment(enrollment);
        if (newEnrollment != null)
            return ResponseEntity.status(HttpStatus.CREATED)
                                .body(new ApiResponse<>(true,
                                                            "Enrollment created successfully",
                                                                newEnrollment));
        else
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                .body(new ApiResponse<>(false,
                                                            "Enrollment not found",
                                                                null));
    }

    @PutMapping("/enrollments/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> updateEnrollment(@PathVariable String id, @RequestBody Enrollment enrollment) {
        Enrollment updatedEnrollment = enrollmentService.updateEnrollment(enrollment, id);
        if (updatedEnrollment != null)
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(new ApiResponse<>(true,
                                                             "Enrollment updated successfully",
                                                                 updatedEnrollment));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(new ApiResponse<>(false,
                                                            "Enrollment not found",
                                                                null));
    }

    @DeleteMapping("enrollments/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> deleteEnrollment(@PathVariable String id) {
        Enrollment deletedEnrollment = enrollmentService.deleteEnrollmentById(id);
        if (deletedEnrollment != null){
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(new ApiResponse<>(true,
                                                            "Enrollment deleted successfully",
                                                                deletedEnrollment));
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(new ApiResponse<>(false,
                                                            "Enrollment not found",
                                                                null));
    }
}

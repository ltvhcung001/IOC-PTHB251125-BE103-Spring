package com.example.course_manager.controllers;

import com.example.course_manager.common.api.ApiResponse;
import com.example.course_manager.dto.enrollment.EnrollCourseRequest;
import com.example.course_manager.dto.enrollment.EnrollmentDetail;
import com.example.course_manager.models.Enrollment;
import com.example.course_manager.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.course_manager.services.EnrollmentService;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
public class EnrollmentController {
    private final CourseService courseService;
    private EnrollmentService enrollmentService;

    @GetMapping("/enrollments")
    public ResponseEntity<ApiResponse<List<Enrollment>>> getAllEnrollments() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true,
                            "Enrollments retrieved successfully",
                            enrollmentService.getAllEnrollments()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false,
                            e.getMessage(),
                            null));
        }
    }

    @PostMapping("/enrollments")
    public ResponseEntity<ApiResponse<Enrollment>> addEnrollment(@RequestBody Enrollment enrollment) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true,
                            "Enrollment created successfully",
                            enrollmentService.createEnrollment(enrollment)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(false,
                            e.getMessage(),
                            null));
        }
    }

    @PutMapping("/enrollments/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> updateEnrollment(@PathVariable String id,
            @RequestBody Enrollment enrollment) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true,
                            "Enrollment updated successfully",
                            enrollmentService.updateEnrollment(enrollment, id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(false,
                            e.getMessage(),
                            null));
        }
    }

    @DeleteMapping("enrollments/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> deleteEnrollment(@PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true,
                            "Enrollment deleted successfully",
                            enrollmentService.deleteEnrollmentById(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(false,
                            e.getMessage(),
                            null));
        }
    }

    @PostMapping("/enrollemnts/enroll-course")
    public ResponseEntity<ApiResponse<EnrollmentDetail>> enrollCourse(@RequestBody EnrollCourseRequest request) {
        try {
            Enrollment enrollment = enrollmentService.enrollCourse(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(true,
                        "Enrollment created successfully",
                        new EnrollmentDetail(enrollment.getId(),
                                enrollment.getStudentName(),
                                courseService.getCourseById(enrollment.getCourseId()))));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(false,
                            e.getMessage(),
                            null));
        }
    }
}

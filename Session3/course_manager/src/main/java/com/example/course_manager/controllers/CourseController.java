package com.example.course_manager.controllers;

import com.example.course_manager.common.api.ApiResponse;
import com.example.course_manager.models.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.course_manager.services.CourseService;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {
    private CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<ApiResponse<List<Course>>> getCourses(){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true,
                        "Courses retrieved successfully",
                        courseService.getAll()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false,
                        e.getMessage(),
                        null));
        }
    }

    @PostMapping("/courses")
    public ResponseEntity<ApiResponse<Course>> addCourse(@RequestBody Course course){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true,
                    "Course created successfully",
                            courseService.createCourse(course)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiResponse<>(false,
                    e.getMessage(),
                        null));
        }
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@RequestBody Course course, @PathVariable String id){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true,
                            "Course updated successfully",
                            courseService.updateCourse(course, id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false,
                    e.getMessage(),
                        null));
        }
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourse(@PathVariable String id){
        Course courseToDelete = courseService.deleteCourse(id);
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new ApiResponse<>(true,
                            "Course deleted successfully",
                            courseToDelete));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false,
                            e.getMessage(),
                            null));
        }
    }
}

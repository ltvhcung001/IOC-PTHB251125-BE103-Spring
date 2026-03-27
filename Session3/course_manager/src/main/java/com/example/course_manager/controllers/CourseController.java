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
        return ResponseEntity.status(HttpStatus.OK)
                            .body(new ApiResponse<>(true,
                                    "Courses retrieved successfully",
                                    courseService.getAll()));
    }

    @PostMapping("/courses")
    public ResponseEntity<ApiResponse<Course>> addCourse(@RequestBody Course course){
        Course newCourse = courseService.createCourse(course);
        if (newCourse == null){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                .body(new ApiResponse<>(false,
                                                            "Course with the same name already exists",
                                                                null));
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ApiResponse<>(true,
                                                "Course created successfully",
                                                    newCourse));
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@RequestBody Course course, @PathVariable String id){
        Course courseToUpdate = courseService.updateCourse(course);
        if (courseToUpdate == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(new ApiResponse<>(false,
                                                                "Course not found",
                                                                null));
        }
        return ResponseEntity.status(HttpStatus.OK)
                            .body(new ApiResponse<>(true, "Course updated successfully", courseToUpdate));
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourse(@PathVariable String id){
        Course courseToDelete = courseService.deleteCourse(id);
        if (courseToDelete == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(new ApiResponse<>(false, "Course not found", null));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                            .body(new ApiResponse<>(true, "Course deleted successfully", courseToDelete));
    }
}

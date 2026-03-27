package com.example.course_manager.controllers;

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
    public ResponseEntity<List<Course>> getCourses(){
        return ResponseEntity.status(HttpStatus.OK)
                            .body(courseService.getAll());
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course newCourse = courseService.createCourse(course);
        if (newCourse == null){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                .body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                            .body(newCourse);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable String id){
        Course courseToUpdate = courseService.updateCourse(course);
        if (courseToUpdate == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK)
                            .body(courseToUpdate);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable String id){
        Course courseToDelete = courseService.deleteCourse(id);
        if (courseToDelete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                            .body(courseToDelete);
    }
}

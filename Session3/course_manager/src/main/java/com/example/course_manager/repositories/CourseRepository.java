package com.example.course_manager.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.course_manager.models.Course;

@Repository
public class CourseRepository {
    List<Course> courses;

    public CourseRepository() {
        courses = new ArrayList<>();
        courses.add(new Course("1", "Course 1", "available", "1"));
        courses.add(new Course("2", "Course 2", "open", "2"));
        courses.add(new Course("3", "Course 3", "close", "3"));
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course findById(String id) {
        return courses.stream()
                        .filter(course -> course.getId().equals(id))
                        .findFirst()
                        .orElse(null);
    }

    public Course create(Course course) {
        courses.add(course);
        return course;
    }

    public Course update(Course course) {
        Course existingCourse = findById(course.getId());
        if (existingCourse == null) {
            return null;
        }
        existingCourse.setId(course.getId());
        existingCourse.setTitle(course.getTitle());
        existingCourse.setStatus(course.getStatus());
        existingCourse.setInstructorId(course.getInstructorId());
        return existingCourse;
    }

    public Course delete(String id) {
        Course course = findById(id);
        if (course == null) {
            return null;
        }
        courses.remove(course);
        return course;
    }
}

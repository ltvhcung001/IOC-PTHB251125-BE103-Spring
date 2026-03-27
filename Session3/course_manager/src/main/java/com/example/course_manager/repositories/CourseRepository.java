package com.example.course_manager.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<List<Course>> findAll() {
        return Optional.ofNullable(courses);
    }

    public Optional<Course> findById(String id) {
        return courses.stream()
                        .filter(course -> course.getId().equals(id))
                        .findFirst();
    }

    public Optional<Course> create(Course course) {
        courses.add(course);
        return Optional.ofNullable(course);
    }

    public Optional<Course> update(Course course, String id) {
        Optional<Course> existingCourse = findById(id);
        if (existingCourse.isEmpty()) {
            return Optional.empty();
        }
        else{
            existingCourse.get().setId(course.getId());
            existingCourse.get().setTitle(course.getTitle());
            existingCourse.get().setStatus(course.getStatus());
            existingCourse.get().setInstructorId(course.getInstructorId());
        }
        return existingCourse;
    }

    public Optional<Course> delete(String id) {
        Optional<Course> course = findById(id);
        if (course.isEmpty()) {
            return Optional.empty();
        }
        courses.remove(course.get());
        return course;
    }

    public Optional<List<Course>> findByInstructorId(String instructorId) {
        List<Course> instructorCourses = courses.stream()
                .filter(course -> course.getInstructorId().equals(instructorId))
                .toList();
        return instructorCourses.isEmpty() ? Optional.empty() : Optional.of(instructorCourses);
    }
}

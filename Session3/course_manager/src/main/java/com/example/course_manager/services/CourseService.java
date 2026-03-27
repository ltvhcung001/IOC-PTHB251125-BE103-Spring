package com.example.course_manager.services;

import com.example.course_manager.models.Course;
import com.example.course_manager.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private CourseRepository courseRepository;

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public Course getCourseById(String id){
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course){
        Course newCourse = courseRepository.findById(course.getId());
        if(newCourse == null){
            return courseRepository.create(course);
        }
        else {
            return null;
        }
    }

    public Course updateCourse(Course course){
        return courseRepository.update(course);
    }

    public Course deleteCourse(String id){
        return courseRepository.delete(id);
    }
}

package com.example.course_manager.dto.instructor;

import com.example.course_manager.models.Course;
import com.example.course_manager.models.Instructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDetail {
    private String id;
    private String name;
    private String email;
    private List<Course> courses;

    public InstructorDetail(Instructor instructor, List<Course> courses) {
        this.id = instructor.getId();
        this.name = instructor.getName();
        this.email = instructor.getEmail();
        this.courses = courses;
    }
}


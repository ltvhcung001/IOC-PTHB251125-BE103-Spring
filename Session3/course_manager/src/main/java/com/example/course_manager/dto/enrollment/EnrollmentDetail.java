package com.example.course_manager.dto.enrollment;

import com.example.course_manager.models.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EnrollmentDetail {
    String id;
    String studentName;
    Course course;
}

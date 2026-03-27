package com.example.course_manager.dto.enrollment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnrollCourseRequest {
    String id;
    String studentName;
    String courseId;
}

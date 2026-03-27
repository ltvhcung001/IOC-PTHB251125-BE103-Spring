package com.example.course_manager.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.course_manager.models.Enrollment;

@Repository
public class EnrollmentRepository {
    List<Enrollment> enrollments;

    EnrollmentRepository(){
        enrollments = new ArrayList<>();
        enrollments.add(new Enrollment("1", "Student 1", "1"));
        enrollments.add(new Enrollment("2", "Student 2", "2"));
        enrollments.add(new Enrollment("3", "Student 3", "3"));
    }

    public List<Enrollment> findAll() {
        return enrollments;
    }

    public Enrollment findById(String id) {
        return enrollments
                .stream()
                .filter(e -> e.getId().equals(id)).findFirst()
                .orElse(null);
    }

    public Enrollment create(Enrollment enrollment) {
        enrollments.add(enrollment);
        return enrollment;
    }

    public Enrollment update(Enrollment enrollment, String id) {
        Enrollment oldEnrollment = findById(id);
        if (oldEnrollment == null) {
            return null;
        }
        enrollments.remove(oldEnrollment);
        enrollments.add(enrollment);
        return enrollment;
    }

    public Enrollment delete(String id) {
        Enrollment oldEnrollment = findById(id);
        if (oldEnrollment == null) {
            return null;
        }
        enrollments.remove(oldEnrollment);
        return oldEnrollment;
    }
}

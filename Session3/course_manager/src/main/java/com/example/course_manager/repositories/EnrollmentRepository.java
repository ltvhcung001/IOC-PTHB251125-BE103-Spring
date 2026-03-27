package com.example.course_manager.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<List<Enrollment>> findAll() {
        return Optional.ofNullable(enrollments);
    }

    public Optional<Enrollment> findById(String id) {
        return enrollments
                .stream()
                .filter(e -> e.getId().equals(id)).findFirst();
    }

    public Optional<Enrollment> create(Enrollment enrollment) {
        enrollments.add(enrollment);
        return Optional.ofNullable(enrollment);
    }

    public Optional<Enrollment> update(Enrollment enrollment, String id) {
        Optional<Enrollment> oldEnrollment = findById(id);
        if (oldEnrollment.isEmpty()) {
            return Optional.empty();
        }
        enrollments.remove(oldEnrollment.get());
        enrollments.add(enrollment);
        return Optional.ofNullable(enrollment);
    }

    public Optional<Enrollment> delete(String id) {
        Optional<Enrollment> oldEnrollment = findById(id);
        if (oldEnrollment.isEmpty()) {
            return Optional.empty();
        }
        enrollments.remove(oldEnrollment.get());
        return oldEnrollment;
    }

    public Optional<List<Enrollment>> findByCourseId(String courseId) {
        List<Enrollment> courseEnrollments = enrollments.stream()
                .filter(e -> e.getCourseId().equals(courseId))
                .toList();
        return courseEnrollments.isEmpty() ? Optional.empty() : Optional.of(courseEnrollments);
    }
}

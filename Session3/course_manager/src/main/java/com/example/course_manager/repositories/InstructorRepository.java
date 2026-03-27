package com.example.course_manager.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.course_manager.models.Instructor;

@Repository
public class InstructorRepository {
    List<Instructor> instructors;

    InstructorRepository(){
        instructors = new ArrayList<>();
        instructors.add(new Instructor("1", "Instructor 1", "Instructor 1 bio"));
        instructors.add(new Instructor("2", "Instructor 2", "Instructor 2 bio"));
        instructors.add(new Instructor("3", "Instructor 3", "Instructor 3 bio"));
    }

    public Optional<List<Instructor>> findAll() {
        return Optional.ofNullable(instructors);
    }

    public Optional<Instructor> findById(String id) {
        return instructors
                .stream()
                .filter(i -> i.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    public Optional<Instructor> create(Instructor instructor) {
        instructors.add(instructor);
        return Optional.ofNullable(instructor);
    }

    public Optional<Instructor> update(Instructor instructor) {
        Optional<Instructor> oldInstructor = findById(instructor.getId());
        if (oldInstructor.isEmpty()) {
            return Optional.empty();
        }
        instructors.remove(oldInstructor.get());
        instructors.add(instructor);
        return Optional.of(instructor);
    }

    public Optional<Instructor> delete(String id) {
        Optional<Instructor> oldInstructor = findById(id);
        if (oldInstructor.isEmpty()) {
            return Optional.empty();
        }
        instructors.remove(oldInstructor.get());
        return oldInstructor;
    }
}
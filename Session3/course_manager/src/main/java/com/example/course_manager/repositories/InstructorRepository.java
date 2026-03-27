package com.example.course_manager.repositories;

import java.util.ArrayList;
import java.util.List;

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

    public List<Instructor> findAll() {
        return instructors;
    }

    public Instructor findById(String id) {
        return instructors
                .stream()
                .filter(i -> i.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public Instructor create(Instructor instructor) {
        instructors.add(instructor);
        return instructor;
    }

    public Instructor update(Instructor instructor) {
        Instructor oldInstructor = findById(instructor.getId());
        if (oldInstructor == null) {
            return null;
        }
        instructors.remove(oldInstructor);
        instructors.add(instructor);
        return instructor;
    }

    public Instructor delete(String id) {
        Instructor oldInstructor = findById(id);
        if (oldInstructor == null) {
            return null;
        }
        instructors.remove(oldInstructor);
        return oldInstructor;
    }
}

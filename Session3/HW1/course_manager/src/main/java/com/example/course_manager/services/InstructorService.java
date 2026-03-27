package com.example.course_manager.services;

import com.example.course_manager.models.Instructor;
import org.springframework.stereotype.Service;

import com.example.course_manager.repositories.InstructorRepository;

import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class InstructorService {
    private InstructorRepository instructorRepository;

    public List<Instructor> findAll(){
        return instructorRepository.findAll();
    }

    public Instructor findById(String id){
        return instructorRepository.findById(id);
    }

    public Instructor createInstructor(Instructor instructor){
        Instructor newInstructor = instructorRepository.findById(instructor.getId());
        if (newInstructor == null){
            return instructorRepository.create(instructor);
        }
        else {
            return null;
        }
    }

    public Instructor updateInstructor(Instructor instructor){
        return instructorRepository.update(instructor);
    }

    public Instructor deleteInstructor(String id){
        Instructor oldInstructor = findById(id);
        if (oldInstructor == null){
            return null;
        }
        instructorRepository.delete(id);
        return oldInstructor;
    }
}

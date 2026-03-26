package org.example.taskmanager.services;

import lombok.AllArgsConstructor;
import org.example.taskmanager.models.Task;
import org.example.taskmanager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {
    @Autowired
    private TaskRepository taskRepository;
    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }
}

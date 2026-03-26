package org.example.taskmanager.services;

import org.example.taskmanager.models.Task;
import org.example.taskmanager.models.User;
import org.example.taskmanager.repositories.TaskRepository;
import org.example.taskmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }

    public boolean addTask(Task task){
        User user = userRepository.findById(task.getAssignedTo());
        if (user != null) {
            return taskRepository.save(task);
        } else {
            return false;
        }
    }
}

package org.example.taskmanager.controllers;

import org.example.taskmanager.models.Task;
import org.example.taskmanager.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskServices taskServices;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks(@RequestParam(required = false) String search) {
        if (search == null) {
            return ResponseEntity.ok(taskServices.findAllTasks());
        }
        else{
            List<Task> tasks = taskServices.findAllTasks()
                                            .stream()
                                            .filter(t -> t.getTitle()
                                                                        .equalsIgnoreCase(search))
                                            .toList();
            return ResponseEntity.ok(tasks);
        }
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task newTask) {

        boolean createdTask = taskServices.addTask(newTask);
        if (createdTask) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

package org.example.taskmanager.controllers;

import java.util.List;

import org.example.taskmanager.models.Task;
import org.example.taskmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskServices;

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

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody Task newTask) {
        Task oldTask = taskServices.findTaskById(id);
        if (oldTask == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(taskServices.save(newTask));
        }
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable String id) {
        if(taskServices.deleteTaskById(id)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(taskServices.findTaskById(id));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

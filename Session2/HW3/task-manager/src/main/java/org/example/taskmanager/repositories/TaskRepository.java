package org.example.taskmanager.repositories;

import lombok.Getter;
import lombok.Setter;
import org.example.taskmanager.models.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class TaskRepository {
    private List<Task> tasks;
    TaskRepository() {
        tasks = new ArrayList<>();
        tasks.add(new Task("1", "Task 1", "Description of Task 1", "high", "2"));
        tasks.add(new Task("2", "Task 2", "Description of Task 2", "low", "3"));
        tasks.add(new Task("3", "Task 3", "Description of Task 3", "medium", "1"));
        tasks.add(new Task("4", "Task 4", "Description of Task 4", "high", "1"));
        tasks.add(new Task("5", "Task 5", "Description of Task 5", "low", "2"));
        tasks.add(new Task("6", "Task 6", "Description of Task 6", "medium", "3"));
        tasks.add(new Task("7", "Task 7", "Description of Task 7", "high", "1"));
        tasks.add(new Task("8", "Task 8", "Description of Task 8", "medium", "3"));
        tasks.add(new Task("9", "Task 9", "Description of Task 9", "low", "1"));
        tasks.add(new Task("10", "Task 10", "Description of Task 10", "high", "2"));
    }

    public List<Task> findAll(){
        return tasks;
    }
}

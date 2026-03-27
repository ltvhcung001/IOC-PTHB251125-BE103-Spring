package org.example.taskmanager.controllers;

import org.example.taskmanager.models.User;
import org.example.taskmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userServices;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(@RequestParam(required = false) String search) {
        if (search == null) {
            return ResponseEntity.ok(userServices.findAllUsers());
        }
        else{
            List<User> users = userServices.findAllUsers()
                                            .stream()
                                            .filter(u -> u.getUsername()
                                                                       .equalsIgnoreCase(search))
                                            .toList();
            return ResponseEntity.ok(users);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (userServices.addUser(user)){
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = userServices.findById(id);
        if (user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        User oldUser = userServices.findById(id);
        if (oldUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            User newUser = userServices.save(user);
            return ResponseEntity.ok(newUser);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id) {
        User user = userServices.findById(id);
        if (user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            if (userServices.deleteUser(user))
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

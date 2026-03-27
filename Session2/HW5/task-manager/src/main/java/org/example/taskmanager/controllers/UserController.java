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
}

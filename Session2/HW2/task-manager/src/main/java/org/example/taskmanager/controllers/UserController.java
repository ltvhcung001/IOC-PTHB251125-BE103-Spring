package org.example.taskmanager.controllers;

import org.example.taskmanager.services.TaskServices;
import org.example.taskmanager.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserServices userServices;
}

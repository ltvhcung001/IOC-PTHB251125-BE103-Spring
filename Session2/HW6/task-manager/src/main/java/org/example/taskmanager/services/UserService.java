package org.example.taskmanager.services;

import org.example.taskmanager.models.User;
import org.example.taskmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public boolean addUser(User user){
        return userRepository.addUser(user);
    }

    public User findById(String id){
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user.getId(), user);
    }

    public boolean deleteUser(User user) {
        return userRepository.deleteUser(user);
    }
}

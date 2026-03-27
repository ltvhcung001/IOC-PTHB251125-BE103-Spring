package org.example.taskmanager.repositories;

import lombok.*;
import org.example.taskmanager.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Getter
public class UserRepository {
    private List<User> users;
    UserRepository() {
        users = new ArrayList<>();
        users.add(new User("1", "Nguyen Van A", "nva@gmail.com", "admin"));
        users.add(new User("2", "Tran Thi B", "tvb@gmail.com", "user"));
        users.add(new User("3", "Le Thi C", "ltc@gmail.com", "user"));
    }

    public List<User> findAll() {
        return users;
    }

    public boolean addUser(User user) {
        Optional<User> userGetByID = users.stream()
            .filter(u -> u.getId().equals(user.getId()))
            .findFirst();
        if (userGetByID.isPresent()) {
            return false;
        }
        return users.add(user);
    }

    public User findById(String id) {
        return users.stream()
            .filter(u -> u.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
}

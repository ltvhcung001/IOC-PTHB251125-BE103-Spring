package org.example.taskmanager.repositories;

import lombok.*;
import org.example.taskmanager.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
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
}

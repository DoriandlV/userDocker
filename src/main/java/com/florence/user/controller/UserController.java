package com.florence.user.controller;

import com.florence.user.entity.User;
import com.florence.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("user")
public class UserController {

    @Autowired
    User user;
    @Autowired
    UserRepository repository;

    @GetMapping(value = "/users")
    public List<User> getAllEmployees() {
        return repository.findAll();
    }

    @PostMapping("/users")
    User createOrSaveEmployee(User newUser) {
        return repository.save(newUser);
    }

    @GetMapping("/users/{id}")
    User getEmployeeById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PutMapping("/users/{id}")
    User updateUser(User newUser, @PathVariable Long id) {

        return repository.findById(id).map(user -> {
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            user.setEmail(newUser.getEmail());
            return repository.save(user);
        }).orElseGet(() -> {
            newUser.setUserId(id);
            return repository.save(newUser);
        });
    }

    @DeleteMapping("/users/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

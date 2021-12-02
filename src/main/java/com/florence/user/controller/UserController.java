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
    UserRepository repository;

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping(value = "/namesurname")
    User getUserByName(String name, String surname) {

        return repository.findByFirstNameAndLastName(name, surname).orElseThrow();
    }

    @PostMapping("/users")
    User createOrSaveUsers(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PutMapping("/users/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {

        return repository.findById(id).map(user -> {
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            user.setEmail(newUser.getEmail());
            user.setAddress(newUser.getAddress());
            return repository.save(user);
        }).orElseGet(() -> {
            newUser.setUserId(id);
            return repository.save(newUser);
        });
    }

    @DeleteMapping("/users/{id}")
    void deleteUsers(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

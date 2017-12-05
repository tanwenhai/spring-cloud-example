package com.example.microservicesimpleprovideruser.controller;

import com.example.microservicesimpleprovideruser.model.User;
import com.example.microservicesimpleprovideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findByid(@PathVariable Long id) {
        User findOne = userRepository.findOne(id);
        return findOne;
    }
}

package com.example.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return userClient.getUser(id);
    }
}

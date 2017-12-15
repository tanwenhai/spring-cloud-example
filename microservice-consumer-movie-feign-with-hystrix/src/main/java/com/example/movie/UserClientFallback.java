package com.example.movie;

import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User getUser(Long id) {
        User user = new User();
        user.setId(0L);

        return user;
    }
}

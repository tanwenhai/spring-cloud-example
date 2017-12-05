package com.example.microservicesimpleprovideruser.repository;

import com.example.microservicesimpleprovideruser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

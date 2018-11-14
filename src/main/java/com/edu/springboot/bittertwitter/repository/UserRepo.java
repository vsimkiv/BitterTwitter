package com.edu.springboot.bittertwitter.repository;

import com.edu.springboot.bittertwitter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.User;

public interface IUserRepository {
    User save(User user);
    User update(Long Id, User user);
    boolean exists(String user_name);
    Optional<User> findById(Long Id);
    Optional<User> findByUserName(String user_name);
    List<User> findAll();
    void deleteById(Long Id);
}

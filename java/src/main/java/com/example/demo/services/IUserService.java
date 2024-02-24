package com.example.demo.services;

import com.example.demo.entities.Gender;

public interface IUserService {
    String add_user(String user_name, Gender gender, Long age);
}

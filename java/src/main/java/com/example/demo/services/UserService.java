package com.example.demo.services;

import com.example.demo.entities.Gender;
import com.example.demo.entities.User;
import com.example.demo.repositories.IUserRepository;

public class UserService implements IUserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public String add_user(String user_name, Gender gender, Long age) {
        if(user_name == null || gender == null || age == null)
            throw new RuntimeException("Fields are mandatory!");
        boolean isExist = userRepository.exists(user_name);
        if(!isExist){
            User entity = new User(user_name, gender, age);
            User user = userRepository.save(entity);
            return user.getId() + "";
        } else {
            throw new RuntimeException("user already registered !");
        }
    }
}

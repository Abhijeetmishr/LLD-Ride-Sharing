package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import com.example.demo.entities.User;


public class UserRepository implements IUserRepository{
    AtomicLong idCounter = new AtomicLong(1);
    Map<Long,User> storage = new HashMap<>();

    @Override
    public User save(User user) {
        User entity = new User(idCounter.getAndIncrement(), user);
        storage.putIfAbsent(entity.getId(), entity);
        return entity;
    }

    @Override
    public User update(Long Id, User user) {
       storage.put(Id, user);
       return storage.get(Id);
    }

    @Override
    public boolean exists(String user_name){
        return storage.values().stream().anyMatch(user -> 
                user.getUser_name().equals(user_name));
    }

    @Override
    public Optional<User> findByUserName(String user_name) {
        return storage.values().stream()
                .filter(user -> user.getUser_name().equals(user_name))
                .findAny();
    }

    @Override
    public Optional<User> findById(Long Id) {
        return Optional.ofNullable(storage.get(Id));
    }

    @Override
    public List<User> findAll() {
        return storage.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long Id) {
        storage.remove(Id);
    }
    
}

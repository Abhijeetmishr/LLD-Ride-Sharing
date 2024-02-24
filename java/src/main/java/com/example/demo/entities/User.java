package com.example.demo.entities;

public class User {
    private Long Id;
    private String user_name;
    private Gender gender;
    private Long age;

    public User(String user_name, Gender gender, Long age){
        this.Id = null;
        this.user_name = user_name;
        this.gender = gender;
        this.age = age;
    }

    public User(Long Id, User other){
        this.Id = Id;
        this.user_name = other.user_name;
        this.gender = other.gender;
        this.age = other.age;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}

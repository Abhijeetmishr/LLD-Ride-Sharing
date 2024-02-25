package com.example.demo.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private Long Id;
    private String user_name;
    private Gender gender;
    private Long age;
    Map<String, Vehicle> vehicles;
    Set<Ride> offered;
    Set<Ride> taken;
    
    public User(String user_name, Gender gender, Long age){
        this.Id = null;
        this.user_name = user_name;
        this.gender = gender;
        this.age = age;
        this.vehicles = new HashMap<>();
        this.offered = new HashSet<>();
        this.taken = new HashSet<>();
    }

    public User(Long Id, User other){
        this.Id = Id;
        this.user_name = other.user_name;
        this.gender = other.gender;
        this.age = other.age;
        this.vehicles = other.vehicles;
        this.offered = other.offered;
        this.taken = other.taken;
    }

    public List<Vehicle> getVehicles() {
        return vehicles.values().stream().collect(Collectors.toList());
    }

    public void setVehicles(String vehicle_no, Vehicle vehicle) {
        vehicles.putIfAbsent(vehicle_no, vehicle);
    }

    public List<Ride> getOffered() {
        return offered.stream().collect(Collectors.toList());
    }

    public void setOffered(Ride ride) {
        offered.add(ride);
    }

    public List<Ride> getTaken() {
        return taken.stream().collect(Collectors.toList());
    }

    public void setTaken(Ride ride) {
        taken.add(ride);
    }
    
}

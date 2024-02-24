package com.example.demo.entities;

public class Vehicle {
    private Long Id;
    private String user_name;
    private String vehicle_name;
    private String vehicle_no;

    public Vehicle(String user_name, String vehicle_name, String vehicle_no){
        this.Id = null;
        this.user_name = user_name;
        this.vehicle_name = vehicle_name;
        this.vehicle_no = vehicle_no;
    }

    public Vehicle(Long Id, Vehicle other){
        this.Id = Id;
        this.user_name = other.user_name;
        this.vehicle_name = other.vehicle_name;
        this.vehicle_no = other.vehicle_no;
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

    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }
}

package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Vehicle {
    private Long Id;
    private String vehicle_name;
    private String vehicle_no;

    public Vehicle(String vehicle_name, String vehicle_no){
        this.Id = null;
        this.vehicle_name = vehicle_name;
        this.vehicle_no = vehicle_no;
    }

    public Vehicle(Long Id, Vehicle other){
        this.Id = Id;
        this.vehicle_name = other.vehicle_name;
        this.vehicle_no = other.vehicle_no;
    }
}

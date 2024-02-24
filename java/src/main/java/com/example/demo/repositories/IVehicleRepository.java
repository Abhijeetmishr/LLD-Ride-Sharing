package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Vehicle;

public interface IVehicleRepository {
    Vehicle save(Vehicle vehicle);
    Vehicle update(Long Id, Vehicle vehicle);
    boolean exists(String vehicle_no);
    Optional<Vehicle> findById(Long Id);
    List<Vehicle> findAll();
    void deleteById(Long Id);
}

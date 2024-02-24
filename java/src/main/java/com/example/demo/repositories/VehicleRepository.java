package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import com.example.demo.entities.Vehicle;

public class VehicleRepository implements IVehicleRepository {
    AtomicLong idCounter = new AtomicLong(1);
    Map<Long,Vehicle> storage = new HashMap<>();

    @Override
    public Vehicle save(Vehicle vehicle) {
        Vehicle entity = new Vehicle(idCounter.getAndIncrement(), vehicle);
        storage.putIfAbsent(entity.getId(), entity);
        return entity;
    }

    @Override
    public Vehicle update(Long Id, Vehicle vehicle) {
       storage.put(Id, vehicle);
       return storage.get(Id);
    }

    @Override
    public boolean exists(String vehicle_no) {
        return storage.values().stream().anyMatch(val -> 
                        val.getVehicle_no().equals(vehicle_no));
    }

    @Override
    public Optional<Vehicle> findById(Long Id) {
        return Optional.ofNullable(storage.get(Id));
    }

    @Override
    public List<Vehicle> findAll() {
        return storage.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long Id) {
        storage.remove(Id);
    }
    
}

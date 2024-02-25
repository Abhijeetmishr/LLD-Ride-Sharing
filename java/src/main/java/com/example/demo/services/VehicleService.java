package com.example.demo.services;

import java.util.Optional;

import com.example.demo.entities.User;
import com.example.demo.entities.Vehicle;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.repositories.IVehicleRepository;

public class VehicleService implements IVehicleService {
    private IVehicleRepository vehicleRepository;
    private IUserRepository userRepository;

    public VehicleService(IUserRepository userRepository, IVehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String add_vehicle(String user_name, String vehicle_name, String vehicle_no) {
        if(user_name == null || vehicle_name == null || vehicle_no == null)
            throw new RuntimeException("Fields are mandatory!"); 
        
        boolean isExist = vehicleRepository.exists(vehicle_no);
        if(!isExist){
            Vehicle entity = new Vehicle(vehicle_name, vehicle_no);
            Vehicle vehicle = vehicleRepository.save(entity);
            User user = userRepository.findByUserName(user_name).orElseThrow(() -> new RuntimeException("User not registered"));
            user.setVehicles(vehicle_no, vehicle);
            userRepository.update(user.getId(), user);
            return vehicle.getVehicle_name();
        } else {
            throw new RuntimeException("vehicle already exists.");
        }
    }
    
}

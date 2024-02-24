package com.example.demo.services;

import com.example.demo.entities.Vehicle;
import com.example.demo.repositories.IVehicleRepository;

public class VehicleService implements IVehicleService {
    private IVehicleRepository vehicleRepository;

    public VehicleService(IVehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public String add_vehicle(String user_name, String vehicle_name, String vehicle_no) {
        if(user_name == null || vehicle_name == null || vehicle_no == null)
            throw new RuntimeException("Fields are mandatory!"); 
        
        boolean isExist = vehicleRepository.exists(vehicle_no);

        if(!isExist){
            Vehicle entity = new Vehicle(user_name, vehicle_name, vehicle_no);
            Vehicle vehicle = vehicleRepository.save(entity);
            return vehicle.getVehicle_name();
        } else {
            throw new RuntimeException("vehicle already exists.");
        }
    }
    
}

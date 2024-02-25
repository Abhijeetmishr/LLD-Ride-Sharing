package com.example.demo.strategy;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entities.Ride;
import com.example.demo.repositories.IRideRepository;

public class PreferredVehicleStrategy implements IRideSelectionStrategy{
    private IRideRepository rideRepository;

    public PreferredVehicleStrategy(IRideRepository rideRepository){
        this.rideRepository = rideRepository;
    }

    @Override
    public List<Ride> getMatchingRides(String source, String destination, Long seats, String vehicleName) {
       return rideRepository.findAll().stream().filter(ride -> 
            ride.getSource().equals(source) &&
            ride.getDestination().equals(destination) &&
            ride.getAvailableSeats() >= seats &&
            ride.getVehicle_name().equals(vehicleName)
       ).collect(Collectors.toList());
    }
    
}

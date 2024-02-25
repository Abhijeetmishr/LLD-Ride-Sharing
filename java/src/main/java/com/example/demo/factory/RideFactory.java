package com.example.demo.factory;

import com.example.demo.entities.VehicleType;
import com.example.demo.repositories.IRideRepository;
import com.example.demo.strategy.IRideSelectionStrategy;
import com.example.demo.strategy.MostVacantRideStrategy;
import com.example.demo.strategy.MultipleRideSelectionStrategy;
import com.example.demo.strategy.PreferredVehicleStrategy;

public class RideFactory implements IRideFactory{
    private IRideRepository rideRepository;

    public RideFactory(IRideRepository rideRepository){
        this.rideRepository = rideRepository;
    }

    public IRideSelectionStrategy createSelectionStrategy(String selectionStrategy){

        for (VehicleType vehicleType : VehicleType.values()) {
            if (vehicleType.name().equals(selectionStrategy)) {
                selectionStrategy = "Preferred Vehicle";
                break;
            }
        }
        
        switch (selectionStrategy) {
            case "Most Vacant":
                return new MostVacantRideStrategy(rideRepository);
            case "Preferred Vehicle":
                return new PreferredVehicleStrategy(rideRepository);
            default:
                return new MultipleRideSelectionStrategy(rideRepository);
        }
    }
}

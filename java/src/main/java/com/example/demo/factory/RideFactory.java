package com.example.demo.factory;

import com.example.demo.repositories.IRideRepository;
import com.example.demo.strategy.IRideSelectionStrategy;
import com.example.demo.strategy.MostVacantRideStrategy;
import com.example.demo.strategy.PreferredVehicleStrategy;

public class RideFactory implements IRideFactory{
    private IRideSelectionStrategy rideSelectionStrategy;
    private IRideRepository rideRepository;

    public RideFactory(IRideRepository rideRepository){
        this.rideRepository = rideRepository;
    }

    public IRideSelectionStrategy createSelectionStrategy(String selectionStrategy){
        if(selectionStrategy.equals("Most Vacant")){
           this.rideSelectionStrategy = new MostVacantRideStrategy(rideRepository);
        }else {
            this.rideSelectionStrategy = new PreferredVehicleStrategy(rideRepository);
        }
        return rideSelectionStrategy;
    }
}

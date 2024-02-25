package com.example.demo.strategy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entities.Ride;
import com.example.demo.repositories.IRideRepository;

public class MostVacantRideStrategy implements IRideSelectionStrategy{
    private IRideRepository rideRepository;

    public MostVacantRideStrategy(IRideRepository rideRepository){
        this.rideRepository = rideRepository;
    }

    @Override
    public List<Ride> getMatchingRides(String source, String destination, Long seats, String selectionStrategy) {
        List<Ride> rideList =  rideRepository.findAll().stream().filter(ride -> 
            ride.getSource().equals(source) &&
            ride.getDestination().equals(destination) &&
            ride.getAvailableSeats() >= seats
       ).collect(Collectors.toList());

        rideList.sort((r1, r2) -> Long.compare(r2.getAvailableSeats(), r1.getAvailableSeats()));
        return rideList;
    }
    
}

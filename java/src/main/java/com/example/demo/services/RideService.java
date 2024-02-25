package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.entities.Ride;
import com.example.demo.entities.RideStatus;
import com.example.demo.entities.User;
import com.example.demo.factory.IRideFactory;
import com.example.demo.repositories.IRideRepository;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.repositories.IVehicleRepository;

public class RideService implements IRideService {
    private static int counter = 1;
    private IUserRepository userRepository;
    private IVehicleRepository vehicleRepository;
    private IRideRepository rideRepository;
    private IRideFactory rideFactory;

    public RideService(IUserRepository userRepository,
                        IVehicleRepository vehicleRepository,
                        IRideRepository rideRepository,
                        IRideFactory rideFactory
                    ){
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
        this.rideRepository = rideRepository;
        this.rideFactory = rideFactory;
    }

    @Override
    public String offer_ride(String user_name, String source, Long seats, String vehicle_name, String vehicle_no,
            String destination) {
        User user = userRepository.findByUserName(user_name).orElseThrow(() -> new RuntimeException("user doesn't exist"));
        if(rideAlreadyOffered(user_name, vehicle_name, vehicle_no)){
            return "Ride already been offered by " + user_name;
        }
        String Id = generateUniqueId();
        Ride entity = new Ride(Id, user_name, source, seats, vehicle_name, vehicle_no, destination);
    
        Ride ride = rideRepository.save(entity);
    
        user.setOffered(ride);
        userRepository.update(user.getId(), user);
        return "Ride offered by " + ride.getOfferBy();
    }

    private boolean rideAlreadyOffered(String user_name,String vehicle_name, String vehicle_no) {
        return rideRepository.findAll().stream().anyMatch(ride ->
                 ride.getOfferBy().equals(user_name) && 
                 ride.getVehicle_name().equals(vehicle_name) &&
                 ride.getVehicle_no().equals(vehicle_no));
    }

    @Override
    public String select_ride(String user_name, String source, String destination, Long seats,
    String selectionStrategy) {
        User bookedBy = userRepository.findByUserName(user_name).orElseThrow(() -> new RuntimeException("user doesn't exist"));
        List<Ride> ride = rideFactory.createSelectionStrategy(selectionStrategy).getMatchingRides(source, destination, seats, selectionStrategy);
        if(ride.size() == 0) return "No rides found";
        Ride bookedRide = ride.get(0);

        bookedRide.setAvailableSeats(bookedRide.getAvailableSeats()-1);
        bookedRide.setStatus(RideStatus.STARTED);

        rideRepository.update(bookedRide.getId(), bookedRide);
        bookedBy.setTaken(bookedRide);
        userRepository.update(bookedBy.getId(), bookedBy);
        
        return bookedRide.getId();
    }

    @Override
    public String end_ride(String ride_id) {
        Ride ride = rideRepository.findById(ride_id).orElseThrow(() -> 
                                new RuntimeException("ride not found!"));
        ride.setStatus(RideStatus.COMPLETED);
        return "Ride " + ride_id + " ended."; 
    }

    @Override
    public String ride_stats() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(user -> {
            String userName = user.getUser_name();
            int offeredCount = user.getOffered().size();
            int takenCount = user.getTaken().size();
            return String.format("%s: %d Taken, %d Offered", userName, takenCount, offeredCount);
        }).collect(Collectors.joining("\n"));
    }

    public static String generateUniqueId() {
        int number = (counter - 1) / 26 + 2;
        char character = (char) ('a' + (counter - 1) % 26);
        String uniqueId = number + "-" + character;
        counter++;
        return uniqueId;
    }
}

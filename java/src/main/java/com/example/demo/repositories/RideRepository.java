package com.example.demo.repositories;

import java.util.*;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import com.example.demo.entities.Ride;

public class RideRepository implements IRideRepository {
    Map<String,Ride> storage = new HashMap<>();
    @Override
    public Ride save(Ride ride) {
        storage.putIfAbsent(ride.getId(), ride);
        return ride;
    }

    @Override
    public Ride update(String Id, Ride ride) {
        storage.put(Id, ride);
        return storage.get(Id);
    }

    @Override
    public Optional<Ride> findById(String Id) {
        return Optional.ofNullable(storage.get(Id));
    }

    @Override
    public Optional<Ride> findByUserName(String user_name) {
        return storage.values().stream().findAny().filter(ride -> 
            ride.getOfferedBy().equals(user_name));
    }

    @Override
    public List<Ride> findAll() {
        return storage.values().stream().collect(Collectors.toList());
    }
    
}

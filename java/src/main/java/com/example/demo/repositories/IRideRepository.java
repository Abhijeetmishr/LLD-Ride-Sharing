package com.example.demo.repositories;

import java.util.Optional;
import java.util.List;
import com.example.demo.entities.Ride;

public interface IRideRepository {
    Ride save(Ride ride);
    Ride update(String Id, Ride ride);
    Optional<Ride> findById(String Id);
    Optional<Ride> findByUserName(String user_name);
    List<Ride> findAll();
}

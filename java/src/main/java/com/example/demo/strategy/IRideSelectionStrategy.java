package com.example.demo.strategy;

import java.util.List;

import com.example.demo.entities.Ride;

public interface IRideSelectionStrategy {
    public List<Ride> getMatchingRides(String source, String destination, Long seats, String selectionStrategy);
}

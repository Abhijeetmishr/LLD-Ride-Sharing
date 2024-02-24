package com.example.demo.services;

import com.example.demo.entities.SelectionStrategy;

/**
 * Bonus Question:
    Multiple Rides Output: If a direct route is not available, output multiple rides that can facilitate the journey.
 */
public interface IRideService {
    String offer_ride(String driver, String source, Long seats, String vehicle_name, String vehicle_no, String destination);
    String select_ride(String user_name, String source, String destination, Long seats, SelectionStrategy selectionStrategy);
    String end_ride(Long ride_id);
    String ride_stats();
}

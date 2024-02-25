package com.example.demo.strategy;

import java.util.stream.Collectors;
import java.util.*;

import com.example.demo.entities.Ride;
import com.example.demo.repositories.IRideRepository;

public class MultipleRideSelectionStrategy implements IRideSelectionStrategy{
    private IRideRepository rideRepository;

    public MultipleRideSelectionStrategy(IRideRepository rideRepository){
        this.rideRepository = rideRepository;
    }

    @Override
    public List<Ride> getMatchingRides(String source, String destination, Long seats, String selectionStrategy) {
        Map<String, List<String>> adjList = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for (Ride ride : rideRepository.findAll()) {
            String origin = ride.getSource();
            String dest = ride.getDestination();
            adjList.computeIfAbsent(origin, k -> new ArrayList<>()).add(dest);
        }
       
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);

        while(!queue.isEmpty()){
            String city = queue.poll();
            if(city.equals(destination)){
                return rideRepository.findAll().stream().filter(ride -> 
                    visited.contains(ride.getSource())).collect(Collectors.toList());
            }
            for(String neighbor: adjList.get(city)){
                if(!visited.contains(neighbor)){
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return new ArrayList<>();
    }
    
}

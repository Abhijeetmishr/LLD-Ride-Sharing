package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Ride {
    private String Id;
    private String offeredBy;
    private String source;
    private Long availableSeats;
    private String vehicle_name;
    private String vehicle_no;
    private String destination;
    private RideStatus status;

    public Ride(String Id, String offeredBy, String source, Long availableSeats,
                String vehicle_name, String vehicle_no, String destination
                ){
        this.Id = Id;
        this.offeredBy = offeredBy;
        this.source = source;
        this.availableSeats = availableSeats;
        this.vehicle_name = vehicle_name;
        this.vehicle_no = vehicle_no;
        this.destination = destination;
        this.status = RideStatus.INITIATED;
    }

    // public Ride(String Id, Ride other){
    //     this.Id = Id;
    //     this.offeredBy = other.offeredBy;
    //     this.source = other.source;
    //     this.availableSeats = other.availableSeats;
    //     this.vehicle_name = other.vehicle_name;
    //     this.vehicle_no = other.vehicle_no;
    //     this.destination = other.destination;
    //     this.status = other.status;
    // }

}

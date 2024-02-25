package com.example.demo.entities;

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

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getOfferBy() {
        return offeredBy;
    }

    public void setOfferBy(String offeredBy) {
        this.offeredBy = offeredBy;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Long availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

}

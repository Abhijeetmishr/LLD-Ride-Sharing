package com.example.demo.entities;

public class Ride {
    private Long Id;
    private String driver;
    private String source;
    private Long availableSeats;
    private String vehicle_name;
    private String vehicle_no;
    private String destination;

    public Ride(String driver, String source, Long availableSeats,
                String vehicle_name, String vehicle_no, String destination
                ){
        this.Id = null;
        this.driver = driver;
        this.source = source;
        this.availableSeats = availableSeats;
        this.vehicle_name = vehicle_name;
        this.vehicle_no = vehicle_no;
        this.destination = destination;
    }

    public Ride(Long Id, Ride other){
        this.Id = Id;
        this.driver = other.driver;
        this.source = other.source;
        this.availableSeats = other.availableSeats;
        this.vehicle_name = other.vehicle_name;
        this.vehicle_no = other.vehicle_no;
        this.destination = other.destination;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
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

}

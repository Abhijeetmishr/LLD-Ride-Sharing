# LLD-Ride-Sharing

## API DESIGN
    - String add_user(String user_name, Gender gender, Long age);
    - String add_vehicle(String user_name, String vehicle_name, String vehicle_no);
    - String offer_ride(String driver, String source, Long seats, String vehicle_name, String vehicle_no, String destination);
    - String select_ride(String user_name, String source, String destination, Long seats, String selectionStrategy);
    - String end_ride(String ride_id);
    - String ride_stats();

## Classes

    public class User {
        private Long Id;
        private String user_name;
        private Gender gender;
        private Long age;
        Map<String, Vehicle> vehicles;
        Set<Ride> offered;
        Set<Ride> taken;
    }

    public class Vehicle {
        private Long Id;
        private String vehicle_name;
        private String vehicle_no;
    }

    public class Ride {
        private String Id;
        private String offeredBy;
        private String source;
        private Long availableSeats;
        private String vehicle_name;
        private String vehicle_no;
        private String destination;
        private RideStatus status;
    }

    public enum RideStatus {
        INITIATED,
        STARTED,
        COMPLETED
    }

    public enum Gender {
        M,
        F
    }

## INPUT
    add("ADD_USER,Rohan,M,36");
    add("ADD_VEHICLE,Rohan,Swift,KA-01-12345");
    add("ADD_USER,Shashank,M,29");
    add("ADD_VEHICLE,Shashank,Baleno,TS-05-62395");
    add("ADD_USER,Nandini,F,29");
    add("ADD_USER,Shipra,F,27");
    add("ADD_VEHICLE,Shipra,Polo,KA-05-41491");
    add("ADD_VEHICLE,Shipra,Activa,KA-12-12332");
    add("ADD_USER,Gaurav,M,29");
    add("ADD_USER,Rahul,M,35");
    add("ADD_VEHICLE,Rahul,XUV,KA-05-1234");
    add("OFFER_RIDE,Rohan,Hyderabad,1,Swift,KA-01-12345,Bangalore");
    add("OFFER_RIDE,Shipra,Bangalore,1,Activa,KA-12-12332,Mysore");
    add("OFFER_RIDE,Shipra,Bangalore,2,Polo,KA-05-41491,Mysore");
    add("OFFER_RIDE,Shashank,Hyderabad,2,Baleno,TS-05-62395,Bangalore");
    add("OFFER_RIDE,Rahul,Hyderabad,5,XUV,KA-05-1234,Bangalore");
    add("OFFER_RIDE,Rohan,Bangalore,1,Swift,KA-01-12345,Pune");
    add("SELECT_RIDE,Nandini,Bangalore,Mysore,1,Most Vacant");
    add("SELECT_RIDE,Gaurav,Bangalore,Mysore,1,Activa");
    add("SELECT_RIDE,Shashank,Mumbai,Bangalore,1,Most Vacant");
    add("SELECT_RIDE,Rohan,Hyderabad,Bangalore,1,Baleno");
    add("SELECT_RIDE,Shashank,Hyderabad,Bangalore,1,Polo");
    add("END_RIDE,2-a");
    add("END_RIDE,2-b");
    add("END_RIDE,2-c");
    add("END_RIDE,2-d");
    add("PRINT_RIDE_STATS");

## OUTPUT
    1 Rohan
    Swift
    2 Shashank
    Baleno
    3 Nandini
    4 Shipra
    Polo
    Activa
    5 Gaurav
    6 Rahul
    XUV
    Ride offered by Rohan
    Ride offered by Shipra
    Ride offered by Shipra
    Ride offered by Shashank
    Ride offered by Rahul
    Ride already been offered by Rohan
    2-c
    2-b
    No rides found
    2-d
    No rides found
    Ride 2-a ended.
    Ride 2-b ended.
    Ride 2-c ended.
    Ride 2-d ended.
    Rohan: 1 Taken, 1 Offered
    Shashank: 0 Taken, 1 Offered
    Nandini: 1 Taken, 0 Offered
    Shipra: 0 Taken, 2 Offered
    Gaurav: 1 Taken, 0 Offered
    Rahul: 0 Taken, 1 Offered
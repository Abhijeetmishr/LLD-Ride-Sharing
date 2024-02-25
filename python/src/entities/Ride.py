import RideStatus

class Ride:
    def __init__(self, Id, offeredBy, source, availableSeats, vehicle_name, vehicle_no, destination):
        self.Id = Id
        self.offeredBy = offeredBy
        self.source = source
        self.availableSeats = availableSeats
        self.vehicle_name = vehicle_name
        self.vehicle_no = vehicle_no
        self.destination = destination
        self.status = RideStatus.INITIATED
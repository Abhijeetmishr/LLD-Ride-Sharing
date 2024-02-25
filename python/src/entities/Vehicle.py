class Vehicle:
    def __init__(self, vehicle_name, vehicle_no):
        self.Id = None
        self.vehicle_name = vehicle_name
        self.vehicle_no = vehicle_no

    def __init__(self, Id, other=None):
        self.Id = Id
        self.vehicle_name = other.vehicle_name
        self.vehicle_no = other.vehicle_no
            
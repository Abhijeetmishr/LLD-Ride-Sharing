class User:
    def __init__(self, user_name, gender, age):
        self.Id = None
        self.user_name = user_name
        self.gender = gender
        self.age = age
        self.vehicles = {}
        self.offered = set()
        self.taken = set()

    def __init__(self, Id, other):
        self.Id = Id
        self.user_name = other.user_name
        self.gender = other.gender
        self.age = other.age
        self.vehicles = other.vehicles
        self.offered = other.offered
        self.taken = other.taken
            

    def getVehicles(self):
        return list(self.vehicles.values())

    def setVehicles(self, vehicle_no, vehicle):
        self.vehicles.setdefault(vehicle_no, vehicle)

    def getOffered(self):
        return list(self.offered)

    def setOffered(self, ride):
        self.offered.add(ride)

    def getTaken(self):
        return list(self.taken)

    def setTaken(self, ride):
        self.taken.add(ride)


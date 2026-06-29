from model.farm_animal import FarmAnimal
from datetime import datetime


class Sheep(FarmAnimal):
    def __init__(self, id, breed, born_on, weight, health_status, last_sheering, wool_quality):
        super().__init__(id, breed, born_on, weight, health_status)
        self.last_sheering = last_sheering
        self.wool_quality = wool_quality

    def shear(self):
        self.last_sheering = datetime.now()
        self.history.append("Sheared")
        return "Shearing completed"

    def to_dict(self):
        return self.__dict__
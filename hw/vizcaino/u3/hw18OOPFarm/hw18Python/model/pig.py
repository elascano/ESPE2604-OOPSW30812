from model.farm_animal import FarmAnimal
from model.meat_animal import IMeatAnimal


class Pig(FarmAnimal, IMeatAnimal):
    def __init__(self, id, breed, born_on, weight, health_status, ideal_weight, pen_number):
        super().__init__(id, breed, born_on, weight, health_status)
        self.ideal_weight = ideal_weight
        self.pen_number = pen_number

    def cut(self):
        if self.weight >= self.ideal_weight:
            return {"type": "Premium", "yield": 0.70}
        return {"type": "Commercial", "yield": 0.55}

    def send_to_slaughter_house(self, slaughter_house):
        slaughter_house.receive(self)

    def to_dict(self):
        return self.__dict__
from model.farm_animal import FarmAnimal
from model.meat_animal import IMeatAnimal


class Cow(FarmAnimal, IMeatAnimal):
    def __init__(self, id, breed, born_on, weight, health_status, is_producing_milk, daily_milk_yield):
        super().__init__(id, breed, born_on, weight, health_status)
        self.is_producing_milk = is_producing_milk
        self.daily_milk_yield = daily_milk_yield

    def milk(self):
        return self.daily_milk_yield if self.is_producing_milk else 0

    def cut(self):
        return {"type": "Beef", "yield": 0.65}

    def send_to_slaughter_house(self, slaughter_house):
        slaughter_house.receive(self)

    def to_dict(self):
        return self.__dict__
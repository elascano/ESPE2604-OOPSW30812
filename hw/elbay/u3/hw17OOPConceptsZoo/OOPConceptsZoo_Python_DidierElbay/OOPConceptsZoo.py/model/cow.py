# Author: Didier Elbay
# Cow model - OOP Concepts Zoo Project

from model.farm_animal import FarmAnimal
from controller.i_meat_animal import IMeatAnimal
from model.cut import Cut


class Cow(FarmAnimal, IMeatAnimal):
    def __init__(self, id_animal, breed, born_on, weight, is_producing_milk, milk_amount):
        super().__init__(id_animal, breed, born_on, weight)
        self.is_producing_milk = is_producing_milk
        self.milk_amount = milk_amount

    def milk(self):
        """Returns the milk production amount in liters."""
        return self.milk_amount

    def get_milk_efficiency(self):
        """Returns milk efficiency as a percentage of body weight."""
        if self.weight <= 0:
            return 0.0
        return (self.milk_amount / self.weight) * 100

    def cut(self):
        """Returns the expected meat cuts from this cow."""
        return [
            Cut(10, "T-Bone", "Rib Section", round(self.weight * 0.20, 2)),
            Cut(11, "Ribeye", "Loin Section", round(self.weight * 0.12, 2)),
        ]

    def send_to_slaughter_house(self, slaughterhouse):
        print(f"Cow {self.id} sent to {slaughterhouse.description}")

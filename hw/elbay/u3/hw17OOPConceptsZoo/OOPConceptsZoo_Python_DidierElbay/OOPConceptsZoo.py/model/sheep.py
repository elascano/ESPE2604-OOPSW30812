# Author: Didier Elbay
# Sheep model - OOP Concepts Zoo Project

from model.farm_animal import FarmAnimal
from datetime import date


class Sheep(FarmAnimal):
    def __init__(self, id_animal, breed, born_on, weight, last_sheering):
        super().__init__(id_animal, breed, born_on, weight)
        self.last_sheering = last_sheering

    def shear(self):
        """Performs a shearing on this sheep and updates the last shearing date."""
        self.last_sheering = date.today()
        print(f"Sheep {self.id} has been sheared on {self.last_sheering}.")

    def is_ready_for_shearing(self):
        """Returns True if the sheep weight is within the optimal shearing range."""
        return 45.0 <= self.weight <= 80.0

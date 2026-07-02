# Author: Didier Elbay
# Pig model - OOP Concepts Zoo Project

from model.farm_animal import FarmAnimal
from controller.i_meat_animal import IMeatAnimal
from model.cut import Cut


class Pig(FarmAnimal, IMeatAnimal):
    def __init__(self, id_animal, breed, born_on, weight, ideal_weight):
        super().__init__(id_animal, breed, born_on, weight)
        self.ideal_weight = ideal_weight

    def send_to_butcher(self):
        print(f"Pig {self.id} sent to butcher.")

    def cut(self):
        """Returns the expected meat cuts from this pig."""
        return [
            Cut(1, "Pork Chop", "Standard Cut", round(self.weight * 0.15, 2)),
            Cut(2, "Ribs", "Rib Extraction", round(self.weight * 0.10, 2)),
        ]

    def send_to_slaughter_house(self, slaughterhouse):
        print(f"Pig {self.id} sent to {slaughterhouse.description}")

    def is_ready_for_slaughter(self):
        """Returns True if the pig has reached its ideal weight."""
        return self.weight >= self.ideal_weight

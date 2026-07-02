# Author: Didier Elbay
# Chicken model - OOP Concepts Zoo Project

from model.farm_animal import FarmAnimal


class Chicken(FarmAnimal):
    def __init__(self, id_animal, breed, born_on, weight, is_molting, number_of_eggs_per_week):
        super().__init__(id_animal, breed, born_on, weight)
        self.is_molting = is_molting
        self.number_of_eggs_per_week = number_of_eggs_per_week

    def lay_an_egg(self):
        print(f"Chicken {self.id} laid an egg.")

    def operation(self):
        """Performs the standard chicken farm operation check."""
        if not self.is_molting and self.number_of_eggs_per_week > 2:
            print(f"Chicken {self.id}: Optimal Production.")
        else:
            print(f"Chicken {self.id}: Low Efficiency.")

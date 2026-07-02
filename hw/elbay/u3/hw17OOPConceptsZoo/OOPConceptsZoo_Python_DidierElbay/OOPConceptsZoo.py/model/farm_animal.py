# Author: Didier Elbay
# Farm Animal base class - OOP Concepts Zoo Project

from model.food import Food
from datetime import date


class FarmAnimal:
    def __init__(self, id_animal, breed, born_on, weight):
        self.id = id_animal
        self.breed = breed
        self.born_on = born_on
        self.weight = weight

    def get_age_in_months(self):
        today = date.today()
        months = (today.year - self.born_on.year) * 12 + (today.month - self.born_on.month)
        return max(0, months)

    def feed(self, food):
        print(f"Animal {self.id} is eating {food.description}")

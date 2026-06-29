from abc import ABC, abstractmethod
from datetime import date

class FarmAnimal(ABC):

    def __init__(self, id, breed, weight):
        self.id = id
        self.breed = breed
        self.weight = weight
        self.born_on = date.today()

    def feed(self, food):
        print(f"{self.breed} is eating {food.description}")

    def get_age_in_months(self):
        return 1

    # Business Rule 1
    def is_young_animal(self):
        return self.weight < 100

    # Business Rule 2
    def is_ready_for_sale(self):
        return self.weight >= 300

    # Business Rule 3
    def needs_more_food(self):
        return self.weight < 50

    @abstractmethod
    def born(self):
        pass
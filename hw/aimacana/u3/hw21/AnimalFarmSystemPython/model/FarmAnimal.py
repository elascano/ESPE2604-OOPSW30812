from abc import ABC, abstractmethod
from datetime import date


class FarmAnimal(ABC):

    def __init__(self, id, breed, born_on, weight,
                 slaughter_house, product, cuts):

        self.id = id
        self.breed = breed
        self.born_on = born_on
        self.weight = weight
        self.slaughter_house = slaughter_house
        self.product = product
        self.cuts = cuts

    def get_age_in_months(self):
        today = date.today()

        months = (today.year - self.born_on.year) * 12
        months += today.month - self.born_on.month

        if today.day < self.born_on.day:
            months -= 1

        return months

    @abstractmethod
    def feed(self, food):
        pass

    def __str__(self):
        return (f"FarmAnimal(id={self.id}, "
                f"breed='{self.breed}', "
                f"weight={self.weight})")
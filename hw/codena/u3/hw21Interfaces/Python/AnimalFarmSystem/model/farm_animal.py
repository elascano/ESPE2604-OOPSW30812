from abc import ABC, abstractmethod
from datetime import date

class FarmAnimal(ABC):
    def __init__(self, id, breed, born_on_date, weight, slaughter_house, product, cuts):
        self.id = id
        self.breed = breed
        self.born_on_date = born_on_date
        self.weight = weight
        self.slaughter_house = slaughter_house
        self.product = product
        self.cuts = cuts

    def get_age_in_months(self):
        if self.born_on_date is None:
            raise ValueError("born_on_date cannot be None")

        current_date = date.today()

        months = (
            (current_date.year - self.born_on_date.year) * 12
            + (current_date.month - self.born_on_date.month)
        )

        if current_date.day < self.born_on_date.day:
            months -= 1

        return months
    
    @abstractmethod
    def feed(self, food):
        pass
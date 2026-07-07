from abc import ABC, abstractmethod
from datetime import datetime

class FarmAnimal(ABC):
    def __init__(self, id, breed, born_on, weight, slaughter_house, product, cuts):
        self._id = id
        self._breed = breed
        self._born_on = born_on if born_on is not None else datetime.now()
        self._weight = weight
        self._slaughter_house = slaughter_house
        self._product = product
        self._cuts = cuts

    def get_age_in_months(self):
        if not self._born_on:
            raise ValueError("The birth date has not been assigned.")
        birth_date = self._born_on
        today = datetime.now()
        if birth_date > today:
            raise ValueError("The birth date cannot be in the future.")
        months = (today.year - birth_date.year) * 12
        return months + (today.month - birth_date.month)

    @abstractmethod
    def feed(self, food):
        pass

    def get_id(self): return self._id
    def set_id(self, id): self._id = id
    def get_breed(self): return self._breed
    def set_breed(self, breed): self._breed = breed
    def get_born_on(self): return self._born_on
    def set_born_on(self, born_on): self._born_on = born_on
    def get_weight(self): return self._weight
    def set_weight(self, weight): self._weight = weight
    def get_slaughter_house(self): return self._slaughter_house
    def set_slaughter_house(self, slaughter_house): self._slaughter_house = slaughter_house
    def get_product(self): return self._product
    def set_product(self, product): self._product = product
    def get_cuts(self): return self._cuts
    def set_cuts(self, cuts): self._cuts = cuts
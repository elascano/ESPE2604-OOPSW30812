from abc import ABC
from datetime import datetime


class FarmAnimal(ABC):
    def __init__(self, id, breed, age_in_months, weight):
        self.id = id
        self.breed = breed
        self.age_in_months = age_in_months
        self.weight = weight
        self.history = []

    def to_dict(self):
        return self.__dict__
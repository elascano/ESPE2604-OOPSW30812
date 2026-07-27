from abc import ABC, abstractmethod
from datetime import date


class FarmAnimal(ABC):

    def __init__(self, id, breed, born_on_date, weight):

        self.id = id
        self.breed = breed
        self.born_on_date = born_on_date
        self.weight = weight

    @abstractmethod
    def to_document(self):
        pass

    @abstractmethod
    def feed(self, food):
        pass

    @property
    def get_age_in_months(self):

        today = date.today()
        years_in_months = (today.year-self.born_on_date.year)*12
        age_in_months = years_in_months + (today.month-self.born_on_date.month)
        
        return age_in_months
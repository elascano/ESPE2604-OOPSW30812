from abc import ABC, abstractmethod


class MealPreparation(ABC):
    def prepare_meal(self):
        self.gather_ingredients()
        self.cook()
        self.plate()
        if self.wants_garnish():
            self.add_garnish()

    def gather_ingredients(self):
        print("Gathering ingredients")

    @abstractmethod
    def cook(self):
        pass

    def plate(self):
        print("Plating the dish")

    @abstractmethod
    def add_garnish(self):
        pass

    def wants_garnish(self):
        return True

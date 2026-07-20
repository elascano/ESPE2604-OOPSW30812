"""
@author Cristian Palomo, Error 404, @ESPE
"""
from abc import ABC, abstractmethod


class CaffeineBeverage(ABC):
    
    def prepare_recipe(self) -> None:
        """Template Method: no debe ser sobrescrito por las subclases."""
        self.boil_water()
        self.brew()
        self.pour_in_cup()
        if self.wants_condiments():
            self.add_condiments()

    def boil_water(self) -> None:
        print("Boiling water")

    def pour_in_cup(self) -> None:
        print("Pouring into cup")

    @abstractmethod
    def brew(self) -> None:
        ...

    @abstractmethod
    def add_condiments(self) -> None:
        ...

    def wants_condiments(self) -> bool:
        """Hook: comportamiento por defecto que las subclases pueden sobrescribir."""
        return True

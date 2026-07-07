from datetime import date
from model.farm_animal import FarmAnimal
from model.interfaces import IProduceAnimal
from model.infrastructure import Product

class Chicken(FarmAnimal, IProduceAnimal):
    def __init__(self, id_animal: int, breed: str, born_on: date, weight: float, is_molting: bool, eggs_per_week: int):
        super().__init__(id_animal, breed, born_on, weight)
        self._is_molting = is_molting
        self._number_of_eggs_per_week = eggs_per_week

    def lay_an_egg(self) -> str:
        if not self._is_molting:
            return "The hen has successfully laid an egg.."
        return "The hen is molting; she cannot lay eggs at the moment.."

    def procedure(self) -> str:
        return "Manual egg collection in the poultry house."

    def measure_quantity(self, unit: str, quantity: float) -> None:
        self.product = Product(101, "Free-range eggs", unit, quantity)


class Sheep(FarmAnimal, IProduceAnimal):
    def __init__(self, id_animal: int, breed: str, born_on: date, weight: float, last_sheering: date):
        super().__init__(id_animal, breed, born_on, weight)
        self._last_sheering = last_sheering

    def procedure(self) -> str:
        return "Esquilado mecánico de lana fina."

    def measure_quantity(self, unit: str, quantity: float) -> None:
        self.product = Product(102, "Sheep's Wool", unit, quantity)
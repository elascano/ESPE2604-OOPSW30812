from datetime import date
from typing import List
from model.farm_animal import FarmAnimal
from model.interfaces import IMeatAnimal
from model.infrastructure import Cut, SlaughterHouse

class Pig(FarmAnimal, IMeatAnimal):
    def __init__(self, id_animal: int, breed: str, born_on: date, weight: float, ideal_weight: float):
        super().__init__(id_animal, breed, born_on, weight)
        self._ideal_weight = ideal_weight

    def cut(self) -> List[Cut]:
        self.cuts = [Cut(1, "Pork chop", "Primary cut", self._weight * 0.2)]
        return self.cuts

    def send_to_slaughter_house(self, slaughter_house: SlaughterHouse) -> None:
        self.slaughter_house = slaughter_house._name


class Cow(FarmAnimal, IMeatAnimal):
    def __init__(self, id_animal: int, breed: str, born_on: date, weight: float, is_producing_milk: bool):
        super().__init__(id_animal, breed, born_on, weight)
        self._is_producing_milk = is_producing_milk

    def is_producing_milk_status(self) -> bool:
        return self._is_producing_milk

    def milk(self) -> float:
        if self._is_producing_milk:
            return 15.5  # Litros promedio simulados
        return 0.0

    def cut(self) -> List[Cut]:
        self.cuts = [Cut(2, "Beef Tenderloin", "Rear cut", self._weight * 0.15)]
        return self.cuts

    def send_to_slaughter_house(self, slaughter_house: SlaughterHouse) -> None:
        self.slaughter_house = slaughter_house._name
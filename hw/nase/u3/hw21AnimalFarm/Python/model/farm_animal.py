from abc import ABC
from datetime import date
from typing import List, Optional
from model.infrastructure import Cut, Food, Product

class FarmAnimal(ABC):
    def __init__(self, id_animal: int, breed: str, born_on: date, weight: float):
        self._id = id_animal
        self._breed = breed
        self._born_on = born_on
        self._weight = weight
        
        self.cuts: List[Cut] = []
        self.product: Optional[Product] = None
        self.slaughter_house: Optional[str] = None

    def get_age_in_months(self) -> int:
        today = date.today()
        return (today.year - self._born_on.year) * 12 + today.month - self._born_on.month

    def feed(self, food: Food) -> str:
        return f"The purebred animal {self._breed} has been fed with: {food._description}"
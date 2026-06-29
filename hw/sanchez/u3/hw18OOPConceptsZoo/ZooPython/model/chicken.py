from datetime import datetime
from model.farm_animal import FarmAnimal

class Chicken(FarmAnimal):
    def __init__(self, id: int, breed: str, born_on: datetime, weight: float, is_molting: bool):
        super().__init__(id, breed, born_on, weight)
        self.is_molting = is_molting
        self.number_of_eggs_per_week = 0
    
    def lay_an_egg(self) -> int:
        if not self.is_molting:
            self.number_of_eggs_per_week += 1
            return 1
        return 0
    
    def food(self, food):
        print(f"Feeding chicken with: {food.description}")
    
    def __str__(self):
        return f"Chicken(id={self.id}, breed='{self.breed}', born_on={self.born_on}, weight={self.weight}, is_molting={self.is_molting}, eggs_per_week={self.number_of_eggs_per_week})"
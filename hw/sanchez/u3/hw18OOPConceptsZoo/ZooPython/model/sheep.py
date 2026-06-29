from datetime import datetime
from model.farm_animal import FarmAnimal

class Sheep(FarmAnimal):
    def __init__(self, id: int, breed: str, born_on: datetime, weight: float, last_sheering: datetime):
        super().__init__(id, breed, born_on, weight)
        self.last_sheering = last_sheering
    
    def food(self, food):
        print(f"Feeding sheep with: {food.description}")
    
    def __str__(self):
        return f"Sheep(id={self.id}, breed='{self.breed}', born_on={self.born_on}, weight={self.weight}, last_sheering={self.last_sheering})"
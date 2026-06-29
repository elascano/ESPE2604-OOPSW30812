from datetime import datetime
from abc import ABC, abstractmethod

class FarmAnimal(ABC):
    def __init__(self, id: int, breed: str, born_on: datetime, weight: float):
        self.id = id
        self.breed = breed
        self.born_on = born_on
        self.weight = weight
    
    def get_age_in_months(self) -> int:
        now = datetime.now()
        diff = now - self.born_on
        months = diff.days // 30
        return months
    
    @abstractmethod
    def food(self, food):
        pass
    
    def __str__(self):
        return f"FarmAnimal(id={self.id}, breed='{self.breed}', born_on={self.born_on}, weight={self.weight})"
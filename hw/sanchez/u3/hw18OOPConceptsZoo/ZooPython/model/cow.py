from datetime import datetime
import random
from model.farm_animal import FarmAnimal
from controller.i_meat_animal import IMeatAnimal
from model.cut import Cut

class Cow(FarmAnimal, IMeatAnimal):
    def __init__(self, id: int, breed: str, born_on: datetime, weight: float, is_producing_milk: bool):
        super().__init__(id, breed, born_on, weight)
        self.is_producing_milk = is_producing_milk
        self.milk_produced = 0.0
    
    def milk(self) -> float:
        if self.is_producing_milk:
            self.milk_produced = 10 + random.random() * 20
            return self.milk_produced
        return 0.0
    
    def cut(self):
        cuts = [
            Cut(1, "Sirloin", "Sirloin cut", 5.0),
            Cut(2, "Rib", "Rib cut", 3.5),
            Cut(3, "Brisket", "Brisket cut", 4.0)
        ]
        return cuts
    
    def send_to_slaughter_house(self, slaughter_house):
        print(f"Sending cow to slaughter house: {slaughter_house}")
    
    def food(self, food):
        print(f"Feeding cow with: {food.description}")
    
    def __str__(self):
        return f"Cow(id={self.id}, breed='{self.breed}', born_on={self.born_on}, weight={self.weight}, is_producing_milk={self.is_producing_milk}, milk_produced={self.milk_produced})"
from datetime import datetime
from model.farm_animal import FarmAnimal
from controller.i_meat_animal import IMeatAnimal
from model.cut import Cut

class Pig(FarmAnimal, IMeatAnimal):
    def __init__(self, id: int, breed: str, born_on: datetime, weight: float, ideal_weight: float):
        super().__init__(id, breed, born_on, weight)
        self.ideal_weight = ideal_weight
    
    def is_ready_for_slaughter(self) -> bool:
        return self.weight >= self.ideal_weight
    
    def cut(self):
        cuts = [
            Cut(1, "Loin", "Pork loin cut", 4.0),
            Cut(2, "Bacon", "Bacon cut", 3.0),
            Cut(3, "Ham", "Ham cut", 6.0)
        ]
        return cuts
    
    def send_to_slaughter_house(self, slaughter_house):
        print(f"Sending pig to slaughter house: {slaughter_house}")
    
    def food(self, food):
        print(f"Feeding pig with: {food.description}")
    
    def __str__(self):
        return f"Pig(id={self.id}, breed='{self.breed}', born_on={self.born_on}, weight={self.weight}, ideal_weight={self.ideal_weight})"
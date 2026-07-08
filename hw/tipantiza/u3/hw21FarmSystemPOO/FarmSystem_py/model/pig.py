from datetime import datetime
from typing import List, Optional
from model.farm_animal import FarmAnimal
from controller.i_meat_animal import IMeatAnimal
from model.cut import Cut
from model.food import Food
from model.product import Product
from model.slaughter_house import SlaughterHouse

class Pig(FarmAnimal, IMeatAnimal):
    def __init__(self, ideal_weight: float, reached_ideal_weight: bool, 
                 weight: float, breed: str, born_on: datetime, id: int,
                 slaughter_house: Optional[SlaughterHouse] = None,
                 product: Optional[Product] = None,
                 cuts: Optional[List[Cut]] = None):
        super().__init__(id, breed, born_on, weight, slaughter_house, product, cuts)
        self.ideal_weight = ideal_weight
        self.reached_ideal_weight = reached_ideal_weight
    
    def feed(self, food: Food):
        print(f"Feeding THE PIG with food --> {food} in a bowl and water")
        print(f"Feeding the PIG with {food.description}")
        new_weight = self.weight + 2.5
        self.weight = new_weight
        
        if new_weight >= self.ideal_weight:
            self.reached_ideal_weight = True
            print(f"Pig {self.id} has reached ideal weight: {new_weight:.2f} kg")
        else:
            print(f"Current weight: {new_weight:.2f} kg (Ideal: {self.ideal_weight:.2f} kg)")
    
    def cut(self) -> List[Cut]:
        return []
    
    def is_ready_for_slaughter(self) -> bool:
        return self.reached_ideal_weight
    
    def send_to_slaughter_house(self, slaughter_house: SlaughterHouse):
        if self.is_ready_for_slaughter():
            self.slaughter_house = slaughter_house
            print(f"PIG {self.id} SENT TO SLAUGHTERHOUSE")
            print(f"SlaughterHouse: {slaughter_house.name}")
            print(f"Address: {slaughter_house.address}")
            print(f"Weight: {self.weight:.2f} kg")
            self._show_pork_cuts()
        else:
            print(f"Pig {self.id} is NOT ready for slaughter yet")
            print(f"Current weight: {self.weight:.2f} kg")
            print(f"Ideal weight: {self.ideal_weight:.2f} kg")
    
    def _show_pork_cuts(self):
        print(f"\nCUTS PERFORMED ON PIG {self.id}:")
        print("Jamón (Piernas traseras)")
        print("Paleta (Pierna delantera)")
        print("Costillar")
        print("Lomo de cerdo")
        print("All cuts have been completed successfully")
    
    def get_ideal_weight(self) -> float:
        return self.ideal_weight
    
    def set_ideal_weight(self, ideal_weight: float):
        self.ideal_weight = ideal_weight
    
    def is_reached_ideal_weight(self) -> bool:
        return self.reached_ideal_weight
    
    def set_reached_ideal_weight(self, reached_ideal_weight: bool):
        self.reached_ideal_weight = reached_ideal_weight
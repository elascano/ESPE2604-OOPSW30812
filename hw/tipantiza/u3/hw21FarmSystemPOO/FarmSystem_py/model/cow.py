from datetime import datetime
from typing import List, Optional
from model.farm_animal import FarmAnimal
from controller.i_meat_animal import IMeatAnimal
from model.cut import Cut
from model.food import Food
from model.product import Product
from model.slaughter_house import SlaughterHouse

class Cow(FarmAnimal, IMeatAnimal):
    MIN_MILK_PRODUCTION = 5.0
    
    def __init__(self, id: int, can_produce_milk: bool, breed: str, born_on: datetime, 
                 weight: float, slaughter_house: Optional[SlaughterHouse] = None, 
                 product: Optional[Product] = None, cuts: Optional[List[Cut]] = None, 
                 milk_production: float = 0.0):
        super().__init__(id, breed, born_on, weight, slaughter_house, product, cuts)
        self.milk_production = milk_production
        self.can_produce_milk = milk_production >= Cow.MIN_MILK_PRODUCTION
    
    def feed(self, food: Food):
        print(f"Feeding the COW with {food.description}")
        if self.can_produce_milk:
            self.milk_production -= 0.3
            if self.milk_production < Cow.MIN_MILK_PRODUCTION:
                self.can_produce_milk = False
                print(f"Cow {self.id} can NO LONGER produce milk!")
                print(f"Current production: {self.milk_production:.2f} L/day")
                print(f"Minimum required: {Cow.MIN_MILK_PRODUCTION} L/day")
            else:
                print(f"Milk production: {self.milk_production:.2f} L/day")
    
    def cut(self) -> List[Cut]:
        raise NotImplementedError("Not supported yet.")
    
    def send_to_slaughter_house(self, slaughter_house: SlaughterHouse):
        if self.is_ready_for_slaughter():
            self.slaughter_house = slaughter_house
            print(f"COW {self.id} SENT TO SLAUGHTERHOUSE")
            print(f"SlaughterHouse: {slaughter_house.name}")
            print(f"Address: {slaughter_house.address}")
            print("Reason: No longer produces milk")
            print(f"Final milk production: {self.milk_production:.2f} L/day")
            print(f"Weight: {self.weight} kg")
            self._show_beef_cuts()
        else:
            print(f"Cow {self.id} is NOT ready for slaughter yet")
            print(f"Milk production: {self.milk_production:.2f} L/day")
            print(f"Can produce milk: {'YES' if self.can_produce_milk else 'NO'}")
    
    def _show_beef_cuts(self):
        print(f"\nCUTS PERFORMED ON COW {self.id}:")
        print("Lomo Fino")
        print("Picaña")
        print("Costilla de res")
        print("Pulpa negra (bistecs)")
        print("Pulpa blanca (bistecs)")
        print("All cuts have been completed successfully")
    
    def is_ready_for_slaughter(self) -> bool:
        return not self.can_produce_milk
    
    def get_milk_production(self) -> float:
        return self.milk_production
    
    def set_milk_production(self, milk_production: float):
        self.milk_production = milk_production
        self.can_produce_milk = milk_production >= Cow.MIN_MILK_PRODUCTION
    
    def is_can_produce_milk(self) -> bool:
        return self.can_produce_milk
    
    def set_can_produce_milk(self, can_produce_milk: bool):
        self.can_produce_milk = can_produce_milk
    
    @classmethod
    def get_min_milk_production(cls) -> float:
        return cls.MIN_MILK_PRODUCTION
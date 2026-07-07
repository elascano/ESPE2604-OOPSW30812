from abc import ABC, abstractmethod
from datetime import datetime
from typing import List, Optional
from model.cut import Cut
from model.food import Food
from model.product import Product
from model.slaughter_house import SlaughterHouse

class FarmAnimal(ABC):
    def __init__(self, id: int, breed: str, born_on: datetime, weight: float, 
                 slaughter_house: Optional[SlaughterHouse] = None, 
                 product: Optional[Product] = None, 
                 cuts: Optional[List[Cut]] = None):
        self.id = id
        self.breed = breed
        self.born_on = born_on
        self.weight = weight
        self.slaughter_house = slaughter_house
        self.product = product
        self.cuts = cuts if cuts is not None else []
    
    def get_age_in_months(self) -> int:
        if self.born_on is None:
            raise ValueError("born_on is not set")
        
        today = datetime.now()
        if self.born_on > today:
            raise ValueError("born_on can not be in the future")
        
        months = (today.year - self.born_on.year) * 12 + (today.month - self.born_on.month)
        return months
    
    @abstractmethod
    def feed(self, food: Food):
        pass
    
    def __str__(self):
        return f"FarmAnimal(id={self.id}, breed={self.breed}, born_on={self.born_on}, weight={self.weight}, slaughter_house={self.slaughter_house}, product={self.product}, cuts={self.cuts})"
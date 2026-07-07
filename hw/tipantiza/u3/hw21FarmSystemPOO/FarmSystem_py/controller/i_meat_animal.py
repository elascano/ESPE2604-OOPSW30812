from abc import ABC, abstractmethod
from typing import List
from model.cut import Cut
from model.slaughter_house import SlaughterHouse

class IMeatAnimal(ABC):
    @abstractmethod
    def cut(self) -> List[Cut]:
        pass
    
    @abstractmethod
    def send_to_slaughter_house(self, slaughter_house: SlaughterHouse):
        pass
    
    @abstractmethod
    def is_ready_for_slaughter(self) -> bool:
        pass
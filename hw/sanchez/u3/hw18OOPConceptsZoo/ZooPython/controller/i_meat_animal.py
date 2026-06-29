from abc import ABC, abstractmethod
from typing import List

class IMeatAnimal(ABC):
    @abstractmethod
    def cut(self) -> List:
        pass
    
    @abstractmethod
    def send_to_slaughter_house(self, slaughter_house):
        pass
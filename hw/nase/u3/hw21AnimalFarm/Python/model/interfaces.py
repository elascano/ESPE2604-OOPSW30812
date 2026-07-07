from abc import ABC, abstractmethod
from typing import List

class IMeatAnimal(ABC):
    @abstractmethod
    def cut(self) -> List['Cut']:
        pass

    @abstractmethod
    def send_to_slaughter_house(self, slaughter_house: 'SlaughterHouse') -> None:
        pass

class IProduceAnimal(ABC):
    @abstractmethod
    def procedure(self) -> str:
        pass

    @abstractmethod
    def measure_quantity(self, unit: str, quantity: float) -> None:
        pass
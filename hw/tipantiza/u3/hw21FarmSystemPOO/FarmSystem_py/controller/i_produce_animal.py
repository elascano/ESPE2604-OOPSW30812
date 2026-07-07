from abc import ABC, abstractmethod
from model.product import Product

class IProduceAnimal(ABC):
    @abstractmethod
    def produce(self) -> Product:
        pass
    
    @abstractmethod
    def measure_quantity(self, unit: str, quantity: float):
        pass
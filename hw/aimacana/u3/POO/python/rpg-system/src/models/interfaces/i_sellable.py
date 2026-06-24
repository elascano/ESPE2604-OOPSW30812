from abc import ABC, abstractmethod

class ISellable(ABC):
    @abstractmethod
    def calculate_sale_value(self) -> float:
        pass

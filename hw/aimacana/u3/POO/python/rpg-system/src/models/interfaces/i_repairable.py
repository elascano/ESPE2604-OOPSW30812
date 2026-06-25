from abc import ABC, abstractmethod

class IRepairable(ABC):
    @abstractmethod
    def repair(self, amount: float):
        pass

    @abstractmethod
    def get_durability(self) -> float:
        pass

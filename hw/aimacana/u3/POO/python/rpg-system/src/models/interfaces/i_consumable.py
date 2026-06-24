from abc import ABC, abstractmethod

class IConsumable(ABC):
    @abstractmethod
    def consume(self, target):
        pass

from abc import ABC, abstractmethod


class IProduceAnimal(ABC):

    @abstractmethod
    def produce(self):
        pass

    @abstractmethod
    def measure_quantity(self, unit, quantity):
        pass
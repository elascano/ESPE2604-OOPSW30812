from abc import ABC, abstractmethod

class IProduceAnimal(ABC):

    @abstractmethod
    def produce(self):
        pass
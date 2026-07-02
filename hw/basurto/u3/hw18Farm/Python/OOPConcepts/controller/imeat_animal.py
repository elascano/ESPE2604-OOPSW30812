from abc import ABC, abstractmethod

class IMeatAnimal(ABC):

    @abstractmethod
    def cut(self):
        pass
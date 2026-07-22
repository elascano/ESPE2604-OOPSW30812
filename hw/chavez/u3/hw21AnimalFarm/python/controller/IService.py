from abc import ABC, abstractmethod

class IService(ABC):

    @abstractmethod
    def feed(self, food):
        pass
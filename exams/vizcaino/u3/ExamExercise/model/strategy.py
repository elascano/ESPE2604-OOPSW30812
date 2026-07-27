from abc import ABC, abstractmethod

class SortStrategy(ABC):

    @abstractmethod
    def sort(self, data):
        pass

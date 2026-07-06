from abc import ABC, abstractmethod


class IMeatAnimal(ABC):
    @abstractmethod
    def cut(self):
        pass

    @abstractmethod
    def send_to_slaughter_house(self, slaughter_house):
        pass
# Author: Didier Elbay
# IMeatAnimal interface (abstract base class) - OOP Concepts Zoo Project

from abc import ABC, abstractmethod


class IMeatAnimal(ABC):

    @abstractmethod
    def cut(self):
        """Returns a list of Cut objects produced from this animal."""
        pass

    @abstractmethod
    def send_to_slaughter_house(self, slaughterhouse):
        """Sends the animal to the given SlaughterHouse."""
        pass

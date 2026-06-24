from abc import ABC, abstractmethod

class IEquippable(ABC):
    @abstractmethod
    def equip(self, target):
        pass

    @abstractmethod
    def unequip(self, target):
        pass

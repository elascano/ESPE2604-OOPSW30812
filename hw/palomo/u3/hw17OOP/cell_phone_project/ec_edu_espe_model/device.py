from abc import ABC, abstractmethod

class Device(ABC):

    def __init__(self, brand, model):
        self._brand = brand
        self._model = model

    @abstractmethod
    def turn_on(self):
        pass

    @abstractmethod
    def turn_off(self):
        pass

    @property
    def brand(self):
        return self._brand

    @property
    def model(self):
        return self._model
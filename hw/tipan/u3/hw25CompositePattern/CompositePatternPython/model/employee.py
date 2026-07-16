from abc import ABC, abstractmethod


class Employee(ABC):

    def __init__(self, name):
        self.name = name

    @abstractmethod
    def state_name(self):
        pass

    def __str__(self):
        return self.state_name()
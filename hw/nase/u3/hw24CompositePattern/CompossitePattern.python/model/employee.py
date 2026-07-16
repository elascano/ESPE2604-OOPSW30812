# Jennyfer Nase 

from abc import ABC, abstractmethod

class Employee(ABC):
    def __init__(self):
        self.name = "not assigned yet"
        self.title = "not assigned yet"

    def state_name(self):
        print(f"{self.title} {self.name}")
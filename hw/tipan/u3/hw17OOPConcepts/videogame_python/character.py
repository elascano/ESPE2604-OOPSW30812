from abc import ABC, abstractmethod

class Character(ABC):

    def __init__(self, id, name, level, health):
        self.id = id
        self.name = name
        self.level = level
        self.health = health
        self.inventory = []

    @abstractmethod
    def attack(self):
        pass

    def display_info(self):
        print(f"{self.name} Level: {self.level} Health: {self.health}")

    def add_item(self, item):
        self.inventory.append(item)
from abc import ABC


class Employee(ABC):

    def __init__(self):
        self.name = "Not assigned yet"
        self.title = "Not assigned yet"

    def stateName(self):
        print(f"{self.title} {self.name}")

    def add(self, employee):
        raise NotImplementedError("Leaf objects cannot add employees.")

    def remove(self, employee):
        raise NotImplementedError("Leaf objects cannot remove employees.")

    def getChild(self, index):
        raise NotImplementedError("Leaf objects do not have children.")
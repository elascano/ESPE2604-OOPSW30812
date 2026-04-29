from model.chicken import Chicken

class ChickenCoop:
    def __init__(self, id: int):
        self.id = id
        self.chickens = []  

    def add(self, chicken: Chicken):
        self.chickens.append(chicken)
        print(f"Gallina {chicken.name} agregada al gallinero {self.id}")

    def remove(self, chicken_id: int):
        self.chickens = [c for c in self.chickens if c.id != chicken_id]
        print(f"Gallina con ID {chicken_id} eliminada.")

    def __str__(self):
        return f"ChickenCoop{{id={self.id}, total_chickens={len(self.chickens)}}}"
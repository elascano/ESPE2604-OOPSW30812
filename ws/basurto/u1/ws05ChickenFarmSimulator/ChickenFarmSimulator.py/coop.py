// author Jennyfer Nase
class ChickenCoop:
    def __init__(self, id):
        self.id = id
        self.chickens = [] 

    def add_chicken(self, chicken):
        self.chickens.append(chicken)
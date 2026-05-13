from model.chicken import Chicken

class ChickenController:
    def __init__(self):
        self.chickens = []

    def create_chicken(self, id, name, color, age, is_molting):
        new_chicken = Chicken(id, name, color, age, is_molting)
        self.chickens.append(new_chicken)
        return new_chicken

    def get_all_chickens(self):
        return self.chickens
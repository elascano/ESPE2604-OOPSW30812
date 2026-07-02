# Author: Didier Elbay
# Food model - OOP Concepts Zoo Project


class Food:
    def __init__(self, id_food, description):
        self.id = id_food
        self.description = description

    def __str__(self):
        return f"Food({self.id}, {self.description})"

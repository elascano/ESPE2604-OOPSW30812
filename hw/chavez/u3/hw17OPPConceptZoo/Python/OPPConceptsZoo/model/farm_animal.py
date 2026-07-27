from datetime import date


class FarmAnimal:

    def __init__(self, id, breed, born_on, weight):
        self.id = id
        self.breed = breed
        self.born_on = born_on
        self.weight = weight

    def feed(self, food):
        print(f"{self.breed} is eating {food.description}")
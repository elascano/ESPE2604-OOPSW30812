
from model.farm_animal import FarmAnimal


class Chicken(FarmAnimal):

    def __init__(self, id, breed, born_on, weight):
        super().__init__(id, breed, born_on, weight)

    def lay_eggs(self):
        return 7
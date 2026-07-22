from model.farm_animal import FarmAnimal


class Sheep(FarmAnimal):

    def __init__(self, id, breed, born_on, weight):
        super().__init__(id, breed, born_on, weight)

    def shear(self):
        return "Wool"
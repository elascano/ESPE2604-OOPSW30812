from model.farm_animal import FarmAnimal


class Cow(FarmAnimal):

    def __init__(self, id, breed, born_on, weight):
        super().__init__(id, breed, born_on, weight)

    def produce_milk(self):
        return 20
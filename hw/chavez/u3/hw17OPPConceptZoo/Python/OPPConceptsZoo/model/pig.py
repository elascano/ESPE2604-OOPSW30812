from model.farm_animal import FarmAnimal


class Pig(FarmAnimal):

    def __init__(self, id, breed, born_on, weight):
        super().__init__(id, breed, born_on, weight)

    def cut(self):
        return ["Ham", "Bacon", "Loin"]
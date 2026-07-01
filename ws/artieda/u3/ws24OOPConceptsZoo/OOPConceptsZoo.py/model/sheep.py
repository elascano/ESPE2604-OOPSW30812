from model.farm_animal import FarmAnimal

class Sheep(FarmAnimal):
    def __init__(self, id_animal, breed, born_on, weight, last_sheering):
        super().__init__(id_animal, breed, born_on, weight)
        self.last_sheering = last_sheering
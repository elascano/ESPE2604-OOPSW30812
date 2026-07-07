from model.FarmAnimal import FarmAnimal
from controller.IMeatAnimal import IMeatAnimal


class Pig(FarmAnimal, IMeatAnimal):

    def __init__(self, ideal_weight, id, breed, born_on,
                 weight, slaughter_house, product, cuts):

        super().__init__(id, breed, born_on, weight,
                         slaughter_house, product, cuts)

        self.ideal_weight = ideal_weight

    def feed(self, food):
        print(f"Feeding THE PIG with food --> {food} in a bowl and water")

    def cut(self):
        return []

    def send_to_slaughter_house(self, slaughter_house):
        self.slaughter_house = slaughter_house

    def is_ready_for_slaughter(self):
        return self.weight >= self.ideal_weight
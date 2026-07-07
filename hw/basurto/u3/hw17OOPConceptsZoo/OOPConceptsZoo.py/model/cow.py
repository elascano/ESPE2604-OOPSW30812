from model.farm_animal import FarmAnimal
from controller.i_meat_animal import IMeatAnimal
from model.cut import Cut

class Cow(FarmAnimal, IMeatAnimal):
    def __init__(self, id_animal, breed, born_on, weight, is_producing_milk, milk_amount):
        super().__init__(id_animal, breed, born_on, weight)
        self.is_producing_milk = is_producing_milk
        self.milk_amount = milk_amount

    def milk(self):
        return self.milk_amount

    def cut(self):
        cuts = [
            Cut(10, "T-Bone", "Rib Section", 5.5),
            Cut(11, "Ribeye", "Loin Section", 3.8)
        ]
        return cuts

    def send_to_slaughter_house(self, slaughterhouse):
        print(f"Cow {self.id} sent to {slaughterhouse.description}")
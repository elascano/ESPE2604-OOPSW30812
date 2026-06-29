from model.farm_animal import FarmAnimal
from controller.i_meat_animal import IMeatAnimal
from model.cut import Cut

class Pig(FarmAnimal, IMeatAnimal):
    def __init__(self, id_animal, breed, born_on, weight, ideal_weight):
        super().__init__(id_animal, breed, born_on, weight)
        self.ideal_weight = ideal_weight

    def send_to_butcher(self):
        print(f"Pig {self.id} sent to butcher.")

    def cut(self):
        cuts = [
            Cut(1, "Pork Chop", "Standard Cut", 2.5),
            Cut(2, "Ribs", "Rib Extraction", 4.0)
        ]
        return cuts

    def send_to_slaughter_house(self, slaughterhouse):
        print(f"Pig {self.id} sent to {slaughterhouse.description}")
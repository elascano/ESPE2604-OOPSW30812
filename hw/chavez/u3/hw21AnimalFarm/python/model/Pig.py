from model.FarmAnimal import FarmAnimal
from model.Cut import Cut
from model.SlaughterHouse import SlaughterHouse

class Pig(FarmAnimal):

    def cut(self):
        print("Pig has been cut")

        cuts = [
            Cut("Loin"),
            Cut("Belly"),
            Cut("Feet")
        ]

        for cut in cuts:
            print(cut)

    def send_to_slaughter_house(self, name):
        slaughter_house = SlaughterHouse(name)
        slaughter_house.slaughter(self)
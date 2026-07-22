from model.FarmAnimal import FarmAnimal
from model.Cut import Cut
from model.SlaughterHouse import SlaughterHouse

class Cow(FarmAnimal):

    def cut(self):
        print("Cow has been cut")

        cuts = [
            Cut("Brisket"),
            Cut("Rib"),
            Cut("Loin"),
            Cut("Chuck")
        ]

        for cut in cuts:
            print(cut)

    def send_to_slaughter_house(self, name):
        slaughter_house = SlaughterHouse(name)
        slaughter_house.slaughter(self)
from .farm_animal import FarmAnimal
from .cut import Cut

class Pig(FarmAnimal):
    def __init__(self, ideal_weight, id, breed, born_on, weight, slaughter_house, product, cuts):
        super().__init__(id, breed, born_on, weight, slaughter_house, product, cuts)
        self._ideal_weight = ideal_weight

    def feed(self, food):
        self.set_weight(self.get_weight() + 0.8)

    def cut(self):
        cuts = []
        cuts.append(Cut(1, "Pork Chop", "Cut from the loin", 2.0))
        cuts.append(Cut(2, "Bacon", "Cut from the belly", 3.0))
        cuts.append(Cut(3, "Ham", "Cut from the hind leg", 4.0))
        cuts.append(Cut(4, "Shoulder", "Cut from the front leg", 4.5))
        self.set_cuts(cuts)
        return cuts

    def send_to_slaughter_house(self, slaughter_house):
        self._slaughter_house = slaughter_house

    def get_ideal_weight(self): return self._ideal_weight
    def set_ideal_weight(self, ideal_weight): self._ideal_weight = ideal_weight
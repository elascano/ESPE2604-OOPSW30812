from .farm_animal import FarmAnimal
from .product import Product
from .cut import Cut
from datetime import datetime

class Sheep(FarmAnimal):
    def __init__(self, last_sheering, kg_of_wool, id, breed, born_on, weight, slaughter_house, product, cuts):
        super().__init__(id, breed, born_on, weight, slaughter_house, product, cuts)
        self._last_sheering = last_sheering
        self._kg_of_wool = kg_of_wool

    def shear(self):
        self._last_sheering = datetime.now()
        return self._kg_of_wool

    def feed(self, food):
        self.set_weight(self.get_weight() + 0.3)

    def cut(self):
        cuts = []
        cuts.append(Cut(1, "Rack", "Cut from the rib", 1.5))
        cuts.append(Cut(2, "Leg", "Cut from the hind leg", 2.0))
        cuts.append(Cut(3, "Shoulder", "Cut from the front leg", 1.8))
        cuts.append(Cut(4, "Chop", "Cut from the loin", 1.2))
        self.set_cuts(cuts)
        return cuts

    def send_to_slaughter_house(self, slaughter_house):
        self._slaughter_house = slaughter_house

    def produce(self):
        wool = Product(301, "Sheep Wool", "Kilograms", self._kg_of_wool)
        self.set_product(wool)
        return wool

    def measure_quantity(self, unit, quantity):
        if self.get_product() is not None:
            self.get_product().set_unit(unit)
            self.get_product().set_quantity(quantity)

    def get_last_sheering(self): return self._last_sheering
    def set_last_sheering(self, last_sheering): self._last_sheering = last_sheering
    def get_kg_of_wool(self): return self._kg_of_wool
    def set_kg_of_wool(self, kg_of_wool): self._kg_of_wool = kg_of_wool
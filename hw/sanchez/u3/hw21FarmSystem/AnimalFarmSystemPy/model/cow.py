from .farm_animal import FarmAnimal
from .product import Product
from .cut import Cut

class Cow(FarmAnimal):
    def __init__(self, producing_milk, id, breed, born_on, weight, slaughter_house, product, cuts):
        super().__init__(id, breed, born_on, weight, slaughter_house, product, cuts)
        self._producing_milk = producing_milk

    def milk(self):
        if self._producing_milk:
            return 15.5
        return 0

    def is_producing_milk(self):
        return self._producing_milk

    def feed(self, food):
        self.set_weight(self.get_weight() + 0.5)

    def cut(self):
        cuts = []
        cuts.append(Cut(1, "T-Bone Steak", "Cut from the short loin", 2.5))
        cuts.append(Cut(2, "Ribeye", "Cut from the rib section", 3.0))
        cuts.append(Cut(3, "Sirloin", "Cut from the rear back", 4.0))
        cuts.append(Cut(4, "Round", "Cut from the hind leg", 5.0))
        self.set_cuts(cuts)
        return cuts

    def send_to_slaughter_house(self, slaughter_house):
        self._slaughter_house = slaughter_house

    def produce(self):
        if self._producing_milk:
            milk = Product(101, "Cow Milk", "Liters", self.milk())
            self.set_product(milk)
            return milk
        return None

    def measure_quantity(self, unit, quantity):
        if self.get_product() is not None:
            self.get_product().set_unit(unit)
            self.get_product().set_quantity(quantity)

    def set_producing_milk(self, producing_milk):
        self._producing_milk = producing_milk
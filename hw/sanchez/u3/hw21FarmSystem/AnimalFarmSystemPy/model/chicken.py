from .farm_animal import FarmAnimal
from .product import Product
from .cut import Cut

class Chicken(FarmAnimal):
    def __init__(self, is_molting, number_of_eggs_per_week, id, breed, born_on, weight, slaughter_house, product, cuts):
        super().__init__(id, breed, born_on, weight, slaughter_house, product, cuts)
        self._is_molting = is_molting
        self._number_of_eggs_per_week = number_of_eggs_per_week

    def lay_an_egg(self):
        if not self._is_molting:
            self._number_of_eggs_per_week += 1
            return True
        return False

    def feed(self, food):
        self.set_weight(self.get_weight() + 0.1)

    def cut(self):
        cuts = []
        cuts.append(Cut(1, "Breast", "Cut from the chest", 0.5))
        cuts.append(Cut(2, "Thigh", "Cut from the leg", 0.3))
        cuts.append(Cut(3, "Wing", "Cut from the wing", 0.2))
        cuts.append(Cut(4, "Drumstick", "Cut from the lower leg", 0.25))
        self.set_cuts(cuts)
        return cuts

    def send_to_slaughter_house(self, slaughter_house):
        self._slaughter_house = slaughter_house

    def produce(self):
        eggs = Product(201, "Chicken Eggs", "Units", self._number_of_eggs_per_week)
        self.set_product(eggs)
        return eggs

    def measure_quantity(self, unit, quantity):
        if self.get_product() is not None:
            self.get_product().set_unit(unit)
            self.get_product().set_quantity(quantity)

    def is_is_molting(self): return self._is_molting
    def set_is_molting(self, is_molting): self._is_molting = is_molting
    def get_number_of_eggs_per_week(self): return self._number_of_eggs_per_week
    def set_number_of_eggs_per_week(self, number_of_eggs_per_week): self._number_of_eggs_per_week = number_of_eggs_per_week
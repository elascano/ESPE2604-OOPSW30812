from model.FarmAnimal import FarmAnimal
from controller.IProduceAnimal import IProduceAnimal


class Cow(FarmAnimal, IProduceAnimal):

    def __init__(self, production_in_liters,
                 quality,
                 id,
                 breed,
                 born_on,
                 weight,
                 slaughter_house,
                 product,
                 cuts):

        super().__init__(id, breed, born_on,
                         weight, slaughter_house,
                         product, cuts)

        self.production_in_liters = production_in_liters
        self.quality = quality

    def feed(self, food):
        print(f"Feeding the cow with {food} and grass")

    def produce(self):
        return self.product

    def measure_quantity(self, unit, quantity):
        print(f"Production: {quantity} {unit}")
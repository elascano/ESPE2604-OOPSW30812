from model.farm_animal import FarmAnimal
from controller.meat_animal import IMeatAnimal
from controller.produce_animal import IProduceAnimal
from model.cut import Cut
from model.product import Product


class Cow(FarmAnimal, IMeatAnimal, IProduceAnimal):
    def __init__(
        self,
        producing_milk,
        carcass_yield,
        id,
        breed,
        born_on,
        weight,
        slaughter_house,
        product,
        cuts,
    ):
        super().__init__(
            id,
            breed,
            born_on,
            weight,
            slaughter_house,
            product,
            cuts,
        )

        self.producing_milk = producing_milk
        self.carcass_yield = carcass_yield

    def milk(self):
        return 15.5 if self.producing_milk else 0.0

    def calculate_meat_yield(self):
        return (self.weight * self.carcass_yield) / 100

    def cut(self):
        estimated_cut_weight = self.calculate_meat_yield() / 4

        self.cuts = [
            Cut(
                1,
                "Tenderloin",
                "Tender cut from the upper spine",
                estimated_cut_weight,
            ),
            Cut(
                2,
                "Ribeye",
                "Marbled rib section cut",
                estimated_cut_weight,
            ),
            Cut(
                3,
                "Ribs",
                "Bony section from the chest",
                estimated_cut_weight,
            ),
            Cut(
                4,
                "Flank Steak",
                "Transverse cut from the abdominal muscles",
                estimated_cut_weight,
            ),
        ]

        return self.cuts

    def send_to_slaughter_house(self, slaughter_house):
        self.slaughter_house = slaughter_house

    def produce(self):
        if self.producing_milk:
            if self.product is None:
                self.product = Product(
                    101,
                    "Whole Milk",
                    "Liters",
                    0.0,
                )

            return self.product

        return None

    def measure_quantity(self, unit, quantity):
        current_product = self.produce()

        if current_product:
            current_product.unit = unit
            current_product.quantity = quantity

    def feed(self, food):
        raise NotImplementedError()
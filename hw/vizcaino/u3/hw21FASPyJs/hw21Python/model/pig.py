from model.farm_animal import FarmAnimal
from controller.meat_animal import IMeatAnimal
from model.cut import Cut


class Pig(FarmAnimal, IMeatAnimal):
    def __init__(
        self,
        ideal_weight,
        premium_cuts_percentage,
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

        self.ideal_weight = ideal_weight
        self.premium_cuts_percentage = premium_cuts_percentage

    def is_ready_for_slaughter(self):
        return self.weight >= self.ideal_weight

    def calculate_premium_cuts(self):
        return (
            self.weight * self.premium_cuts_percentage
        ) / 100

    def send_to_slaughter_house(self, slaughter_house):
        self.slaughter_house = slaughter_house

    def feed(self, food):
        raise NotImplementedError()

    def cut(self):
        estimated_cut_weight = self.weight / 4

        self.cuts = [
            Cut(
                1,
                "Pork Loin",
                "Back section, lean meat cut",
                estimated_cut_weight,
            ),
            Cut(
                2,
                "Spare Ribs",
                "Lower rib cage section",
                estimated_cut_weight,
            ),
            Cut(
                3,
                "Pork Belly",
                "Fatty boneless cut from the abdomen",
                estimated_cut_weight,
            ),
            Cut(
                4,
                "Boston Butt",
                "Upper shoulder section cut",
                estimated_cut_weight,
            ),
        ]

        return self.cuts
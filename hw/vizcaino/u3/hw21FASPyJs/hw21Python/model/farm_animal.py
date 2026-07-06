from abc import ABC, abstractmethod
from datetime import date


class FarmAnimal(ABC):
    def __init__(
        self,
        id,
        breed,
        born_on,
        weight,
        slaughter_house,
        product,
        cuts,
    ):
        self.id = id
        self.breed = breed
        self.born_on = born_on
        self.weight = weight
        self.slaughter_house = slaughter_house
        self.product = product
        self.cuts = cuts

    def get_age_in_months(self):
        if self.born_on is None:
            raise ValueError("born_on is not set")

        today = date.today()

        if self.born_on > today:
            raise ValueError("born_on cannot be in the future")

        return (
            (today.year - self.born_on.year) * 12
            + today.month
            - self.born_on.month
        )

    @abstractmethod
    def feed(self, food):
        pass

    def __str__(self):
        return (
            f"FarmAnimal(id={self.id}, breed={self.breed}, "
            f"born_on={self.born_on}, weight={self.weight})"
        )
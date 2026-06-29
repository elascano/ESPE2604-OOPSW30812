from model.farm_animal import FarmAnimal


class Chicken(FarmAnimal):
    def __init__(self, id, breed, born_on, weight, health_status,
                 is_molting, number_of_eggs_per_week, egg_color):
        super().__init__(id, breed, born_on, weight, health_status)
        self.is_molting = is_molting
        self.number_of_eggs_per_week = number_of_eggs_per_week
        self.egg_color = egg_color

    def lay_an_egg(self):
        self.history.append("Egg laid")
        return f"Egg color: {self.egg_color}"

    def to_dict(self):
        return self.__dict__
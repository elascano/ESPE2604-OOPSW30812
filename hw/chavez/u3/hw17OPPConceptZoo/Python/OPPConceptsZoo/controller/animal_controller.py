from model.cow import Cow
from model.pig import Pig
from model.sheep import Sheep
from model.chicken import Chicken


class AnimalController:

    def create_animal(self, animal_type, id, breed, born_on, weight):

        if animal_type == "Cow":
            return Cow(id, breed, born_on, weight)

        elif animal_type == "Pig":
            return Pig(id, breed, born_on, weight)

        elif animal_type == "Sheep":
            return Sheep(id, breed, born_on, weight)

        elif animal_type == "Chicken":
            return Chicken(id, breed, born_on, weight)

        return None
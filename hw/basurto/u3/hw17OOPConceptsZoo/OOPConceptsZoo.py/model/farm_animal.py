from model.food import Food

class FarmAnimal:
    def __init__(self, id_animal, breed, born_on, weight):
        self.id = id_animal
        self.breed = breed
        self.born_on = born_on
        self.weight = weight

    def get_age_in_months(self):
        return 1

    def feed(self, food):
        print(f"Animal {self.id} is eating {food.description}")
        #@uthor Christopher Lomas
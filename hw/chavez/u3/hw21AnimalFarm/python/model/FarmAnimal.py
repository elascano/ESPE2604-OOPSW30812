class FarmAnimal:

    def __init__(self, id, breed, born_on):
        self.id = id
        self.breed = breed
        self.born_on = born_on

    def feed(self, food):
        print(f"Feeding the {self.__class__.__name__.upper()} with food -> {food.name} in a bowl and water")
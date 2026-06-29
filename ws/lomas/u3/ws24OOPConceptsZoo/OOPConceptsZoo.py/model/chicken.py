from model.farm_animal import FarmAnimal

class Chicken(FarmAnimal):
    def __init__(self, id_animal, breed, born_on, weight, is_molting, number_of_eggs_per_week):
        super().__init__(id_animal, breed, born_on, weight)
        self.is_molting = is_molting
        self.number_of_eggs_per_week = number_of_eggs_per_week

    def lay_an_egg(self):
        print(f"Chicken {self.id} laid an egg.")

    def operation(self):
        print("Chicken operation executed.")
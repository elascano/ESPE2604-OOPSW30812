from model.farm_animal import FarmAnimal

from controller.i_produce_animal import IProduceAnimal

class Chicken(FarmAnimal, IProduceAnimal):

    def __init__(self, id, breed, born_on_date, weight, slaughter_house, product, cuts, is_molting, number_of_eggs_per_week):
        super().__init__(id, breed, born_on_date, weight, slaughter_house, product, cuts)
        self.is_molting = is_molting
        self.number_of_eggs_per_week = number_of_eggs_per_week

    def feed(self, food):
        print(f"Feeding the CHICKEN with food --> {food}")
        

    def lay_an_egg(self):
        if(self.is_molting):
            print("The chicken is molting, it cannot lay an egg")

        else:
            self.number_of_eggs_per_week += 1
            print("The chicken has laid an egg")

    def produce(self, product_id):
        self.product.id = product_id
        self.product.description = "Eggs"
        self.product.unit = ""
        self.product.quantity = self.number_of_eggs_per_week

        print(f"The chicken produce {self.product.quantity} eggs" )

        return self.product
    
    def measure_quantity(self, unit, quantity):
        if(self.is_molting):
            print("The chicken is molting, it cannot produce eggs")

        else:
            self.product.unit = unit
            self.product.quantity = quantity

            self.number_of_eggs_per_week += quantity

            print(f"Measure: {quantity} + of eggs")
    
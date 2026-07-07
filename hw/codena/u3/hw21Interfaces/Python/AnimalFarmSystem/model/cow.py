from model.farm_animal import FarmAnimal
from model.cut import Cut

from controller.i_meat_animal import IMeatAnimal
from controller.i_produce_animal import IProduceAnimal

class Cow(FarmAnimal, IMeatAnimal, IProduceAnimal):

    def __init__(self, id, breed, born_on_date, weight, slaughter_house, product, cuts, is_producing_milk, quantity_of_milk):
        super.__init__(id, breed, born_on_date, weight, slaughter_house, product, cuts)
        self.is_producing_milk = is_producing_milk
        self.quantity_of_milk = quantity_of_milk

    def feed(self, food):
        print(f"Feeding the COW with food --> {food} and water")

    def cut(self):

        cuts = []

        if self.slaughter_house.name is None:
            print("First send the Cow to slaughterHouse")

        else:

            cuts.append(Cut(1, "Brisket", "Cow", 13.5))
            cuts.append(Cut(2, "Rib", "Cow", 34))
            cuts.append(Cut(3, "Loin", "Cow", 58))
            cuts.append(Cut(4, "Chuck", "Cow", 88))

            print("Cow has been cut")

            for cut in cuts:
                print(cut.description)

        return cuts
    
    def send_to_slaughter_house(self, slaughter_house):
        if(self.is_producing_milk):
            print("The cow is producing milk, it cannot be sent to slaughter house")

        else:
            self.slaughter_house = slaughter_house
            print(f"The cow has been sent to slaughter house {slaughter_house.name}")
    
    def measure_quantity(self, unit, quantity):
        if self.is_producing_milk:
            self.product.unit = unit
            self.product.quantity = quantity
            self.quantity_of_milk += quantity

            print(f"Meaure: {quantity} {unit} of milk")

        else:
            print("The cow is not producing milk")

    def milk(self):
        milk_produced = self.weight / 100
        return milk_produced

    def produce(self, product_id):
        if(self.is_producing_milk):
            self.product.id = product_id
            self.product.description = "milk"
            self.product.unit = "L"
            self.product.quantity = self.milk

            print(f"The cow produce {self.product.quantity} L of milk" )

        else:
            print("The cow cannot produce milk")

        return self.product



     
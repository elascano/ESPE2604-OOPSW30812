from model.farm_animal import FarmAnimal

from controller.i_produce_animal import IProduceAnimal

class Sheep(FarmAnimal, IProduceAnimal):
    
    def __init__(self, id, breed, born_on_date, weight, slaughter_house, product, cuts, last_shearing, quantity_of_wool):
        super().__init__(id, breed, born_on_date, weight, slaughter_house, product, cuts)
        self.last_shearing = last_shearing
        self.quantity_of_wool = quantity_of_wool

    def feed(self, food):
        print(f"Feeding the SHEEP with food --> {food} and water")

    def shear(self):
        wool_produced = self.weight/150
        return wool_produced
    
    def produce(self, product_id):
        self.product.id = product_id
        self.product.description = "Wool"
        self.product.unit = "Kg"
        self.product.quantity = self.shear

        print(f"The sheep produce {self.product.quantity} kg of wool" )

        return self.product
    
    def measure_quantity(self, unit, quantity):
        self.product.unit = unit
        self.product.quantity = quantity

        self.quantity_of_wool += quantity

        print(f"Measure: {quantity} {unit} of wool")
    
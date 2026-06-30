from model.farm_animal import FarmAnimal
from controller.imeat_animal import IMeatAnimal
from model.cut import Cut


class Cow(FarmAnimal, IMeatAnimal):

    def __init__(self,id,breed,born_on_date, weight, is_producing_milk):

        super().__init__(id,breed,born_on_date,weight)
        self.is_producing_milk = is_producing_milk
    
    def to_document(self):

        document = {
            "_id": self.id,
            "type": "Cow",
            "breed": self.breed,
            "bornOnDate": self.born_on_date,
            "weight": self.weight,
            "isProducingMilk": self.is_producing_milk
        }

        return document
    
    def cut(self):

        cuts = []

        cuts.append(Cut(self.id, "Rib", "Cow", 25.0))
        cuts.append(Cut(self.id, "Loin", "Cow", 18.5))
        cuts.append(Cut(self.id, "Brisket", "Cow", 20.0))

        return cuts
    
    def milk(self):

        if self.is_producing_milk:
            quantity_of_milk = self.weight / 100
        else:
            quantity_of_milk = 0

        return quantity_of_milk
    
    def feed(self, food):

        type_of_food = food.type_of_food

        can_feed = (type_of_food == "Grass" or type_of_food == "Hay")

        if can_feed:
            self.weight += 1

        return can_feed
from model.farm_animal import FarmAnimal
from controller.imeat_animal import IMeatAnimal
from model.cut import Cut


class Pig(FarmAnimal):

    def __init__(self,id,breed,born_on_date, weight,ideal_weight):

        super().__init__(id,breed,born_on_date,weight)
        self.ideal_weight = ideal_weight

    
    def to_document(self):

        document = {
            "_id": self.id,
            "type": "Pig",
            "breed": self.breed,
            "bornOnDate": self.born_on_date,
            "weight": self.weight,
            "idealWeight": self.ideal_weight
        }

        return document
    
    def send_to_butcher(self):

        return self.weight >= self.ideal_weight
    
    def cut(self):

        cuts = []

        if not self.send_to_butcher():
            return cuts

        cuts.append(Cut(self.id, "Ham", "Pig", 12.0))
        cuts.append(Cut(self.id, "Bacon", "Pig", 8.0))
        cuts.append(Cut(self.id, "Ribs", "Pig", 6.5))

        return cuts
    
    def feed(self, food):

        type_of_food = food.type_of_food

        can_feed = (type_of_food == "Corn" or type_of_food == "Mixed Feed")

        if can_feed:
            self.weight += 1

        return can_feed
    
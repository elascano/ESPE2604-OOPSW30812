from model.farm_animal import FarmAnimal


class Sheep(FarmAnimal):

    def __init__(self,id,breed,born_on_date, weight, last_shearing):

        super().__init__(id,breed,born_on_date,weight)
        self.last_shearing = last_shearing

    
    def to_document(self):

        document = {
            "_id": self.id,
            "type": "Sheep",
            "breed": self.breed,
            "bornOnDate": self.born_on_date,
            "weight": self.weight,
            "lastShearing": self.last_shearing
        }

        return document
    
    def feed(self, food):

        type_of_food = food.type_of_food

        can_feed = (type_of_food == "Grass" or type_of_food == "Hay")

        if can_feed:
            self.weight += 1

        return can_feed
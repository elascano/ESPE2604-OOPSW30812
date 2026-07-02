from model.farm_animal import FarmAnimal


class Chicken(FarmAnimal):

    def __init__(self,id,breed,born_on_date, weight, is_molting, number_of_eggs):

        super().__init__(id,breed,born_on_date,weight)
        self.is_molting = is_molting
        self.number_of_eggs = number_of_eggs
    
    def to_document(self):

        document = {
            "_id": self.id,
            "type": "Chicken",
            "breed": self.breed,
            "bornOnDate": self.born_on_date,
            "weight": self.weight,
            "isMolting": self.is_molting,
            "numberOfEggs": self.number_of_eggs
        }

        return document
    
    def lay_an_egg(self):

        if not self.is_molting:
            self.number_of_eggs += 1

        return self.is_molting
    
    def feed(self, food):

        type_of_food = food.type_of_food

        can_feed = (type_of_food == "Corn" or type_of_food == "Mixed Feed")

        if can_feed:
            self.weight += 1

        return can_feed
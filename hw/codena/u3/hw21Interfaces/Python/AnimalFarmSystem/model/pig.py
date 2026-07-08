from model.farm_animal import FarmAnimal
from model.cut import Cut

from controller.i_meat_animal import IMeatAnimal

class Pig(FarmAnimal, IMeatAnimal):

    def __init__(self, id, breed, born_on_date, weight, slaughter_house, product, cuts, ideal_weight):
        super.__init__(id, breed, born_on_date, weight, slaughter_house, product, cuts)
        self.ideal_weight = ideal_weight

    def feed(self, food):
        print(f"Feeding the PIG with food --> {food} in a bowl and water")

    def cut(self):

        cuts = []

        if self.slaughter_house.name is None:
            print("First send the Pig to slaughterHouse")

        else:

            cuts.append(Cut(1, "Ham", "Pig", 20))
            cuts.append(Cut(2, "Loin", "Pig", 16))
            cuts.append(Cut(3, "Belly", "Pig", 16.5))
            cuts.append(Cut(4, "Feet", "Pig", 5))

            print("Pig has been cut")

            for cut in cuts:
                print(cut.description)

        return cuts
    
    def send_to_slaughter_house(self, slaughter_house):
        if(self.weight >= self.ideal_weight):
            self.slaughter_house = slaughter_house
            print(f"Pig has been sent to SlaughterHouse {slaughter_house.name}")
        else:
            print("Pig has not reached the ideal weight, it was not sent to slaughterhouse")

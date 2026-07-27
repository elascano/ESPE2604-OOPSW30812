from model.Food import Food
from model.Pig import Pig
from model.Cow import Cow
from model.Chicken import Chicken
from model.Sheep import Sheep


class AnimalController:

    @staticmethod
    def run():

        food = Food("Corn")

        print("\n----- PIG -----")
        pig = Pig(1, "Yorkshire", "2025-01-15")
        pig.feed(food)
        pig.send_to_slaughter_house("Don Pepe")
        pig.cut()

        print("\n----- COW -----")
        cow = Cow(2, "Holstein", "2024-05-20")
        cow.feed(food)
        cow.send_to_slaughter_house("Don Pepe")
        cow.cut()

        print("\n----- CHICKEN -----")
        chicken = Chicken(3, "Leghorn", "2025-02-10")
        chicken.feed(food)
        chicken.produce()

        print("\n----- SHEEP -----")
        sheep = Sheep(4, "Merino", "2024-09-18")
        sheep.feed(food)
        sheep.produce()
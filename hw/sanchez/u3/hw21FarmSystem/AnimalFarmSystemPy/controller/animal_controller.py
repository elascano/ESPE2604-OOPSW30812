from model import Cow, Pig, Chicken, Sheep, SlaughterHouse, Food

class AnimalController:
    def __init__(self):
        self._slaughter_house = SlaughterHouse(1, "Central Slaughterhouse", "123 Main St", "555-1234")
        self._animals = []
        self._foods = [
            Food(1, "Grass"),
            Food(2, "Grain"),
            Food(3, "Mixed Feed")
        ]
        self._initialize_animals()

    def _initialize_animals(self):
        cow1 = Cow(True, 1, "Holstein", None, 450.0, None, None, None)
        cow2 = Cow(False, 2, "Angus", None, 520.0, self._slaughter_house, None, None)
        pig1 = Pig(120.0, 3, "Duroc", None, 80.0, self._slaughter_house, None, None)
        pig2 = Pig(110.0, 4, "Berkshire", None, 95.0, self._slaughter_house, None, None)
        chicken = Chicken(False, 7, 5, "Leghorn", None, 2.5, self._slaughter_house, None, None)
        sheep = Sheep(None, 3.5, 6, "Merino", None, 70.0, self._slaughter_house, None, None)

        self._animals = [cow1, cow2, pig1, pig2, chicken, sheep]

    def get_all_animals(self):
        return self._animals

    def get_animal_by_id(self, id):
        for animal in self._animals:
            if animal.get_id() == id:
                return animal
        return None

    def get_cows(self):
        return [a for a in self._animals if isinstance(a, Cow)]

    def get_pigs(self):
        return [a for a in self._animals if isinstance(a, Pig)]

    def get_chickens(self):
        return [a for a in self._animals if isinstance(a, Chicken)]

    def get_sheep(self):
        return [a for a in self._animals if isinstance(a, Sheep)]

    def feed_animal(self, animal_id, food_id):
        animal = self.get_animal_by_id(animal_id)
        food = None
        for f in self._foods:
            if f.get_id() == food_id:
                food = f
                break
        if animal and food:
            animal.feed(food)
            return True
        return False

    def produce_product(self, animal_id):
        animal = self.get_animal_by_id(animal_id)
        if animal and hasattr(animal, 'produce'):
            return animal.produce()
        return None

    def get_cuts(self, animal_id):
        animal = self.get_animal_by_id(animal_id)
        if animal and hasattr(animal, 'cut'):
            return animal.cut()
        return None

    def send_to_slaughter_house(self, animal_id):
        animal = self.get_animal_by_id(animal_id)
        if animal and hasattr(animal, 'send_to_slaughter_house'):
            animal.send_to_slaughter_house(self._slaughter_house)
            return True
        return False

    def lay_egg(self, animal_id):
        animal = self.get_animal_by_id(animal_id)
        if isinstance(animal, Chicken) and hasattr(animal, 'lay_an_egg'):
            return animal.lay_an_egg()
        return False

    def shear_sheep(self, animal_id):
        animal = self.get_animal_by_id(animal_id)
        if isinstance(animal, Sheep) and hasattr(animal, 'shear'):
            return animal.shear()
        return None

    def get_slaughter_house(self):
        return self._slaughter_house

    def get_foods(self):
        return self._foods
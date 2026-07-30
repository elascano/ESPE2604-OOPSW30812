from abc import ABC, abstractmethod


class Cut:
    def __init__(self, id, description, procedure, weight):
        self.id = id
        self.description = description
        self.procedure = procedure
        self.weight = weight

    def get_id(self):
        return self.id

    def get_description(self):
        return self.description

    def get_procedure(self):
        return self.procedure

    def get_weight(self):
        return self.weight


class Food:
    def __init__(self, id, description):
        self.id = id
        self.description = description

    def get_id(self):
        return self.id

    def get_description(self):
        return self.description


class SlaughterHouse:
    def __init__(self, description):
        self.description = description

    def get_description(self):
        return self.description


class IMeatAnimal(ABC):
    @abstractmethod
    def cut(self):
        pass

    @abstractmethod
    def send_to_slaughter_house(self, slaughter_house):
        pass


class FarmAnimal(ABC):
    def __init__(self, id, breed, born_on, weight):
        self.id = id
        self.breed = breed
        self.born_on = born_on
        self.weight = weight

    def get_age_in_months(self):
        return 12

    def feed(self, food):
        print(f"Animal {self.id} fed.")

    def get_id(self):
        return self.id

    def get_breed(self):
        return self.breed

    def get_born_on(self):
        return self.born_on

    def get_weight(self):
        return self.weight


class Cow(FarmAnimal, IMeatAnimal):
    def __init__(self, id, breed, born_on, weight, is_producing_milk, milk):
        super().__init__(id, breed, born_on, weight)
        self.producing_milk = is_producing_milk
        self.milk_amount = milk

    def cut(self):
        return [
            Cut(10, "T-Bone", "Rib Section", self.get_weight() * 0.20),
            Cut(11, "Ribeye", "Loin Section", self.get_weight() * 0.12),
        ]

    def send_to_slaughter_house(self, slaughter_house):
        print("Cow moving to house.")

    def save_to_database(self):
        from .controller import MongoConnection
        document = {
            "id": self.get_id(),
            "breed": self.get_breed(),
            "bornOn": self.get_born_on(),
            "weight": self.get_weight(),
            "isProducingMilk": self.producing_milk,
            "milk": self.milk_amount,
        }
        MongoConnection.save_document("cows", document)

    def is_producing_milk(self):
        return self.producing_milk

    def milk(self):
        return self.milk_amount


class Pig(FarmAnimal, IMeatAnimal):
    def __init__(self, id, breed, born_on, weight, ideal_weight):
        super().__init__(id, breed, born_on, weight)
        self.ideal_weight = ideal_weight

    def cut(self):
        return [
            Cut(1, "Pork Chop", "Standard Cut", self.get_weight() * 0.15),
            Cut(2, "Ribs", "Rib Extraction", self.get_weight() * 0.10),
        ]

    def send_to_slaughter_house(self, slaughter_house):
        print("Pig moving to house.")

    def save_to_database(self):
        from .controller import MongoConnection
        document = {
            "id": self.get_id(),
            "breed": self.get_breed(),
            "bornOn": self.get_born_on(),
            "weight": self.get_weight(),
            "idealWeight": self.ideal_weight,
        }
        MongoConnection.save_document("pigs", document)

    def get_ideal_weight(self):
        return self.ideal_weight


class Sheep(FarmAnimal):
    def __init__(self, id, breed, born_on, weight, last_sheering):
        super().__init__(id, breed, born_on, weight)
        self.last_sheering = last_sheering

    def save_to_database(self):
        from .controller import MongoConnection
        document = {
            "id": self.get_id(),
            "breed": self.get_breed(),
            "bornOn": self.get_born_on(),
            "weight": self.get_weight(),
            "lastSheering": self.last_sheering,
        }
        MongoConnection.save_document("sheeps", document)

    def get_last_sheering(self):
        return self.last_sheering


class Chicken(FarmAnimal):
    def __init__(self, id, breed, born_on, weight, is_molting, number_of_eggs_per_week):
        super().__init__(id, breed, born_on, weight)
        self.molting = is_molting
        self.number_of_eggs_per_week = number_of_eggs_per_week

    def lay_an_egg(self):
        print("Egg laid.")

    def save_to_database(self):
        from .controller import MongoConnection
        document = {
            "id": self.get_id(),
            "breed": self.get_breed(),
            "bornOn": self.get_born_on(),
            "weight": self.get_weight(),
            "isMolting": self.molting,
            "numberOfEggsPerWeek": self.number_of_eggs_per_week,
        }
        MongoConnection.save_document("chickens", document)

    def is_molting(self):
        return self.molting

    def get_number_of_eggs_per_week(self):
        return self.number_of_eggs_per_week

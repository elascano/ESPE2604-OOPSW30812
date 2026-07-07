from datetime import date
from model.meat_animals import Pig, Cow
from model.produce_animals import Chicken, Sheep
from model.infrastructure import Food, SlaughterHouse
from view.farm_view import FarmView

class FarmController:
    def __init__(self):
        self.view = FarmView()
        self.animals = [
            Pig(1, "Landrace", date(2025, 5, 10), 85.0, 110.0),
            Cow(2, "Holstein", date(2023, 3, 15), 450.0, True),
            Chicken(3, "Leghorn", date(2025, 11, 20), 2.1, False, 6),
            Sheep(4, "Merino", date(2024, 1, 5), 55.0, date(2026, 2, 10))
        ]
        self.sample_food = Food(501, "Balanceado Premium")
        self.slaughter_house = SlaughterHouse(1, "Camal Central", "Av. Principal 123", "0999999999")

    def run_farm_operations(self):
        self.view.show_welcome()

        for animal in self.animals:
            animal_type = animal.__class__.__name__
            info = {
                "id": animal._id,
                "type": animal_type,
                "breed": animal._breed,
                "weight": animal._weight,
                "age_months": animal.get_age_in_months()
            }
            
            if isinstance(animal, Cow):
                info["extra"] = f"¿Produces milk?: {'Sí' if animal.is_producing_milk_status() else 'No'}"
                self.view.show_animal_info(info)
                self.view.show_action_result("Milking", f"Were obtained {animal.milk()} litros.")
            
            elif isinstance(animal, Chicken):
                info["extra"] = f"Projected weekly eggs: {animal._number_of_eggs_per_week}"
                self.view.show_animal_info(info)
                self.view.show_action_result("Position", animal.lay_an_egg())
                animal.measure_quantity("Units", 6)
                self.view.show_action_result("Procedure", animal.procedure())
            
            elif isinstance(animal, Pig):
                info["extra"] = f"Ideal weight: {animal._ideal_weight} kg"
                self.view.show_animal_info(info)
                animal.send_to_slaughter_house(self.slaughter_house)
                self.view.show_action_result("Destination", f"Sent to {animal.slaughter_house}")
            
            else:
                self.view.show_animal_info(info)

            self.view.show_action_result("Feeding", animal.feed(self.sample_food))
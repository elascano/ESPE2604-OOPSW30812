import sys
import os

sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from controller.animal_controller import AnimalController

class AnimalView:
    def display_header(self, title):
        print(f"       {title}")
        print()

    def display_footer(self):
        print()
        print("       SYSTEM COMPLETED")

    def display_animal(self, animal, title):
        print(f"--- {title} ---")
        print(f"ID: {animal.get_id()}")
        print(f"Breed: {animal.get_breed()}")
        print(f"Weight: {animal.get_weight()} kg")
        
        if hasattr(animal, 'get_age_in_months'):
            print(f"Age: {animal.get_age_in_months()} months")
        
        if hasattr(animal, 'is_producing_milk'):
            print(f"Producing milk? {animal.is_producing_milk()}")
        
        if hasattr(animal, 'get_ideal_weight'):
            print(f"Ideal weight: {animal.get_ideal_weight()} kg")
        
        if hasattr(animal, 'is_is_molting'):
            print(f"Is molting? {animal.is_is_molting()}")
            print(f"Eggs per week: {animal.get_number_of_eggs_per_week()}")
        
        if hasattr(animal, 'get_kg_of_wool'):
            print(f"Wool: {animal.get_kg_of_wool()} kg")
        
        if animal.get_slaughter_house() and animal.get_slaughter_house().get_name():
            print(f"Slaughterhouse: {animal.get_slaughter_house().get_name()}")
        print()

    def display_product(self, product, message):
        if product:
            print(f"{message}: {product.get_quantity()} {product.get_unit()}")
        else:
            print(f"{message}: No product available")

    def display_cuts(self, cuts, title):
        print(title)
        print("Cuts")
        if cuts and len(cuts) > 0:
            for cut in cuts:
                print(f"  {cut.get_description()} - {cut.get_procedure()} - {cut.get_weight()} kg")
        else:
            print("  No cuts available")
        print()

    def display_message(self, message):
        print(message)

    def display_separator(self):
        print("----------------------------------------")

    def display_animal_summary(self, animals):
        print("         ANIMALS REGISTERED")
        print()
        print(f"Total animals: {len(animals)}")
        print("----------------------------------------")
        
        cows = [a for a in animals if a.__class__.__name__ == 'Cow']
        pigs = [a for a in animals if a.__class__.__name__ == 'Pig']
        chickens = [a for a in animals if a.__class__.__name__ == 'Chicken']
        sheeps = [a for a in animals if a.__class__.__name__ == 'Sheep']
        
        if len(cows) > 0: print(f"Cows: {len(cows)}")
        if len(pigs) > 0: print(f"Pigs: {len(pigs)}")
        if len(chickens) > 0: print(f"Chickens: {len(chickens)}")
        if len(sheeps) > 0: print(f"Sheep: {len(sheeps)}")
        
        print("----------------------------------------")
        for animal in animals:
            type_name = animal.__class__.__name__
            print(f"{type_name} - {animal.get_breed()} - {animal.get_weight()} kg")
        print()

    def run(self):
        controller = AnimalController()
        
        self.display_header("ANIMAL FARM SYSTEM")
        
        animals = controller.get_all_animals()
        
        cow1 = animals[0]
        self.display_animal(cow1, "COW 1: DAIRY COW")
        milk = controller.produce_product(cow1.get_id())
        self.display_product(milk, "Product")
        print()
        
        cow2 = animals[1]
        self.display_animal(cow2, "COW 2: MEAT COW")
        beef_cuts = controller.get_cuts(cow2.get_id())
        self.display_cuts(beef_cuts, "BEEF CUTS")
        
        pig1 = animals[2]
        self.display_animal(pig1, "PIG 1")
        pork_cuts1 = controller.get_cuts(pig1.get_id())
        self.display_cuts(pork_cuts1, "PORK CUTS")
        
        pig2 = animals[3]
        self.display_animal(pig2, "PIG 2")
        pork_cuts2 = controller.get_cuts(pig2.get_id())
        self.display_cuts(pork_cuts2, "PORK CUTS")
        
        chicken = animals[4]
        self.display_animal(chicken, "CHICKEN")
        laid = controller.lay_egg(chicken.get_id())
        self.display_message("The chicken laid an egg!" if laid else "The chicken could not lay an egg.")
        self.display_message(f"Eggs per week: {chicken.get_number_of_eggs_per_week()}")
        print()
        eggs = controller.produce_product(chicken.get_id())
        self.display_product(eggs, "Eggs produced")
        print()
        
        sheep = animals[5]
        self.display_animal(sheep, "SHEEP")
        wool = controller.shear_sheep(sheep.get_id())
        self.display_message(f"Wool obtained: {wool} kg")
        print()
        wool_product = controller.produce_product(sheep.get_id())
        self.display_product(wool_product, "Wool produced")
        print()
        
        self.display_animal_summary(animals)
        self.display_footer()

if __name__ == "__main__":
    view = AnimalView()
    view.run()
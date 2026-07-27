from cow import Cow
from pig import Pig
from chicken import Chicken
from sheep import Sheep
from food import Food
from farm_animal_dao import FarmAnimalDAO

print("========== FARM MANAGEMENT SYSTEM ==========")

id = int(input("Enter ID: "))
breed = input("Enter Breed: ")
weight = float(input("Enter Weight: "))

print("\nSelect Animal")
print("1. Cow")
print("2. Pig")
print("3. Chicken")
print("4. Sheep")

option = int(input("Option: "))

animal = None

if option == 1:
    animal = Cow(id, breed, weight)

elif option == 2:
    animal = Pig(id, breed, weight)

elif option == 3:
    animal = Chicken(id, breed, weight)

elif option == 4:
    animal = Sheep(id, breed, weight)

else:
    print("Invalid option")
    exit()

grass = Food(1, "Grass")

animal.feed(grass)
animal.born()

dao = FarmAnimalDAO()
dao.save_animal(animal)

print("\n===== BUSINESS RULES =====")
print("Young Animal:", animal.is_young_animal())
print("Ready For Sale:", animal.is_ready_for_sale())
print("Needs More Food:", animal.needs_more_food())

print("\n===== ANIMALS IN DATABASE =====")

animals = dao.get_animals()

for animal in animals:
    print(animal)
from model.chicken import Chicken
from datetime import date

chickens = []
option = 'y'

while option == 'y' or option == 'Y':

    print("\n--- ENTER CHICKEN DATA ---")

    id = int(input("Id: "))
    name = input("Name: ")
    color = input("Color: ")

    year = int(input("Year of birth: "))
    month = int(input("Month (1-12): "))
    day = int(input("Day: "))

    born_on_date = date(year, month, day)

    age = int(input("Age: "))

    is_molting_input = input("Is molting? (true/false): ").lower()
    is_molting = is_molting_input == "true"

    chicken = Chicken(
        id,
        name,
        color,
        born_on_date,
        age,
        is_molting
    )

    chickens.append(chicken)

    option = input("Do you want to add another chicken? (y/n): ")

print("\n--- CHICKENS LIST ---")

for i in range(len(chickens)):
    print(f"chicken [{i + 1}] --> {chickens[i]}")
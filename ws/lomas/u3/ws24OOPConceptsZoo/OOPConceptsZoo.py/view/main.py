import sys
import os
sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from datetime import datetime
from model.food import Food
from model.slaughter_house import SlaughterHouse
from model.chicken import Chicken
from model.cow import Cow
from model.pig import Pig
from model.sheep import Sheep

def main():
    today = datetime.now()

    print("--- Register Food ---")
    food_id = int(input("Enter food ID: "))
    food_description = input("Enter food description: ")
    food = Food(food_id, food_description)

    print("\n--- Register Slaughterhouse ---")
    slaughterhouse_description = input("Enter slaughterhouse description: ")
    slaughterhouse = SlaughterHouse(slaughterhouse_description)

    print("\n--- Register Chicken ---")
    chicken_id = int(input("Enter chicken ID: "))
    chicken_breed = input("Enter chicken breed: ")
    chicken_weight = float(input("Enter chicken weight: "))
    is_molting = input("Is the chicken molting? (true/false): ").lower() == "true"
    eggs_per_week = int(input("Enter number of eggs per week: "))
    chicken = Chicken(chicken_id, chicken_breed, today, chicken_weight, is_molting, eggs_per_week)

    print("\n--- Register Cow ---")
    cow_id = int(input("Enter cow ID: "))
    cow_breed = input("Enter cow breed: ")
    cow_weight = float(input("Enter cow weight: "))
    is_producing_milk = input("Is the cow producing milk? (true/false): ").lower() == "true"
    milk_liters = float(input("Enter milk liters: "))
    cow = Cow(cow_id, cow_breed, today, cow_weight, is_producing_milk, milk_liters)

    print("\n--- Register Pig ---")
    pig_id = int(input("Enter pig ID: "))
    pig_breed = input("Enter pig breed: ")
    pig_weight = float(input("Enter pig weight: "))
    pig_ideal_weight = float(input("Enter pig ideal weight: "))
    pig = Pig(pig_id, pig_breed, today, pig_weight, pig_ideal_weight)

    print("\n--- Register Sheep ---")
    sheep_id = int(input("Enter sheep ID: "))
    sheep_breed = input("Enter sheep breed: ")
    sheep_weight = float(input("Enter sheep weight: "))
    sheep = Sheep(sheep_id, sheep_breed, today, sheep_weight, today)

    print("\n--- Execution Outputs ---")
    chicken.feed(food)
    chicken.lay_an_egg()

    print(f"Cow producing milk: {cow.is_producing_milk} ({cow.milk()}L)")
    cow.send_to_slaughter_house(slaughterhouse)

    cow_cuts = cow.cut()
    for cut in cow_cuts:
        print(f"Obtained Cut: {cut.description} - Weight: {cut.weight}kg")

    pig.send_to_butcher()

if __name__ == "__main__":
    main()
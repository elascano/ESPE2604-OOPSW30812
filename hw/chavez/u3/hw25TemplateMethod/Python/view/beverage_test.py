import sys
import os
#sys.path.append(os.path.dirname(os.path.dirname(__file__)))
from model.coffee import Coffee
from model.tea import Tea
1
if __name__ == "__main__":
    option = 0
    tea = Tea()
    coffee = Coffee()

    while option != 3:
        print("--- Beverage Menu ---")
        print("1. Make Tea")
        print("2. Make Coffee")
        print("3. Exit")
        
        try:
            option = int(input("Choose an option: "))
            print()

            if option == 1:
                print("Making tea ...")
                tea.prepare_recipe()
            elif option == 2:
                print("Making coffee ...")
                coffee.prepare_recipe()
            elif option == 3:
                print("Exiting the program...")
            else:
                print("Invalid option. Try again.")
        
        except ValueError:
            print("Please enter a valid number only!\n")
        
        print("-" * 30)
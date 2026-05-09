import sys
import os


sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from controller.chicken_controller import ChickenController

def main():
    controller = ChickenController()
    
    print("--- Chicken Farm Simulator ---")
    
    
    chicken = controller.create_chicken(1, "Lucy", "Brown and White", 2, False)
    
    while True:
        print("\n1. Show Chicken State")
        print("2. Add New Chicken")
        print("0. Exit")
        
        option = input("Select an option: ")
        
        if option == "1":
            print("\n" + str(chicken))
        elif option == "2":
            id = int(input("Enter ID: "))
            name = input("Enter Name: ")
            color = input("Enter Color: ")
            age = int(input("Enter Age: "))
           
            molting = input("Is molting? (s/n): ").lower() == 's'
            
            chicken = controller.create_chicken(id, name, color, age, molting)
            print("Chicken added successfully!")
        elif option == "0":
            print("Exiting simulator...")
            break
        else:
            print("Invalid option, try again.")

if __name__ == "__main__":
    main()

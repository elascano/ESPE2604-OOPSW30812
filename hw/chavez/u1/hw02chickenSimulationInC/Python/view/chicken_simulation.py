from model.Chicken import Chicken

def main():
    Chicken1 = Chicken("Lucy", "White", 2, False, 0, 0)

    option = 0
    while option != 8:
        print("\nMenu")
        print("1. Show Chicken Information")
        print("2. Cluck")
        print("3. Wander")
        print("4. Eat")
        print("5. Drink")
        print("6. Poop")
        print("7. Lay an Egg")
        print("8. Exit")

        option = int(input("\nSelect an option: "))

        if option == 1:
            Chicken1.show_information()
        elif option == 2:
            Chicken1.cluck()
        elif option == 3:
            Chicken1.wander()
        elif option == 4:
            Chicken1.eat()
        elif option == 5:
            Chicken1.drink()
        elif option == 6:
            Chicken1.poop()
        elif option == 7:
            Chicken1.lay_an_egg()
        elif option == 8:
            print("\nExiting the program...")
        else:
            print("\nInvalid option. Please try again.")

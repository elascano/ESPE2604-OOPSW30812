from model.chicken import Chicken

chicken = Chicken("Lucy", "Brown and White", 2, False, 0, 0)

option = 1

while(option != 8):

    print("\n---Actions---")
    print("1. Show information")
    print("2. Cluck")
    print("3. Wander")
    print("4. Eat")
    print("5. Drink")
    print("6. Poop")
    print("7. Lay an egg")
    print("8. Exit")

    try:

        option = int(input("Select an option: "))

        match option:

            case 1:
                chicken.show_information()

            case 2:
                chicken.cluck()

            case 3:
                chicken.wander()

            case 4:
                chicken.eat()

            case 5:
                chicken.drink()

            case 6:
                chicken.poop()

            case 7:
                chicken.lay_an_egg()

            case 8: 
                print("Finish")

            case _:
                print("Invalid option")
 
    except ValueError:
        print("Enter a valid number")
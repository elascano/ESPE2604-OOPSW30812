name = "Lucy"
color = "Brown and White"
age = 2
is_molting = False
egg_counter = 0

def cluck():
    print(f"{name}: Cluck cluck!")

def wander():
    print(f"{name} is wandering around.")

def eat():
    print(f"{name} is eating.")

def drink():
    print(f"{name} is drinking.")

def poop():
    print(f"{name} did poop.")

def lay_an_egg():
    global egg_counter
    egg_counter += 1
    print(f"{name} laid an egg! Total: {egg_counter}")

def show_state():
    print("\n--- Chicken State ---")
    print(f"Name: {name}")
    print(f"Color: {color}")
    print(f"Age: {age} years old")
    print(f"Molting: {'Yes' if is_molting else 'No'}")
    print(f"Eggs: {egg_counter}")
    print("---------------------\n")

while True:
    print("1. cluck\n2. wander\n3. eat\n4. drink\n5. poop\n6. lay an egg\n7. show state\n0. exit")
    option = input("Select behavior: ")

    if option == "1": cluck()
    elif option == "2": wander()
    elif option == "3": eat()
    elif option == "4": drink()
    elif option == "5": poop()
    elif option == "6": lay_an_egg()
    elif option == "7": show_state()
    elif option == "0":
        print("Exiting...")
        break
    else:
        print("Invalid option.")
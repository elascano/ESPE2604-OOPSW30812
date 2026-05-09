from chicken import Chicken

def main():
    print("Chicken Facts")
    
    name = input("Enter Chicken Name: ")
    
    try:
        age_str = input("Enter age (months): ")
        age = int(age_str)
    except ValueError:
        print("Error: Debes ingresar un número para la edad. Usaremos 0.")
        age = 0
    
    my_chicken = Chicken(name, age)
    
    print(f"\n[{my_chicken.name}] says: CLUCK CLUCK CLUCK!")
    print(f"My Chicken is ---->{my_chicken}")

if __name__ == "__main__":
    main()
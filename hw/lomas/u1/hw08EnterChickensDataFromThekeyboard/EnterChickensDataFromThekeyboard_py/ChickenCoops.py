import sys
import os
from datetime import datetime


from model.chicken import Chicken 

def main():
    # Arreglo de 5 espacios inicializado en None
    chickens = [None] * 5
    count = 0

  
    while count < 5:
        print(f"\n--- Enter data for chicken {count + 1} ---")
        try:
            id_val = int(input("ID: "))
            name = input("Name: ")
            color = input("Color: ")
            age = int(input("Age: "))
            # Convertimos la entrada a booleano
            is_molting_input = input("Is Molting? (true/false): ").lower()
            is_molting = is_molting_input == 'true'
            
            
            chickens[count] = Chicken(id_val, name, color, datetime.now(), age, is_molting)
            count += 1
        except ValueError:
            print(">> Error: Invalid input. Please enter numbers for ID and Age.")
            continue

        if count < 5:
            option = input("Do you want to enter another chicken? (s/n): ").lower()
            if option != 's':
                break

   
    defaults = [
        (1, "Lucy", "brown and white", 0, False),
        (2, "Christopher Lomas", "Red", 0, False),
        (3, "Andres Lomas", "White", 0, True),
        (4, "Jonathan Lomas", "Yellow", 0, True)
    ]

    for d in defaults:
        if count < 5:
            chickens[count] = Chicken(d[0], d[1], d[2], datetime.now(), d[3], d[4])
            count += 1

    
    print("\n" + "="*40)
    print("Quiz 26-4-2026 CHRISTOPHER LOMAS")
    print("="*40)
    
    for i in range(count):
        if chickens[i] is not None:
            # Seteamos el ID basado en el índice (como en tu Java)
            chickens[i].id = i + 1 
            print(f"name---> {chickens[i].name}")
            print(f"chicken [{i + 1}] {chickens[i]}")

if __name__ == "__main__":
    main()
from model.chicken import Chicken

def main():
    chickens = []
    counter = 0
    
    print("Chicken Registration System\n")
    
    while True:
        print(f"\nEnter Chicken {counter + 1} ")
        
        id = int(input("Enter id: "))
        name = input("Enter name: ")
        color = input("Enter color: ")
        age = int(input("Enter age: "))
        isMolting_input = input("Is molting? (true/false): ")
        isMolting = isMolting_input.strip().lower() == 'true'
        
        chickens.append(Chicken(id, name, color, age, isMolting))
        counter += 1
        
        response = input("\nDo you want to enter another chicken? (y/n): ")
        if response.strip().lower() != 'y':
            break
    
    print("\nList of Registered Chickens\n")
    for i in range(counter):
        print(f"name --> {chickens[i].name}")
        print(f"chicken [{i + 1}] {chickens[i]}")
    
    print(f"\nTotal registered chickens: {counter}")

if __name__ == "__main__":
    main()
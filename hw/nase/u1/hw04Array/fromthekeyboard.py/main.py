//author Jennyfer Nase
from chicken import Chicken

def main():
    chickens = []
    print("--- Jennyfer Nase ---")

    for i in range(5):
        print(f"\n Chicken #{i + 1}")
        
        chickens.append(Chicken(
            int(input("ID: ")), 
            input("Name: "), 
            input("Color: "), 
            int(input("Age: ")), 
            input("isMolting (true/false): ").lower() == "true"
        ))
        
        if i < 4 and input("Another? (yes/no): ").lower() != "yes": break

    print("\n--- FINAL RESULTS ---")
    for c in chickens: print(c)

if __name__ == "__main__":
    main()
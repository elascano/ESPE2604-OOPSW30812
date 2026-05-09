//author Jennyfer Nase
from chicken import Chicken
from coop import ChickenCoop
from chicken_farmer import ChickenFarmer

def main():
    farmer = ChickenFarmer("Jennyfer Nase")
    
    lucy = Chicken(1, "Lucy", "White and Brown", 1, True)
    
    coop = ChickenCoop(id=1)
    coop.add_chicken(lucy)
    
    print(f"My Chicken is ---->{lucy}")

if __name__ == "__main__":
    main()
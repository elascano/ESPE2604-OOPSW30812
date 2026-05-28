//author Jennyfer Nase
from chicken import Chicken

def main():
   
    print("Quiez 2026-04-26 Jennyfer Nase")

    chickens = [
        Chicken(1, "Lucy", "brown and white", 0, False, "Sat May 09 15:10:16 ECT 2026"),
        Chicken(2, "Jennyfer Nase", "Black", 0, False, "Fri Aug 10 00:00:00 ECT 1906"),
        Chicken(3, "Fernanda", "Red", 0, True, "Fri Aug 10 00:00:00 ECT 1906"),
        Chicken(4, "Maria", "Brown", 0, True, "Fri Aug 10 00:00:00 ECT 1906"),
        Chicken(5, "Maria", "Brown", 0, True, "Fri Aug 10 00:00:00 ECT 1906")
    ]
    for i, chiken_obj in enumerate(chickens, start=1):
        print(f"chicken[{i}]{chiken_obj}")

if __name__ == "__main__":
    main()
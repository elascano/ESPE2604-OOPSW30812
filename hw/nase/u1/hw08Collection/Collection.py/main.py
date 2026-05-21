# author Jennyfer Nase
from person import Person
from person_controller import PersonController

def main():
   
    p1 = Person(1, "Jennyfer Nase", "2006-08-10", True)
    p2 = Person(2, "Tarjelia Tello", "1910-08-08", False)

    things = [8000, 3.5, "Quito", True, p1, p2, 4078.76, "a"]
    print(f"size of things --> {len(things)}")
    print("These are my things -->")
    print(things)

    people = [p1, p2]
    print(f"\npeople --> {people}")
    
    print("")
    for p in people:
        print(f"Person -->{p}")
    print("")
    full_list = PersonController.get_extended_people(p1, p2)
    
    for p in full_list:
        print(f"Person -->{p}")

if __name__ == "__main__":
    main()
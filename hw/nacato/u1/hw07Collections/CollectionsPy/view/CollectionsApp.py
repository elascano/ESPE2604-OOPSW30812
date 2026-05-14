import sys
import os
sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from datetime import date
from model.Person import Person

def print_the_collection(things):
    print(f"\nsize of things --> {len(things)}")
    formatted_things = f"[{', '.join(str(t) for t in things)}]"
    print(f"These are my things --> \n{formatted_things}")

def main():
    id = 1
    full_name = "Angie Nacato"
    born_on_date = date(2006, 12, 16)
    alive = True

    person = Person(id, full_name, born_on_date, alive)
    print(person)
    print(f"Age of person 1 is {person.compute_age()}")

    id = 2
    full_name = "Sonia Toapanta"
    born_on_date = date(1976, 12, 7)
    alive = False

    person2 = Person(id, full_name, born_on_date, alive)
    print(f"Age of person 2 is {person2.compute_age()}")

    things = []
    print("size of things --> []")

    things.append(8000)
    things.append(3.5)
    things.append("Quito")
    things.append(True)

    print_the_collection(things)

    things.append(person)
    things.append(person2)

    print_the_collection(things)

    things.append(4078.76)
    things.append("a")

    print_the_collection(things)

    integers = []
    integers.append(5)
    integers.append(id)

    people = []
    people.append(person)
    people.append(person2)

    print("")
    formatted_people = f"[{', '.join(str(p) for p in people)}]"
    print(f"people --> {formatted_people}")
    print("")

    for p in people:
        print(f"Person --> {p}")

    print("")
    for i in range(2, 7):
        people.append(Person(i + 1, "Angie", date.today(), True))

    for p in people:
        print(f"Person --> {p}")

if __name__ == "__main__":
    main()
import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from datetime import date
from controller.Person import Person

def print_the_collection(things):
    print(f"\nsize of things --> {len(things)}")
    print(f"These are my things --> \n{things}")

def main():
    # Primera persona
    id_val = 1
    full_name = "Brandon Collahuazo"
    born_on_date = date(1999, 3, 4)
    alive = True
    person = Person(id_val, full_name, born_on_date, alive)

    print(person)
    print(f"Age of person 1 is {person.compute_age_in_years()}")

    # Segunda persona
    id_val = 2
    full_name = "Elizabeth Cumbajin"
    born_on_date = date(1962, 4, 23)
    alive = True
    person2 = Person(id_val, full_name, born_on_date, alive)

    # Colección heterogénea (Como tu 'Collection things')
    things = [] # En Python las listas aceptan cualquier tipo de dato
    print(f"size of things --> {things}")

    things.append(8000)
    things.append(3.5)
    things.append("Quito")
    things.append(True)

    print_the_collection(things)

    things.append(4078.76)
    things.append("a")

    print_the_collection(things)

    # Lista de objetos Person (Como tu 'ArrayList<Person> people')
    people = []
    people.append(person)
    people.append(person2)

    print(f"\npeople --> {people}")
    print("")

    # ForEach equivalente
    for p in people:
        print(f"Person --> {p}")

    print("")
    
    # Bucle for para agregar más "pepitos"
    # range(2, 7) genera: 2, 3, 4, 5, 6
    for i in range(2, 7):
        people.append(Person(i + 1, "pepito", date.today(), True))

    # Imprimir la lista final actualizada
    for p in people:
        print(f"Person --> {p}")

if __name__ == "__main__":
    main()
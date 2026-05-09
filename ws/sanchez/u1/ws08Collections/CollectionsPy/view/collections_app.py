# "author": "Joel Sanchez, The Softwarriors, @ESPE"

from model.Person import Person
from datetime import date

def print_the_collection(things):
    print(f"\nsize of things --> {len(things)}")
    print("These are my things --> ")
    print(things)

def main():
    id = 1
    full_name = "Sanchez Joel"
    born_on_date = date(2006, 7, 4)  
    alive = True
    
    person = Person(id, full_name, born_on_date, alive)
    
    print(person)
    print(f"Age of person 1 is {person.compute_age_in_years()}")
    
    id = 2
    full_name = "Veronica Lanchimba"
    born_on_date = date(1982, 1, 4)  
    alive = False
    
    person2 = Person(id, full_name, born_on_date, alive)
    
    print(f"Age of person 2 is {person2.compute_age_in_years()}")
    
    things = []
    print(f"\nsize of things --> {len(things)}")
    
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
    
    people = []
    people.append(person)
    people.append(person2)
    
    print("\npeople -->", people)
    print("")
    
    for p in people:
        print(f"Person --> {p}")


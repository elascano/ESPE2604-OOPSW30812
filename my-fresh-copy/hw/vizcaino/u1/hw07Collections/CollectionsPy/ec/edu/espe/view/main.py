from datetime import date
from ec.edu.espe.model.person import Person


def print_the_collection(things):
    print("size of things -->", len(things))
    print("These are my Things -->", len(things))  


def main():
    id = 1
    name = "Adrian Vizcaino"
    born_on_date = date(2006, 5, 17)
    alive = True

    person = Person(id, name, born_on_date, alive)

    print(person)
    print("age of person 1 is", person.compute_age_in_years())

    id = 2
    name = "Cecilia Torres"
    born_on_date = date(1940, 5, 17)
    alive = True

    person2 = Person(id, name, born_on_date, alive)

    print("age of person 2 is", person2.compute_age_in_years())

    # colección
    things = []
    print("size of things -->", len(things))

    things.append(8000)
    things.append(3.5)
    things.append("Quito")
    things.append(True)

    print_the_collection(things)

    things.append(person)
    things.append(person2)

    print_the_collection(things)

    things.append(4078.76)
    things.append('a')

    print_the_collection(things)

    # enteros
    integers = []
    integers.append(5)
    integers.append(id)

    # lista de personas
    people = []
    people.append(person)
    people.append(person2)

    print("")
    print("people -->" + str(people))  
    print("")

    for p in people:
        print("Person -->", p)

    print("")

    # loop como en Java
    for i in range(2, 7):
        people.append(Person(i + 1, "Adrian", date.today(), True))

    for p in people:
        print("Person ->>" + str(p))


if __name__ == "__main__":
    main()
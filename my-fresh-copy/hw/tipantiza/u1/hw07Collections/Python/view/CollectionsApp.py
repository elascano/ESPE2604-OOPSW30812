from datetime import date
from model.Person import Person


def print_the_collection(things):
    print(f"\nsize of things --> {len(things)}")
    print(f"These are my things --> \n{things}")


def main():

    id = 1
    full_name = "Alexander Tipantiza"
    born_on_date = date(2006, 1, 28)
    alive = True

    person = Person(id, full_name, born_on_date, alive)

    print(person)
    print("Age of person 1 is", person.compute_age_in_years())

    id = 2
    full_name = "Homero Simpson"
    born_on_date = date(1989, 10, 25)
    alive = False

    person2 = Person(id, full_name, born_on_date, alive)

    print("Age of person 2 is",
          person2.compute_age_in_years())

    things = []

    print("size of things -->", things)

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
        print("Person -->", p)


if __name__ == "__main__":
    main()
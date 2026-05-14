from datetime import date
try:
    from hw07Collections.Python.model.Person import Person
except ImportError:
    from model.Person import Person

def print_the_collection(things):
    print("The Collection")
    print("==============")
    for thing in things:
        print(thing)


def main():
    people = [
        Person(1, "Odalys", date(2005, 5, 31), True),
        Person(2, "Bob", date(1985, 8, 20), False),
        Person(3, "Charlie", date(2000, 12, 1), True)
    ]

    print_the_collection(people)


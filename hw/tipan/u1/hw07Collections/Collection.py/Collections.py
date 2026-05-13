from datetime import date

class Person:

    def __init__(self, id, full_name, born_on_date, alive):
        self.id = id
        self.full_name = full_name
        self.born_on_date = born_on_date
        self.alive = alive

    def __str__(self):
        return f"{self.id} - {self.full_name} - {self.born_on_date} - {self.alive}"


person1 = Person(
    1,
    "Ronald",
    date(2005, 5, 10),
    True
)

person2 = Person(
    2,
    "Valeria",
    date(2006, 8, 15),
    True
)

people = []

people.append(person1)
people.append(person2)

for p in people:
    print(p)
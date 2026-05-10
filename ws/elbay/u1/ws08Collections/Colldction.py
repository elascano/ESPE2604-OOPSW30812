"""
@author Didier Elbay <Code_Bros , @ESPE>
"""

from datetime import date


class Person:

    def __init__(self, id, full_name, born_on_date, alive):
        self.id = id
        self.full_name = full_name
        self.born_on_date = born_on_date
        self.alive = alive

    def compute_age(self):
        current_date = date.today()

        age = current_date.year - self.born_on_date.year

        if (
            (current_date.month, current_date.day)
            < (self.born_on_date.month, self.born_on_date.day)
        ):
            age -= 1

        return age

    def __str__(self):
        is_alive = "YES" if self.alive else "NO"

        return (
            f"Person{{id={self.id}, "
            f"fullName={self.full_name}, "
            f"bornOnDate={self.born_on_date}, "
            f"alive={is_alive}}}"
        )


# Person 1
id = 1
full_name = "Didier Elbay"
born_on_date = date(1970, 12, 17)
alive = True

person = Person(id, full_name, born_on_date, alive)

print(person)
print("Age of person 1 is", person.compute_age())

# Person 2
id = 2
full_name = "Tarjelia Tello"
born_on_date = date(1910, 8, 8)
alive = False

person2 = Person(id, full_name, born_on_date, alive)

print(person2)
print("Age of person 2 is", person2.compute_age())

things = []
things.append(person)
things.append(person2)

print("Size of things is", len(things))

integers = []
integers.append(5)
integers.append(id)

print("integers:", integers)

people = []
people.append(person)
people.append(person2)

print("people:", people)
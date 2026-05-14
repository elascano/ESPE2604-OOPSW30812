from datetime import date

class Person:
    def __init__(self, id, full_name, born_on_date, alive):
        self.id = id
        self.full_name = full_name
        self.born_on_date = born_on_date
        self.alive = alive

    def compute_age(self):
        today = date.today()

        age = today.year - self.born_on_date.year

        if (today.month, today.day) < (self.born_on_date.month, self.born_on_date.day):
            age -= 1

        return age

    def __str__(self):
        return f"Person(id={self.id}, full_name='{self.full_name}', born_on_date={self.born_on_date}, alive={self.alive})"


def main():

    id = 1
    full_name = "Didier Elbay"
    born_on_date = date(1970, 12, 17)
    alive = True

    person = Person(id, full_name, born_on_date, alive)

    print(person)
    print("Age of person 1 is", person.compute_age())

    
    id = 2
    full_name = "Tarjelia Tello"
    born_on_date = date(1910, 8, 8)
    alive = False

    person2 = Person(id, full_name, born_on_date, alive)

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


if __name__ == "__main__":
    main()
from model.Person import Person 

class PersonController:
    def __init__(self):
        self.people = []

    def add_person(self, person: Person):
        self.people.append(person)

    def get_people(self):
        return self.people
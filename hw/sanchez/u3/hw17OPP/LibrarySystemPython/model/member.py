from model.person import Person

class Member(Person):

    def __init__(self, id, name, email):
        super().__init__(id, name)
        self.email = email

    def get_info(self):
        return f"{self.name} - {self.email}"
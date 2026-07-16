from model.employee import Employee

class Teller(Employee):

    def __init__(self, name):
        super().__init__(name, "Teller")

    def display(self):
        print(f"{self.title}: {self.name}")
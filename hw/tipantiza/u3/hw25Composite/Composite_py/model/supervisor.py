from model.employee import Employee

class Supervisor(Employee):

    def __init__(self, name, title):
        super().__init__(name, title)
        self.employees = []

    def add(self, employee):
        self.employees.append(employee)

    def remove(self, employee):
        self.employees.remove(employee)

    def display(self):
        print(f"{self.title}: {self.name}")
        for employee in self.employees:
            employee.display()
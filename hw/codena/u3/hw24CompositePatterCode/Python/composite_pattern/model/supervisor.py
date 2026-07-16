from model.employee import Employee


class Supervisor(Employee):

    def __init__(self):
        super().__init__()
        self.directReports = []

    def stateName(self):
        super().stateName()

        for employee in self.directReports:
            employee.stateName()

    def add(self, employee):
        self.directReports.append(employee)

    def remove(self, employee):
        self.directReports.remove(employee)

    def getChild(self, index):
        return self.directReports[index]
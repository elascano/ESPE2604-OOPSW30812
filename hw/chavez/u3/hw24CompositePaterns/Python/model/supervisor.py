from model.employee import Employee


class Supervisor(Employee):

    def __init__(self, name, title):
        super().__init__(name, title)
        self.direct_reports = []

    def add(self, employee):
        self.direct_reports.append(employee)

    def state_name(self):
        super().state_name()

        for employee in self.direct_reports:
            employee.state_name()
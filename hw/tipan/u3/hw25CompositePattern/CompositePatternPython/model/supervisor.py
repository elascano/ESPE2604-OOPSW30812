from model.employee import Employee


class Supervisor(Employee):

    def __init__(self, name):
        super().__init__(name)
        self.direct_reports = []

    def add(self, employee):
        self.direct_reports.append(employee)

    def remove(self, employee):
        self.direct_reports.remove(employee)

    def get_direct_reports(self):
        return self.direct_reports

    def state_name(self):
        return f"{self.__class__.__name__}: {self.name}"
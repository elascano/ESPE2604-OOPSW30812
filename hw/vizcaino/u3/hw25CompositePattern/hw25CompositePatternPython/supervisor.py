from employee import Employee

class Supervisor(Employee):
    def __init__(self):
        super().__init__()
        self.direct_reports = []

    def state_name(self):
        super().state_name()
        if len(self.direct_reports) > 0:
            for report in self.direct_reports:
                report.state_name()

    def add(self, employee: Employee):
        self.direct_reports.append(employee)
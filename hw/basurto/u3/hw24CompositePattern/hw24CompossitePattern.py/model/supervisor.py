from abc import ABC
from model.employee import Employee

class Supervisor(Employee, ABC):
    def __init__(self):
        super().__init__()
        self.direct_reports = []

    def state_name(self):
        super().state_name()
        for report in self.direct_reports:
            report.state_name()

    def add(self, employee):
        self.direct_reports.append(employee)
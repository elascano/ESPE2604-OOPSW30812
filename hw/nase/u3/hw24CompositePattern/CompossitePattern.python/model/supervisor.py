# Jennyfer Nase 

from model.employee import Employee

class Supervisor(Employee):
    def __init__(self):
        super().__init__()
        self.direct_reports = []  

    def state_name(self):
        super().state_name()  
        if self.direct_reports:
            for emp in self.direct_reports:
                emp.state_name()

    def add(self, an_employee):
        self.direct_reports.append(an_employee)
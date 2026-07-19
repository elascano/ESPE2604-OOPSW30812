from .employee import Employee

class Supervisor(Employee):
    def __init__(self):
        super().__init__()
        self.direct_reports = []
        
    def state_name(self):
        result = super().state_name()
        if len(self.direct_reports) > 0:
            for report in self.direct_reports:
                result += report.state_name()
        return result
                
    def add(self, an_employee):
        self.direct_reports.append(an_employee)

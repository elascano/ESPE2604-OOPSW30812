from .employee import Employee

class Teller(Employee):
    def __init__(self, a_name=None):
        super().__init__()
        self.title = "Teller"
        if a_name:
            self.name = a_name

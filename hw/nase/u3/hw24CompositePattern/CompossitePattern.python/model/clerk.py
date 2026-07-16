# Jennyfer Nase 

from model.employee import Employee

class Clerk(Employee):
    def __init__(self, a_name=None):
        super().__init__()
        self.title = "Clerk"
        if a_name is not None:
            self.name = a_name

    def state_name(self):
        super().state_name()
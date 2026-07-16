from .employee import Employee

class Clerk(Employee):
    def __init__(self, a_name=None):
        super().__init__()
        self.title = "Clerk"
        if a_name:
            self.name = a_name

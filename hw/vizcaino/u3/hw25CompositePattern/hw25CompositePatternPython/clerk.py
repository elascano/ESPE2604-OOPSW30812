from employee import Employee

class Clerk(Employee):
    def __init__(self, name=None):
        super().__init__()
        self.title = "Clerk"
        if name:
            self.name = name

    def state_name(self):
        super().state_name()
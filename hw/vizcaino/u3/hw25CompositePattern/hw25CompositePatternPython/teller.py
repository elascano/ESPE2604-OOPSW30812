from employee import Employee

class Teller(Employee):
    def __init__(self, name=None):
        super().__init__()
        self.title = "Teller"
        if name:
            self.name = name

    def state_name(self):
        super().state_name()
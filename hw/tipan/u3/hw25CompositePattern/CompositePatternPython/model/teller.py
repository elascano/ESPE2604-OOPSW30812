from model.employee import Employee


class Teller(Employee):

    def __init__(self, name):
        super().__init__(name)

    def state_name(self):
        return f"Teller: {self.name}"
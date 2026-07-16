from model.employee import Employee


class Clerk(Employee):

    def __init__(self, name):
        super().__init__(name)

    def state_name(self):
        return f"Clerk: {self.name}"
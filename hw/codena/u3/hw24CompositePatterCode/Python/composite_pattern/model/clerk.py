from model.employee import Employee


class Clerk(Employee):

    def __init__(self, name):
        super().__init__()
        self.title = "Clerk"
        self.name = name
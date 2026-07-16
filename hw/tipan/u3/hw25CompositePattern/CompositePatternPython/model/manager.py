from model.supervisor import Supervisor


class Manager(Supervisor):

    def __init__(self, name):
        super().__init__(name)

    def state_name(self):
        return f"Manager: {self.name}"
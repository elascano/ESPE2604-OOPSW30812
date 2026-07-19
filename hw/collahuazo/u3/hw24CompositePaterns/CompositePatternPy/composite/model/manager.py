from composite.model.supervisor import Supervisor


class Manager(Supervisor):

    def __init__(self, a_name):
        super().__init__()
        self.title = "Manager"
        self.name = a_name

    def state_name(self):

        super().state_name()

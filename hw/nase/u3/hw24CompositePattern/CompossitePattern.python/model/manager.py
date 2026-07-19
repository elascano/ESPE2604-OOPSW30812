# Jennyfer Nase 

from model.supervisor import Supervisor

class Manager(Supervisor):
    def __init__(self, a_name=None):
        super().__init__()
        self.title = "Manager"
        if a_name is not None:
            self.name = a_name

    def state_name(self):
        super().state_name()
from .supervisor import Supervisor

class Manager(Supervisor):
    def __init__(self, a_name=None):
        super().__init__()
        self.title = "Manager"
        if a_name:
            self.name = a_name

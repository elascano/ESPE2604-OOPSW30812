from model.supervisor import Supervisor

class Manager(Supervisor):
    def __init__(self, name=None):
        super().__init__()
        self.title = "Manager"
        if name:
            self.name = name
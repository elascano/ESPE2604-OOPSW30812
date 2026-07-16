from model.supervisor import Supervisor

class Manager(Supervisor):

    def __init__(self, name):
        super().__init__(name, "Manager")
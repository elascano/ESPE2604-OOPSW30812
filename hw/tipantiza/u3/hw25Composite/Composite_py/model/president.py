from model.supervisor import Supervisor

class President(Supervisor):

    def __init__(self, name):
        super().__init__(name, "President")
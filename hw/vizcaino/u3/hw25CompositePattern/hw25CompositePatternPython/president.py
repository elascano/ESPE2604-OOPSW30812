from supervisor import Supervisor

class President(Supervisor):
    _instance = None

    def __init__(self, name=None):
        super().__init__()
        self.title = "President"
        if name:
            self.name = name

    def state_name(self):
        super().state_name()

    @classmethod
    def get_president(cls, name):
        if cls._instance is None:
            cls._instance = President()
        cls._instance.name = name
        return cls._instance
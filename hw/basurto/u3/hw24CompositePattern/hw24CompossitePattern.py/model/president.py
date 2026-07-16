from model.supervisor import Supervisor

class President(Supervisor):
    _instance = None

    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            cls._instance = super().__new__(cls)
        return cls._instance

    def __init__(self, name=None):
        if not hasattr(self, "_initialized"):
            super().__init__()
            self.title = "President"
            self._initialized = True
        if name:
            self.name = name

    @classmethod
    def get_president(cls, name):
        president = cls()
        president.name = name
        return president
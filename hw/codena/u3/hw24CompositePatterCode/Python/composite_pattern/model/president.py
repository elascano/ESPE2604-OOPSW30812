from model.supervisor import Supervisor


class President(Supervisor):

    __instance = None

    def __new__(cls, name):
        if cls.__instance is None:
            cls.__instance = super().__new__(cls)
        return cls.__instance

    def __init__(self, name):
        if not hasattr(self, "_initialized"):
            super().__init__()
            self.title = "President"
            self._initialized = True

        self.name = name
# Jennyfer Nase 

from model.supervisor import Supervisor

class President(Supervisor):
    _instance = None  

    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            cls._instance = super(President, cls).__new__(cls)
            cls._instance._initialized = False
        return cls._instance

    def __init__(self, a_name=None):
        if self._initialized:
            if a_name is not None:
                self.name = a_name
            return
        
        super().__init__()
        self.title = "President"
        self.name = a_name if a_name is not None else "not assigned yet"
        self._initialized = True

    def state_name(self):
        super().state_name()

    @classmethod
    def get_president(cls, a_name):
        president = cls()
        president.name = a_name
        return president
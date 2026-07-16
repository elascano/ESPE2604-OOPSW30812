from .supervisor import Supervisor

class President(Supervisor):
    _president = None
    
    def __new__(cls, *args, **kwargs):
        if not cls._president:
            cls._president = super(President, cls).__new__(cls)
        return cls._president

    def __init__(self, a_name=None):
        if not hasattr(self, 'initialized'):
            super().__init__()
            self.title = "President"
            self.initialized = True
            
    @classmethod
    def get_president(cls, a_name):
        inst = cls()
        inst.name = a_name
        return inst

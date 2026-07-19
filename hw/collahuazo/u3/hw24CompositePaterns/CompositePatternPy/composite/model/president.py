from composite.model.supervisor import Supervisor


class President(Supervisor):

    _president = None 

    def __init__(self):
        super().__init__()
        self.title = "President"

    def state_name(self):
        super().state_name()

    @classmethod
    def get_president(cls, a_name):
        if cls._president is None:
            cls._president = President()
        cls._president.name = a_name
        return cls._president

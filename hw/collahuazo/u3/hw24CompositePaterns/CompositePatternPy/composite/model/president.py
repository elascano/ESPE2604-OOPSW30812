from composite.model.supervisor import Supervisor


class President(Supervisor):

    _president = None  # instancia unica (singleton)

    def __init__(self):
        # Constructor "privado" por convencion: usar get_president()
        super().__init__()
        self.title = "President"

    def state_name(self):
        # Do processing special to presidential naming
        super().state_name()

    @classmethod
    def get_president(cls, a_name):
        if cls._president is None:
            cls._president = President()
        cls._president.name = a_name
        return cls._president

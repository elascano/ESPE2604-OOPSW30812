from model.door import Door


class ExitDoor(Door):

    def __init__(self):
        super().__init__(False)
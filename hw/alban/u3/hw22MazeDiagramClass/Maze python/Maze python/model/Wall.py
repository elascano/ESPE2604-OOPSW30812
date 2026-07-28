from .Direction import Direction

class Wall:
    def __init__(self, is_exterior: bool, direction: Direction):
        self.is_exterior: bool = is_exterior
        self.direction: Direction = direction
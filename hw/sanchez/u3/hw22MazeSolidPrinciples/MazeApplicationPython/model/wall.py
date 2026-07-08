class Wall:
    """
    Represents a wall in a room.
    """

    def __init__(self, solid=True):
        self._solid = solid

    @property
    def solid(self):
        return self._solid

    @solid.setter
    def solid(self, solid):
        self._solid = solid

    def __str__(self):
        return f"Wall(solid={self._solid})"
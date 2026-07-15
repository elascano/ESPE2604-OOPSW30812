class Door:
    """
    Base class for all doors.
    """

    def __init__(self, open=False):
        self._open = open

    @property
    def open(self):
        return self._open

    @open.setter
    def open(self, value):
        self._open = value

    def open_door(self):
        self._open = True

    def close_door(self):
        self._open = False

    def __str__(self):
        state = "Open" if self._open else "Closed"
        return f"{self.__class__.__name__}({state})"
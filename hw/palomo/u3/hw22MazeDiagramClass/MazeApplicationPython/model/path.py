class Path:

    def __init__(self):
        self._rooms = []

    @property
    def rooms(self):
        return self._rooms

    def add_room(self, room):
        self._rooms.append(room)

    def __str__(self):
        return " -> ".join(str(room) for room in self._rooms)
from model.path import Path


class Maze:

    def __init__(self, n=0, m=0):
        self._n = n
        self._m = m
        self._rooms = [[None for _ in range(m)] for _ in range(n)]
        self._path = Path()

    @property
    def n(self):
        return self._n

    @property
    def m(self):
        return self._m

    @property
    def rooms(self):
        return self._rooms

    @property
    def path(self):
        return self._path

    def set_room(self, row, column, room):
        self._rooms[row][column] = room

    def get_room(self, row, column):
        return self._rooms[row][column]

    def __str__(self):
        return f"Maze({self._n} x {self._m})"
class Room:

    MAX_DOORS = 3
    MAX_WALLS = 3

    def __init__(self, x=0, y=0):
        self._x = x
        self._y = y
        self._doors = []
        self._walls = []

    @property
    def x(self):
        return self._x

    @property
    def y(self):
        return self._y

    @property
    def doors(self):
        return self._doors

    @property
    def walls(self):
        return self._walls

    def add_door(self, door):
        if len(self._doors) < Room.MAX_DOORS:
            self._doors.append(door)

    def add_wall(self, wall):
        if len(self._walls) < Room.MAX_WALLS:
            self._walls.append(wall)

    def __str__(self):
        return f"Room({self._x}, {self._y})"
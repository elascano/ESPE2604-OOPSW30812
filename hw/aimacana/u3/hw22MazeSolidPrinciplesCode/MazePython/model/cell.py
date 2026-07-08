from model.direction import Direction

class Cell:
    def __init__(self, x: int, y: int):
        self._x = x
        self._y = y
        self._wall_north = True
        self._wall_south = True
        self._wall_east = True
        self._wall_west = True
        self._visited = False

    @property
    def x(self) -> int:
        return self._x

    @property
    def y(self) -> int:
        return self._y

    @property
    def is_visited(self) -> bool:
        return self._visited

    def mark_visited(self):
        self._visited = True

    def set_visited(self, visited: bool):
        self._visited = visited

    def break_wall(self, dir: Direction):
        if dir == Direction.NORTH:
            self._wall_north = False
        elif dir == Direction.SOUTH:
            self._wall_south = False
        elif dir == Direction.EAST:
            self._wall_east = False
        elif dir == Direction.WEST:
            self._wall_west = False

    @property
    def is_wall_north(self) -> bool:
        return self._wall_north

    @property
    def is_wall_south(self) -> bool:
        return self._wall_south

    @property
    def is_wall_east(self) -> bool:
        return self._wall_east

    @property
    def is_wall_west(self) -> bool:
        return self._wall_west

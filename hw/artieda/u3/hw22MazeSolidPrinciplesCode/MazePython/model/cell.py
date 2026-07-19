from model.direction import Direction

class Cell:
    def __init__(self, x: int, y: int):
        self.x = x
        self.y = y
        self.wall_north = True
        self.wall_south = True
        self.wall_east = True
        self.wall_west = True
        self.visited = False

    def is_visited(self) -> bool:
        return self.visited

    def mark_visited(self) -> None:
        self.visited = True

    def set_visited(self, visited: bool) -> None:
        self.visited = visited

    def break_wall(self, direction: Direction) -> None:
        if direction == Direction.NORTH:
            self.wall_north = False
        elif direction == Direction.SOUTH:
            self.wall_south = False
        elif direction == Direction.EAST:
            self.wall_east = False
        elif direction == Direction.WEST:
            self.wall_west = False

    def get_x(self) -> int:
        return self.x

    def get_y(self) -> int:
        return self.y

    def is_wall_north(self) -> bool:
        return self.wall_north

    def is_wall_south(self) -> bool:
        return self.wall_south

    def is_wall_east(self) -> bool:
        return self.wall_east

    def is_wall_west(self) -> bool:
        return self.wall_west

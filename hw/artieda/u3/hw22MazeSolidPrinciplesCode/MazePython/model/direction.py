from enum import Enum

class Direction(Enum):
    NORTH = 1
    SOUTH = 2
    EAST = 3
    WEST = 4

    def get_opposite(self):
        if self == Direction.NORTH:
            return Direction.SOUTH
        elif self == Direction.SOUTH:
            return Direction.NORTH
        elif self == Direction.EAST:
            return Direction.WEST
        elif self == Direction.WEST:
            return Direction.EAST

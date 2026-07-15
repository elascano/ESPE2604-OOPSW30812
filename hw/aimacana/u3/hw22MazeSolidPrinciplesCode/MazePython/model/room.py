from model.direction import Direction

class Room:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.doors = {Direction.NORTH: False, Direction.SOUTH: False, Direction.EAST: False, Direction.WEST: False}
        self.is_entrance = False
        self.is_exit = False

    def add_door(self, direction):
        self.doors[direction] = True

    def has_door(self, direction):
        return self.doors[direction]

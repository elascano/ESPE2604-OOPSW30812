from model.room import Room

class Maze:
    def __init__(self, width, height):
        self.width = width
        self.height = height
        self.grid = [[Room(x, y) for y in range(height)] for x in range(width)]

    def get_room(self, x, y):
        return self.grid[x][y]

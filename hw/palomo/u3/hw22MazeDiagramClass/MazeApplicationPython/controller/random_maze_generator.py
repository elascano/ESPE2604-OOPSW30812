from controller.maze_generator import MazeGenerator
from model.room import Room


class RandomMazeGenerator(MazeGenerator):

    def __init__(self, maze):
        self._maze = maze

    def generate_maze(self):

        for i in range(self._maze.n):
            for j in range(self._maze.m):
                self._maze.set_room(i, j, Room(i, j))

        return self._maze

    def validate_maze(self):
        return True

    def create_rooms(self):
        pass

    def assign_doors(self):
        pass

    def assign_walls(self):
        pass

    def generate_unique_path(self):
        pass
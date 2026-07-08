from model.maze import Maze
from controller.random_maze_generator import RandomMazeGenerator


class MazeController:

    def __init__(self):
        self._maze = None

    def create_maze(self, n, m):
        self._maze = Maze(n, m)
        generator = RandomMazeGenerator(self._maze)
        generator.generate_maze()

    def initialize_maze(self):
        pass

    def get_maze(self):
        return self._maze

    def draw_maze(self):
        drawing = ""

        for row in self._maze.rooms:
            for room in row:
                drawing += "[ ]"
            drawing += "\n"

        return drawing
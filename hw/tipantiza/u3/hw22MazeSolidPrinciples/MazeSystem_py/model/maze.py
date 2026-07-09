from model.abstract_maze import AbstractMaze
from generator.maze_generator import MazeGenerator


class Maze(AbstractMaze):

    def __init__(self, width=5, height=5, generator=None):
        super().__init__(width, height)

        if generator is None:
            generator = MazeGenerator()

        self.generator = generator

    def generate(self):
        if self.generator is not None:
            self.generator.generate_maze(self)

    def set_generator(self, generator):
        self.generator = generator

    def get_generator(self):
        return self.generator
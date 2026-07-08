from model.maze import Maze
from generator.maze_generator import MazeGenerator


class MazeController:

    def __init__(self, renderer, model=None):
        self.renderer = renderer

        if model is None:
            self.current_width = 5
            self.current_height = 5
            self.model = Maze(
                self.current_width,
                self.current_height,
                MazeGenerator()
            )
        else:
            self.model = model
            self.current_width = model.get_width()
            self.current_height = model.get_height()

    def set_renderer(self, renderer):
        self.renderer = renderer

    def init_maze_generation(self, width, height):
        self.current_width = width
        self.current_height = height

        maze = Maze(
            width,
            height,
            MazeGenerator()
        )

        maze.generate()

        self.model = maze

        if self.renderer is not None:
            self.renderer.render(maze)

    def render_maze(self):
        if self.renderer is not None and self.model is not None:
            self.renderer.render(self.model)

    def get_model(self):
        return self.model

    def get_renderer(self):
        return self.renderer

    def set_model(self, model):
        self.model = model

        if model is not None:
            self.current_width = model.get_width()
            self.current_height = model.get_height()

    def get_current_width(self):
        return self.current_width

    def get_current_height(self):
        return self.current_height
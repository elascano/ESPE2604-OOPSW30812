from model.maze import Maze
from service.generator import IMazeGenerator
from service.solver import IMazeSolver
from view.renderer import IMazeRenderer

class MazeController:
    def __init__(self, generator: IMazeGenerator, solver: IMazeSolver, renderer: IMazeRenderer):
        self.generator = generator
        self.solver = solver
        self.renderer = renderer

    def create_and_show_maze(self, width: int, height: int) -> None:
        maze = Maze(width, height)
        self.generator.generate(maze)
        path = self.solver.find_path(maze)
        self.renderer.draw(maze, path)

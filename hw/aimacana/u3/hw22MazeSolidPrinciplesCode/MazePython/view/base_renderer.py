from model.maze import Maze
from view.i_maze_renderer import IMazeRenderer

class BaseRenderer(IMazeRenderer):
    def draw(self, maze: Maze, path: list):
        if not self.validate_maze(maze):
            raise ValueError("Invalid Maze")

    def validate_maze(self, maze: Maze) -> bool:
        return maze is not None and maze.width > 0 and maze.height > 0 and maze.grid is not None

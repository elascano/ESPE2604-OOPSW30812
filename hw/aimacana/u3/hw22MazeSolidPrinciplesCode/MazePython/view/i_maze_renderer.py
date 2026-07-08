from abc import ABC, abstractmethod
from model.maze import Maze

class IMazeRenderer(ABC):
    @abstractmethod
    def draw(self, maze: Maze, path: list):
        pass

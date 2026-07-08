from abc import ABC, abstractmethod
from model.maze import Maze

class IMazeSolver(ABC):
    @abstractmethod
    def find_path(self, maze: Maze) -> list:
        pass

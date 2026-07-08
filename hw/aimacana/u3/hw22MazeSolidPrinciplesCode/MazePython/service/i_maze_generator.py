from abc import ABC, abstractmethod
from model.maze import Maze

class IMazeGenerator(ABC):
    @abstractmethod
    def generate(self, maze: Maze):
        pass

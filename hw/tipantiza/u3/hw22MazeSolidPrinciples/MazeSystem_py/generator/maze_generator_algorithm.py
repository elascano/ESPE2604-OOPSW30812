from abc import ABC, abstractmethod


class MazeGeneratorAlgorithm(ABC):

    @abstractmethod
    def generate_maze(self, maze):
        pass
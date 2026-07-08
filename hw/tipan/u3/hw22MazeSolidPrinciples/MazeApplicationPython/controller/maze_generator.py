from abc import ABC, abstractmethod


class MazeGenerator(ABC):

    @abstractmethod
    def generate_maze(self):
        pass

    @abstractmethod
    def validate_maze(self):
        pass
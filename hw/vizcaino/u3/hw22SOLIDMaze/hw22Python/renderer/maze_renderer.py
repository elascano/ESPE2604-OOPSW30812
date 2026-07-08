from abc import ABC, abstractmethod


class MazeRenderer(ABC):

    @abstractmethod
    def render(self, maze):
        pass
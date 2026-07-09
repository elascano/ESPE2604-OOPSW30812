from __future__ import annotations

from abc import ABC, abstractmethod

from ..model import Maze


class IMazeGenerator(ABC):

    @abstractmethod
    def generate_maze(self, maze: Maze) -> None:
        ...

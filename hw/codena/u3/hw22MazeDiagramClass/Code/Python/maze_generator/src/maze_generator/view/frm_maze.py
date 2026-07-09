from __future__ import annotations

from abc import ABC, abstractmethod

from ..model import Maze


class FrmMaze(ABC):

    @abstractmethod
    def render(self, maze: Maze) -> str:
        ...

from __future__ import annotations

from abc import ABC, abstractmethod
from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from ..view.frm_maze import FrmMaze


class IDraw(ABC):

    @abstractmethod
    def draw_maze(self) -> "FrmMaze":
        ...

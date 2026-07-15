from __future__ import annotations

from typing import TYPE_CHECKING

from .console_maze import ConsoleMaze
from .frm_gui_maze import FrmGUIMaze
from .frm_maze import FrmMaze
from .maze_view_type import MazeViewType

if TYPE_CHECKING:
    from ..controller.maze_generator_controller import MazeGeneratorController


class FrmMazeGenerator:

    def __init__(
        self,
        rows: int,
        columns: int,
        type_of_maze: MazeViewType = MazeViewType.CONSOLE,
    ) -> None:
        self._rows = rows
        self._columns = columns
        self._type_of_maze = type_of_maze

    @property
    def rows(self) -> int:
        return self._rows

    @property
    def columns(self) -> int:
        return self._columns

    @property
    def type_of_maze(self) -> MazeViewType:
        return self._type_of_maze

    @type_of_maze.setter
    def type_of_maze(self, value: MazeViewType) -> None:
        self._type_of_maze = value

    def create_view(self) -> FrmMaze:
        if self._type_of_maze is MazeViewType.GUI:
            return FrmGUIMaze()
        return ConsoleMaze()

    def generate(self, controller: "MazeGeneratorController") -> FrmMaze:
        return controller.select_type_of_maze(self)

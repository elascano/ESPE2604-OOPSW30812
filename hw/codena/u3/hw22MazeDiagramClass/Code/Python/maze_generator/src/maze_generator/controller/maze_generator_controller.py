from __future__ import annotations

from typing import Optional, TYPE_CHECKING

from ..model import Maze
from .i_draw import IDraw
from .i_maze_generator import IMazeGenerator
from .maze_controller import MazeController

if TYPE_CHECKING:
    from ..view.frm_maze import FrmMaze
    from ..view.frm_maze_generator import FrmMazeGenerator


class MazeGeneratorController(IDraw):

    def __init__(
        self,
        maze_generator: IMazeGenerator,
        maze_controller: MazeController,
    ) -> None:
        self._maze_generator = maze_generator
        self._maze_controller = maze_controller
        self._maze: Optional[Maze] = None
        self._view: Optional["FrmMaze"] = None

    def select_type_of_maze(self, frm_maze: "FrmMazeGenerator") -> "FrmMaze":
        maze = Maze(frm_maze.rows, frm_maze.columns)
        self._maze_generator.generate_maze(maze)
        self._maze_controller.validate_path(maze)
        self._maze = maze
        self._view = frm_maze.create_view()
        return self.draw_maze()

    def draw_maze(self) -> "FrmMaze":
        if self._maze is None or self._view is None:
            raise ValueError("A maze must be generated before drawing it.")
        self._view.render(self._maze)
        return self._view

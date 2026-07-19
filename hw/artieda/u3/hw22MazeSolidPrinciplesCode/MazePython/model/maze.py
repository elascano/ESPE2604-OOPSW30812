from typing import List, Optional
from model.cell import Cell

class Maze:
    def __init__(self, width: int, height: int):
        if width <= 0 or height <= 0:
            raise ValueError()
        self.width = width
        self.height = height
        self.grid: List[List[Cell]] = [
            [Cell(x, y) for x in range(width)] for y in range(height)
        ]
        self.entrance: Optional[Cell] = None
        self.exit: Optional[Cell] = None

    def get_cell(self, x: int, y: int) -> Optional[Cell]:
        if x < 0 or x >= self.width or y < 0 or y >= self.height:
            return None
        return self.grid[y][x]

    def configure_entrance_exit(self, entrance: Cell, exit_cell: Cell) -> None:
        self.entrance = entrance
        self.exit = exit_cell

    def get_entrance(self) -> Optional[Cell]:
        return self.entrance

    def get_exit(self) -> Optional[Cell]:
        return self.exit

    def get_width(self) -> int:
        return self.width

    def get_height(self) -> int:
        return self.height

    def get_grid(self) -> List[List[Cell]]:
        return self.grid

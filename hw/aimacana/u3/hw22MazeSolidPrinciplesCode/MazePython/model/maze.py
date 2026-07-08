from model.cell import Cell

class Maze:
    def __init__(self, width: int, height: int):
        if width <= 0 or height <= 0:
            raise ValueError("Dimensions must be positive")
        self._width = width
        self._height = height
        self._grid = [[Cell(x, y) for x in range(width)] for y in range(height)]
        self._entrance = None
        self._exit = None

    def get_cell(self, x: int, y: int) -> Cell:
        if x < 0 or x >= self._width or y < 0 or y >= self._height:
            return None
        return self._grid[y][x]

    def configure_entrance_exit(self, entrance: Cell, exit: Cell):
        self._entrance = entrance
        self._exit = exit

    @property
    def entrance(self) -> Cell:
        return self._entrance

    @property
    def exit(self) -> Cell:
        return self._exit

    @property
    def width(self) -> int:
        return self._width

    @property
    def height(self) -> int:
        return self._height

    @property
    def grid(self) -> list:
        return self._grid

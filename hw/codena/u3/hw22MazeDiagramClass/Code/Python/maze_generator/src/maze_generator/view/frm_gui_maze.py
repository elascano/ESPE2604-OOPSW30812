from __future__ import annotations

from ..model import CardinalDirection, Coordinate, Maze
from .frm_maze import FrmMaze

_CELL_SIZE = 28
_MARGIN = 20


class FrmGUIMaze(FrmMaze):

    def __init__(self, *, block: bool = True) -> None:
        self._block = block

    def render(self, maze: Maze) -> str:
        import tkinter as tk

        window = tk.Tk()
        window.title("Maze Generator")
        canvas = self._create_canvas(tk, window, maze)
        self._draw_rooms(maze, canvas)
        self._draw_path(maze, canvas)
        if self._block:
            window.mainloop()
        else:
            window.update()
        return f"GUI maze rendered ({maze.columns}x{maze.rows})."

    def _create_canvas(self, tk, window, maze: Maze):
        width = maze.columns * _CELL_SIZE + 2 * _MARGIN
        height = maze.rows * _CELL_SIZE + 2 * _MARGIN
        canvas = tk.Canvas(window, width=width, height=height, background="white")
        canvas.pack()
        return canvas

    def _draw_rooms(self, maze: Maze, canvas) -> None:
        for y in range(maze.rows):
            for x in range(maze.columns):
                self._draw_room_walls(maze, canvas, Coordinate(x, y))

    def _draw_room_walls(self, maze: Maze, canvas, coordinate: Coordinate) -> None:
        room = maze.get_room(coordinate)
        left = _MARGIN + coordinate.x * _CELL_SIZE
        top = _MARGIN + coordinate.y * _CELL_SIZE
        right = left + _CELL_SIZE
        bottom = top + _CELL_SIZE
        edges = {
            CardinalDirection.NORTH: (left, top, right, top),
            CardinalDirection.SOUTH: (left, bottom, right, bottom),
            CardinalDirection.WEST: (left, top, left, bottom),
            CardinalDirection.EAST: (right, top, right, bottom),
        }
        for direction, coordinates in edges.items():
            if not room.has_door_towards(direction):
                canvas.create_line(*coordinates, width=2)

    def _draw_path(self, maze: Maze, canvas) -> None:
        if maze.path.is_empty:
            return
        points = []
        for step in maze.path.steps:
            points.append(_MARGIN + step.x * _CELL_SIZE + _CELL_SIZE / 2)
            points.append(_MARGIN + step.y * _CELL_SIZE + _CELL_SIZE / 2)
        if len(points) >= 4:
            canvas.create_line(*points, fill="red", width=2)

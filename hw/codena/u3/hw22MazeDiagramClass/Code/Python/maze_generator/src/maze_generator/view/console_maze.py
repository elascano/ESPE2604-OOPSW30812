from __future__ import annotations

from ..model import CardinalDirection, Coordinate, Maze
from .frm_maze import FrmMaze

_CELL_WIDTH = 3


class ConsoleMaze(FrmMaze):

    def render(self, maze: Maze) -> str:
        drawing = self._build_drawing(maze)
        print(drawing)
        return drawing

    def _build_drawing(self, maze: Maze) -> str:
        lines = []
        for y in range(maze.rows):
            lines.append(self._top_border(maze, y))
            lines.append(self._room_line(maze, y))
        lines.append(self._bottom_border(maze))
        return "\n".join(lines)

    def _top_border(self, maze: Maze, y: int) -> str:
        segments = []
        for x in range(maze.columns):
            room = maze.get_room(Coordinate(x, y))
            opening = room.has_door_towards(CardinalDirection.NORTH)
            segments.append("+" + (" " * _CELL_WIDTH if opening else "-" * _CELL_WIDTH))
        return "".join(segments) + "+"

    def _bottom_border(self, maze: Maze) -> str:
        segments = []
        last_row = maze.rows - 1
        for x in range(maze.columns):
            room = maze.get_room(Coordinate(x, last_row))
            opening = room.has_door_towards(CardinalDirection.SOUTH)
            segments.append("+" + (" " * _CELL_WIDTH if opening else "-" * _CELL_WIDTH))
        return "".join(segments) + "+"

    def _room_line(self, maze: Maze, y: int) -> str:
        segments = []
        for x in range(maze.columns):
            coordinate = Coordinate(x, y)
            room = maze.get_room(coordinate)
            west_open = room.has_door_towards(CardinalDirection.WEST)
            segments.append((" " if west_open else "|") + self._cell_content(maze, coordinate))
        last_room = maze.get_room(Coordinate(maze.columns - 1, y))
        east_open = last_room.has_door_towards(CardinalDirection.EAST)
        return "".join(segments) + (" " if east_open else "|")

    def _cell_content(self, maze: Maze, coordinate: Coordinate) -> str:
        if coordinate == maze.entrance:
            marker = "S"
        elif coordinate == maze.exit:
            marker = "E"
        elif maze.path.contains(coordinate):
            marker = "."
        else:
            marker = " "
        return marker.center(_CELL_WIDTH)

from __future__ import annotations

from typing import Dict, Iterable, Optional

from .coordinate import Coordinate
from .path import Path
from .room import Room


class Maze:

    def __init__(self, rows: int, columns: int) -> None:
        if rows <= 0 or columns <= 0:
            raise ValueError("A maze needs at least one row and one column.")
        self._rows = rows
        self._columns = columns
        self._rooms: Dict[Coordinate, Room] = {
            Coordinate(x, y): Room(Coordinate(x, y))
            for y in range(rows)
            for x in range(columns)
        }
        self._path = Path()
        self._entrance: Optional[Coordinate] = None
        self._exit: Optional[Coordinate] = None

    @property
    def rows(self) -> int:
        return self._rows

    @property
    def columns(self) -> int:
        return self._columns

    @property
    def path(self) -> Path:
        return self._path

    @property
    def entrance(self) -> Optional[Coordinate]:
        return self._entrance

    @entrance.setter
    def entrance(self, coordinate: Coordinate) -> None:
        self._require_within_bounds(coordinate)
        self._entrance = coordinate

    @property
    def exit(self) -> Optional[Coordinate]:
        return self._exit

    @exit.setter
    def exit(self, coordinate: Coordinate) -> None:
        self._require_within_bounds(coordinate)
        self._exit = coordinate

    def rooms(self) -> Iterable[Room]:
        return self._rooms.values()

    def get_room(self, coordinate: Coordinate) -> Room:
        self._require_within_bounds(coordinate)
        return self._rooms[coordinate]

    def is_within_bounds(self, coordinate: Coordinate) -> bool:
        return 0 <= coordinate.x < self._columns and 0 <= coordinate.y < self._rows

    def _require_within_bounds(self, coordinate: Coordinate) -> None:
        if not self.is_within_bounds(coordinate):
            raise ValueError(f"{coordinate!r} is outside the maze bounds.")

    def __repr__(self) -> str:
        return f"Maze(rows={self._rows}, columns={self._columns})"

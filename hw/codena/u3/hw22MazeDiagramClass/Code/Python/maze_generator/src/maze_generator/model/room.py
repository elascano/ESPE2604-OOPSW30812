from __future__ import annotations

from typing import Dict, List, Optional

from .cardinal_direction import CardinalDirection
from .coordinate import Coordinate
from .door import Door
from .wall import Wall


class Room:

    def __init__(self, coordinate: Coordinate) -> None:
        self._coordinate = coordinate
        self._doors: Dict[CardinalDirection, Door] = {}
        self._walls: Dict[CardinalDirection, Wall] = {}

    @property
    def coordinate(self) -> Coordinate:
        return self._coordinate

    @property
    def doors(self) -> List[Door]:
        return list(self._doors.values())

    @property
    def walls(self) -> List[Wall]:
        return list(self._walls.values())

    def add_door(self, door: Door) -> None:
        direction = door.cardinal_direction
        self._walls.pop(direction, None)
        self._doors[direction] = door

    def add_wall(self, wall: Wall) -> None:
        direction = wall.cardinal_direction
        if direction in self._doors:
            return
        self._walls[direction] = wall

    def has_door_towards(self, direction: CardinalDirection) -> bool:
        return direction in self._doors

    def door_towards(self, direction: CardinalDirection) -> Optional[Door]:
        return self._doors.get(direction)

    def __repr__(self) -> str:
        return f"Room({self._coordinate.x}, {self._coordinate.y})"

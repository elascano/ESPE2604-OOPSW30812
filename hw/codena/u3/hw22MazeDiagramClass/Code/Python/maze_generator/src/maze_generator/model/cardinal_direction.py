from __future__ import annotations

from enum import Enum
from typing import Tuple


class CardinalDirection(Enum):

    NORTH = "NORTH"
    SOUTH = "SOUTH"
    EAST = "EAST"
    WEST = "WEST"

    @property
    def is_horizontal_line(self) -> bool:
        return self in (CardinalDirection.NORTH, CardinalDirection.SOUTH)

    @property
    def opposite(self) -> "CardinalDirection":
        return _OPPOSITES[self]

    @property
    def offset(self) -> Tuple[int, int]:
        return _OFFSETS[self]


_OPPOSITES = {
    CardinalDirection.NORTH: CardinalDirection.SOUTH,
    CardinalDirection.SOUTH: CardinalDirection.NORTH,
    CardinalDirection.EAST: CardinalDirection.WEST,
    CardinalDirection.WEST: CardinalDirection.EAST,
}

_OFFSETS = {
    CardinalDirection.NORTH: (0, -1),
    CardinalDirection.SOUTH: (0, 1),
    CardinalDirection.EAST: (1, 0),
    CardinalDirection.WEST: (-1, 0),
}

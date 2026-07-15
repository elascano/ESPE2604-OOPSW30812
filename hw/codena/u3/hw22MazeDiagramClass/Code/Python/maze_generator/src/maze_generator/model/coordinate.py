from __future__ import annotations

from dataclasses import dataclass

from .cardinal_direction import CardinalDirection


@dataclass(frozen=True)
class Coordinate:

    x: int
    y: int

    def translated(self, direction: CardinalDirection) -> "Coordinate":
        dx, dy = direction.offset
        return Coordinate(self.x + dx, self.y + dy)

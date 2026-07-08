from __future__ import annotations

from .cardinal_direction import CardinalDirection


class Wall:

    def __init__(
        self,
        cardinal_direction: CardinalDirection,
        horizontal_line: bool | None = None,
    ) -> None:
        self._cardinal_direction = cardinal_direction
        self._horizontal_line = (
            cardinal_direction.is_horizontal_line
            if horizontal_line is None
            else horizontal_line
        )

    @property
    def cardinal_direction(self) -> CardinalDirection:
        return self._cardinal_direction

    @property
    def horizontal_line(self) -> bool:
        return self._horizontal_line

    def __repr__(self) -> str:
        return f"Wall({self._cardinal_direction.name})"

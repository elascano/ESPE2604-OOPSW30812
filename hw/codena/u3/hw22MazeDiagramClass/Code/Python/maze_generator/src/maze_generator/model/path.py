from __future__ import annotations

from typing import List

from .coordinate import Coordinate


class Path:

    def __init__(self) -> None:
        self._steps: List[Coordinate] = []

    @property
    def steps(self) -> List[Coordinate]:
        return list(self._steps)

    @property
    def length(self) -> int:
        return len(self._steps)

    @property
    def is_empty(self) -> bool:
        return not self._steps

    def add_step(self, coordinate: Coordinate) -> None:
        self._steps.append(coordinate)

    def contains(self, coordinate: Coordinate) -> bool:
        return coordinate in self._steps

    def reset(self) -> None:
        self._steps.clear()

    def __repr__(self) -> str:
        return f"Path(length={self.length})"

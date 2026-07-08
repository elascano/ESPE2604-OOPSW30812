from __future__ import annotations

from .door import Door


class AdjacentDoor(Door):

    @property
    def symbol(self) -> str:
        return " "

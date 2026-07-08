from __future__ import annotations

from .door import Door


class EntranceDoor(Door):

    @property
    def symbol(self) -> str:
        return "S"

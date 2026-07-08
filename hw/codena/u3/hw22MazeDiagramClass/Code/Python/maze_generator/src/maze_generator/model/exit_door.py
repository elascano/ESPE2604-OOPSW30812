from __future__ import annotations

from .door import Door


class ExitDoor(Door):

    @property
    def symbol(self) -> str:
        return "E"

from abc import ABC, abstractmethod
from typing import Optional
from .Direction import Direction

class Door(ABC):
    def __init__(self, room1: 'Room', room2: Optional['Room'], direction: Direction):
        self.room1: 'Room' = room1
        self.room2: Optional['Room'] = room2
        self.direction: Direction = direction

    @abstractmethod
    def open(self) -> None:
        pass
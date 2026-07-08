from .Direction import Direction
from .Room import Room

class Player:
    def __init__(self, starting_room: Room):
        self.current_room: Room = starting_room

    def move(self, direction: Direction) -> None:
        print(f"The player moves towards the: {direction.value}")
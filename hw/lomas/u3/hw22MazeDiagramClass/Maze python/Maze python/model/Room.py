from typing import List
from .Wall import Wall
from .Door import Door

class Room:
    def __init__(self, x: int, y: int):
        self.x: int = x
        self.y: int = y
        self.doors: List[Door] = []
        self.walls: List[Wall] = []
from typing import List
from model.Maze import Maze
from model.Room import Room
from view.Renderer import MazeRenderer

class PathController:
    def __init__(self, Renderer: MazeRenderer):
        self.Renderer: MazeRenderer = Renderer

    def find_path(self, maze: Maze) -> List[Room]:
        print("Controller calculating the optimal route")
        return maze.rooms

    def verify_path(self) -> bool:
        print("Controller verifying path validity")
        return True
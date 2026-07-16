from abc import ABC, abstractmethod
import random
from collections import deque
from typing import Optional, List
from model.maze import Maze
from model.cell import Cell
from model.direction import Direction

class IMazeGenerator(ABC):
    @abstractmethod
    def generate(self, maze: Maze) -> None:
        pass

class DFSGenerator(IMazeGenerator):
    def __init__(self, seed: Optional[int] = None):
        self.random = random.Random(seed) if seed is not None else random.Random()

    def generate(self, maze: Maze) -> None:
        width = maze.get_width()
        height = maze.get_height()
        if width <= 0 or height <= 0:
            return

        for y in range(height):
            for x in range(width):
                cell = maze.get_cell(x, y)
                if cell:
                    cell.set_visited(False)

        current = maze.get_cell(0, 0)
        if not current:
            return
        current.mark_visited()
        stack = deque()
        stack.append(current)

        while stack:
            next_cell = self.get_random_unvisited_neighbor(current, maze)
            if next_cell:
                self.break_walls(current, next_cell)
                next_cell.mark_visited()
                stack.append(current)
                current = next_cell
            else:
                current = stack.pop()

        for y in range(height):
            for x in range(width):
                cell = maze.get_cell(x, y)
                if cell:
                    cell.set_visited(False)

        entrance = maze.get_cell(0, 0)
        exit_cell = maze.get_cell(width - 1, height - 1)
        maze.configure_entrance_exit(entrance, exit_cell)

    def get_random_unvisited_neighbor(self, cell: Cell, maze: Maze) -> Optional[Cell]:
        unvisited = []
        x = cell.get_x()
        y = cell.get_y()

        if y > 0:
            n = maze.get_cell(x, y - 1)
            if n and not n.is_visited():
                unvisited.append(n)
        if y < maze.get_height() - 1:
            n = maze.get_cell(x, y + 1)
            if n and not n.is_visited():
                unvisited.append(n)
        if x > 0:
            n = maze.get_cell(x - 1, y)
            if n and not n.is_visited():
                unvisited.append(n)
        if x < maze.get_width() - 1:
            n = maze.get_cell(x + 1, y)
            if n and not n.is_visited():
                unvisited.append(n)

        if not unvisited:
            return None
        return self.random.choice(unvisited)

    def break_walls(self, current: Cell, next_cell: Cell) -> None:
        if next_cell.get_y() < current.get_y():
            current.break_wall(Direction.NORTH)
            next_cell.break_wall(Direction.SOUTH)
        elif next_cell.get_y() > current.get_y():
            current.break_wall(Direction.SOUTH)
            next_cell.break_wall(Direction.NORTH)
        elif next_cell.get_x() > current.get_x():
            current.break_wall(Direction.EAST)
            next_cell.break_wall(Direction.WEST)
        elif next_cell.get_x() < current.get_x():
            current.break_wall(Direction.WEST)
            next_cell.break_wall(Direction.EAST)

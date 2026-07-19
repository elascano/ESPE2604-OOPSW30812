from abc import ABC, abstractmethod
from collections import deque
from typing import List
from model.maze import Maze
from model.cell import Cell

class IMazeSolver(ABC):
    @abstractmethod
    def find_path(self, maze: Maze) -> List[Cell]:
        pass

class DFSSolver(IMazeSolver):
    def find_path(self, maze: Maze) -> List[Cell]:
        width = maze.get_width()
        height = maze.get_height()
        if width <= 0 or height <= 0:
            return []

        entrance = maze.get_entrance()
        exit_cell = maze.get_exit()
        if not entrance or not exit_cell:
            return []

        visited = [[False] * width for _ in range(height)]
        parent = [[None] * width for _ in range(height)]

        stack = deque()
        stack.append(entrance)
        visited[entrance.get_y()][entrance.get_x()] = True

        found = False
        while stack:
            current = stack.pop()

            if current == exit_cell:
                found = True
                break

            x = current.get_x()
            y = current.get_y()

            if not current.is_wall_north() and y > 0:
                next_cell = maze.get_cell(x, y - 1)
                if next_cell and not visited[next_cell.get_y()][next_cell.get_x()]:
                    visited[next_cell.get_y()][next_cell.get_x()] = True
                    parent[next_cell.get_y()][next_cell.get_x()] = current
                    stack.append(next_cell)

            if not current.is_wall_south() and y < height - 1:
                next_cell = maze.get_cell(x, y + 1)
                if next_cell and not visited[next_cell.get_y()][next_cell.get_x()]:
                    visited[next_cell.get_y()][next_cell.get_x()] = True
                    parent[next_cell.get_y()][next_cell.get_x()] = current
                    stack.append(next_cell)

            if not current.is_wall_east() and x < width - 1:
                next_cell = maze.get_cell(x + 1, y)
                if next_cell and not visited[next_cell.get_y()][next_cell.get_x()]:
                    visited[next_cell.get_y()][next_cell.get_x()] = True
                    parent[next_cell.get_y()][next_cell.get_x()] = current
                    stack.append(next_cell)

            if not current.is_wall_west() and x > 0:
                next_cell = maze.get_cell(x - 1, y)
                if next_cell and not visited[next_cell.get_y()][next_cell.get_x()]:
                    visited[next_cell.get_y()][next_cell.get_x()] = True
                    parent[next_cell.get_y()][next_cell.get_x()] = current
                    stack.append(next_cell)

        if not found:
            return []

        path = []
        curr = exit_cell
        while curr is not None:
            path.append(curr)
            curr = parent[curr.get_y()][curr.get_x()]

        path.reverse()
        return path

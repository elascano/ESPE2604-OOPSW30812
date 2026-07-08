from __future__ import annotations

from collections import deque
from typing import Dict, Optional

from ..model import Coordinate, Maze


class MazeController:

    def __init__(self) -> None:
        self._maze: Optional[Maze] = None

    def validate_path(self, maze: Maze) -> bool:
        self._maze = maze
        return self.connect_start_with_end()

    def connect_start_with_end(self) -> bool:
        if self._maze is None:
            raise ValueError("No maze has been provided to validate.")
        maze = self._maze
        maze.path.reset()
        if maze.entrance is None or maze.exit is None:
            return False

        came_from = self._breadth_first_search(maze)
        if maze.exit not in came_from:
            return False

        self._rebuild_path(maze, came_from)
        return True

    def _breadth_first_search(self, maze: Maze) -> Dict[Coordinate, Optional[Coordinate]]:
        start = maze.entrance
        goal = maze.exit
        came_from: Dict[Coordinate, Optional[Coordinate]] = {start: None}
        queue = deque([start])
        while queue:
            current = queue.popleft()
            if current == goal:
                break
            for door in maze.get_room(current).doors:
                neighbour = current.translated(door.cardinal_direction)
                if maze.is_within_bounds(neighbour) and neighbour not in came_from:
                    came_from[neighbour] = current
                    queue.append(neighbour)
        return came_from

    def _rebuild_path(
        self, maze: Maze, came_from: Dict[Coordinate, Optional[Coordinate]]
    ) -> None:
        reversed_steps = []
        step: Optional[Coordinate] = maze.exit
        while step is not None:
            reversed_steps.append(step)
            step = came_from[step]
        for coordinate in reversed(reversed_steps):
            maze.path.add_step(coordinate)

from __future__ import annotations

import random
from typing import List, Tuple

from ..model import (
    AdjacentDoor,
    CardinalDirection,
    Coordinate,
    EntranceDoor,
    ExitDoor,
    Maze,
    Wall,
)
from .i_maze_generator import IMazeGenerator


class RandomGenerator(IMazeGenerator):

    def __init__(self, rng: random.Random | None = None) -> None:
        self._rng = rng or random.Random()

    def generate_maze(self, maze: Maze) -> None:
        self._carve_passages(maze)
        self._close_remaining_sides(maze)
        self._place_entrance_and_exit(maze)

    def _carve_passages(self, maze: Maze) -> None:
        start = Coordinate(0, 0)
        visited = {start}
        stack = [start]
        while stack:
            current = stack[-1]
            neighbours = self._unvisited_neighbours(maze, current, visited)
            if not neighbours:
                stack.pop()
                continue
            direction, neighbour = self._rng.choice(neighbours)
            maze.get_room(current).add_door(AdjacentDoor(direction))
            maze.get_room(neighbour).add_door(AdjacentDoor(direction.opposite))
            visited.add(neighbour)
            stack.append(neighbour)

    def _unvisited_neighbours(
        self, maze: Maze, coordinate: Coordinate, visited: set
    ) -> List[Tuple[CardinalDirection, Coordinate]]:
        neighbours = []
        for direction in CardinalDirection:
            neighbour = coordinate.translated(direction)
            if maze.is_within_bounds(neighbour) and neighbour not in visited:
                neighbours.append((direction, neighbour))
        return neighbours

    def _close_remaining_sides(self, maze: Maze) -> None:
        for room in maze.rooms():
            for direction in CardinalDirection:
                if not room.has_door_towards(direction):
                    room.add_wall(Wall(direction))

    def _place_entrance_and_exit(self, maze: Maze) -> None:
        entrance = Coordinate(0, 0)
        exit_ = Coordinate(maze.columns - 1, maze.rows - 1)
        maze.get_room(entrance).add_door(EntranceDoor(CardinalDirection.WEST))
        maze.get_room(exit_).add_door(ExitDoor(CardinalDirection.EAST))
        maze.entrance = entrance
        maze.exit = exit_

import random
from typing import List, Optional
from model.Direction import Direction
from model.Room import Room
from model.Wall import Wall
from model.StandardDoor import StandardDoor
from model.EntranceDoor import EntranceDoor
from model.ExitDoor import ExitDoor
from model.Player import Player

class Maze:
    def __init__(self):
        self.width: int = 0
        self.height: int = 0
        self.rooms: List[Room] = []
        self.player: Optional[Player] = None

    def generate(self, width: int, height: int) -> None:
        self.width = width
        self.height = height
        
        room_grid = [[Room(x, y) for x in range(width)] for y in range(height)]
        self.rooms = [room for row in room_grid for room in row]

        for y in range(height):
            for x in range(width):
                r = room_grid[y][x]
                r.walls = [
                    Wall(is_exterior=(y == 0), direction=Direction.NORTH),
                    Wall(is_exterior=(y == height - 1), direction=Direction.SOUTH),
                    Wall(is_exterior=(x == width - 1), direction=Direction.EAST),
                    Wall(is_exterior=(x == 0), direction=Direction.WEST)
                ]

        visited = set()
        
        def carve_path(cx: int, cy: int):
            visited.add((cx, cy))
            moves = [
                (Direction.NORTH, 0, -1, Direction.SOUTH),
                (Direction.SOUTH, 0, 1, Direction.NORTH),
                (Direction.EAST, 1, 0, Direction.WEST),
                (Direction.WEST, -1, 0, Direction.EAST)
            ]
            random.shuffle(moves)

            for direction, dx, dy, opp_direction in moves:
                nx, ny = cx + dx, cy + dy
                if 0 <= nx < width and 0 <= ny < height and (nx, ny) not in visited:
                    current_room = room_grid[cy][cx]
                    next_room = room_grid[ny][nx]

                    current_room.walls = [w for w in current_room.walls if w.direction != direction]
                    next_room.walls = [w for w in next_room.walls if w.direction != opp_direction]

                    door = StandardDoor(current_room, next_room, direction)
                    current_room.doors.append(door)
                    
                    carve_path(nx, ny)

        carve_path(0, 0)

        entrance_room = room_grid[0][0]
        entrance_room.walls = [w for w in entrance_room.walls if w.direction != Direction.NORTH]
        entrance_room.doors.append(EntranceDoor(entrance_room, None, Direction.NORTH))

        exit_room = room_grid[height - 1][width - 1]
        exit_room.walls = [w for w in exit_room.walls if w.direction != Direction.SOUTH]
        exit_room.doors.append(ExitDoor(exit_room, None, Direction.SOUTH))

        if self.rooms:
            self.player = Player(room_grid[0][0])
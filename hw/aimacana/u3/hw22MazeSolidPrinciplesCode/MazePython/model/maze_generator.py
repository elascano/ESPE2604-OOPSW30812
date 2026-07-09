import random
from model.direction import Direction
from model.maze import Maze

class IMazeGenerator:
    def generate(self, width, height):
        pass

class BacktrackingMazeGenerator(IMazeGenerator):
    def generate(self, width, height):
        maze = Maze(width, height)
        visited = [[False]*height for _ in range(width)]
        self._carve(0, 0, maze, visited)
        
        maze.get_room(0, 0).is_entrance = True
        maze.get_room(0, 0).add_door(Direction.NORTH)
        maze.get_room(width-1, height-1).is_exit = True
        maze.get_room(width-1, height-1).add_door(Direction.SOUTH)
        return maze

    def _carve(self, cx, cy, maze, visited):
        visited[cx][cy] = True
        directions = [Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST]
        random.shuffle(directions)
        
        for d in directions:
            nx, ny = cx, cy
            if d == Direction.NORTH: ny -= 1
            elif d == Direction.SOUTH: ny += 1
            elif d == Direction.EAST: nx += 1
            elif d == Direction.WEST: nx -= 1
            
            if 0 <= nx < maze.width and 0 <= ny < maze.height and not visited[nx][ny]:
                maze.get_room(cx, cy).add_door(d)
                opposite = {Direction.NORTH: Direction.SOUTH, Direction.SOUTH: Direction.NORTH, Direction.EAST: Direction.WEST, Direction.WEST: Direction.EAST}
                maze.get_room(nx, ny).add_door(opposite[d])
                self._carve(nx, ny, maze, visited)

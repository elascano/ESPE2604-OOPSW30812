import random
from model.cell import Cell
from model.maze import Maze
from model.direction import Direction
from service.i_maze_generator import IMazeGenerator

class DFSGenerator(IMazeGenerator):
    def __init__(self, seed=None):
        self.random = random.Random(seed) if seed is not None else random.Random()

    def generate(self, maze: Maze):
        width = maze.width
        height = maze.height
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
        stack = [current]

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

    def get_random_unvisited_neighbor(self, c: Cell, m: Maze):
        unvisited = []
        x = c.x
        y = c.y

        if y > 0:
            neighbor = m.get_cell(x, y - 1)
            if neighbor and not neighbor.is_visited:
                unvisited.append(neighbor)
        if y < m.height - 1:
            neighbor = m.get_cell(x, y + 1)
            if neighbor and not neighbor.is_visited:
                unvisited.append(neighbor)
        if x > 0:
            neighbor = m.get_cell(x - 1, y)
            if neighbor and not neighbor.is_visited:
                unvisited.append(neighbor)
        if x < m.width - 1:
            neighbor = m.get_cell(x + 1, y)
            if neighbor and not neighbor.is_visited:
                unvisited.append(neighbor)

        if not unvisited:
            return None
        return self.random.choice(unvisited)

    def break_walls(self, current: Cell, next_cell: Cell):
        if next_cell.y < current.y:
            current.break_wall(Direction.NORTH)
            next_cell.break_wall(Direction.SOUTH)
        elif next_cell.y > current.y:
            current.break_wall(Direction.SOUTH)
            next_cell.break_wall(Direction.NORTH)
        elif next_cell.x > current.x:
            current.break_wall(Direction.EAST)
            next_cell.break_wall(Direction.WEST)
        elif next_cell.x < current.x:
            current.break_wall(Direction.WEST)
            next_cell.break_wall(Direction.EAST)

from model.maze import Maze
from service.i_maze_solver import IMazeSolver

class DFSSolver(IMazeSolver):
    def find_path(self, maze: Maze) -> list:
        width = maze.width
        height = maze.height
        if width <= 0 or height <= 0:
            return []

        entrance = maze.entrance
        exit_cell = maze.exit
        if not entrance or not exit_cell:
            return []

        visited = [[False for _ in range(width)] for _ in range(height)]
        parent = [[None for _ in range(width)] for _ in range(height)]

        stack = [entrance]
        visited[entrance.y][entrance.x] = True
        found = False

        while stack:
            current = stack.pop()
            if current == exit_cell:
                found = True
                break

            x = current.x
            y = current.y

            if not current.is_wall_north and y > 0:
                nxt = maze.get_cell(x, y - 1)
                if nxt and not visited[nxt.y][nxt.x]:
                    visited[nxt.y][nxt.x] = True
                    parent[nxt.y][nxt.x] = current
                    stack.append(nxt)
            if not current.is_wall_south and y < height - 1:
                nxt = maze.get_cell(x, y + 1)
                if nxt and not visited[nxt.y][nxt.x]:
                    visited[nxt.y][nxt.x] = True
                    parent[nxt.y][nxt.x] = current
                    stack.append(nxt)
            if not current.is_wall_east and x < width - 1:
                nxt = maze.get_cell(x + 1, y)
                if nxt and not visited[nxt.y][nxt.x]:
                    visited[nxt.y][nxt.x] = True
                    parent[nxt.y][nxt.x] = current
                    stack.append(nxt)
            if not current.is_wall_west and x > 0:
                nxt = maze.get_cell(x - 1, y)
                if nxt and not visited[nxt.y][nxt.x]:
                    visited[nxt.y][nxt.x] = True
                    parent[nxt.y][nxt.x] = current
                    stack.append(nxt)

        if not found:
            return []

        path = []
        curr = exit_cell
        while curr:
            path.append(curr)
            curr = parent[curr.y][curr.x]
        path.reverse()
        return path

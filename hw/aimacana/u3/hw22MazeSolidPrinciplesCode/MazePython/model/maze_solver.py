from model.direction import Direction

class MazeSolver:
    def solve(self, maze):
        pass

class DFSMazeSolver(MazeSolver):
    def solve(self, maze):
        visited = [[False]*maze.height for _ in range(maze.width)]
        path = []
        self._dfs(maze.get_room(0, 0), maze, visited, path)
        return path

    def _dfs(self, current, maze, visited, path):
        visited[current.x][current.y] = True
        path.append(current)
        if current.is_exit:
            return True
        for d in [Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST]:
            if current.has_door(d):
                nx, ny = current.x, current.y
                if d == Direction.NORTH: ny -= 1
                elif d == Direction.SOUTH: ny += 1
                elif d == Direction.EAST: nx += 1
                elif d == Direction.WEST: nx -= 1
                
                if 0 <= nx < maze.width and 0 <= ny < maze.height and not visited[nx][ny]:
                    if self._dfs(maze.get_room(nx, ny), maze, visited, path):
                        return True
        path.pop()
        return False

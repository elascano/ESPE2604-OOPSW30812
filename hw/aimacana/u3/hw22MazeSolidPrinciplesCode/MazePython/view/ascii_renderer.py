from model.maze import Maze
from view.base_renderer import BaseRenderer

class ASCIIRenderer(BaseRenderer):
    def draw(self, maze: Maze, path: list):
        super().draw(maze, path)
        width = maze.width
        height = maze.height
        
        is_path = [[False for _ in range(width)] for _ in range(height)]
        if path:
            for cell in path:
                is_path[cell.y][cell.x] = True

        for y in range(height):
            top_line = ""
            for x in range(width):
                cell = maze.get_cell(x, y)
                top_line += "+---" if cell.is_wall_north else "+   "
            print(top_line + "+")

            side_line = ""
            for x in range(width):
                cell = maze.get_cell(x, y)
                char = " "
                if cell == maze.entrance:
                    char = "S"
                elif cell == maze.exit:
                    char = "E"
                elif is_path[y][x]:
                    char = "*"
                side_line += ("| " + char + " ") if cell.is_wall_west else ("  " + char + " ")
            print(side_line + "|")

        bottom_line = ""
        for x in range(width):
            bottom_line += "+---"
        print(bottom_line + "+")

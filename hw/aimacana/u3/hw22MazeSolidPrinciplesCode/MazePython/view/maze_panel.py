import tkinter as tk
from model.maze import Maze

class MazePanel(tk.Canvas):
    def __init__(self, master, maze: Maze, path: list, cell_size: int):
        self.maze = maze
        self.path = path
        self.cell_size = cell_size
        
        w = maze.width * cell_size
        h = maze.height * cell_size
        
        super().__init__(master, width=w + cell_size, height=h + cell_size, bg="#121218", highlightthickness=0)
        self.bind("<Configure>", self.on_paint)
        
    def on_paint(self, event=None):
        self.delete("all")
        width = self.maze.width
        height = self.maze.height
        margin = self.cell_size // 2
        
        # Colors
        wall_color = "#4a5568"
        path_color = "#ef4444"
        entrance_color = "#22c55e"
        exit_color = "#3b82f6"
        cell_bg_color = "#1e293b"
        
        # Background
        self.create_rectangle(margin, margin, margin + width * self.cell_size, margin + height * self.cell_size, fill=cell_bg_color, outline="")
        
        # Entrance / Exit
        entrance = self.maze.entrance
        if entrance:
            ex = margin + entrance.x * self.cell_size
            ey = margin + entrance.y * self.cell_size
            self.create_rectangle(ex, ey, ex + self.cell_size, ey + self.cell_size, fill=entrance_color, outline="")
            
        exit_cell = self.maze.exit
        if exit_cell:
            ex = margin + exit_cell.x * self.cell_size
            ey = margin + exit_cell.y * self.cell_size
            self.create_rectangle(ex, ey, ex + self.cell_size, ey + self.cell_size, fill=exit_color, outline="")
            
        # Path
        if self.path:
            line_width = max(2, self.cell_size // 4)
            for i in range(len(self.path) - 1):
                c1 = self.path[i]
                c2 = self.path[i + 1]
                x1 = margin + c1.x * self.cell_size + self.cell_size // 2
                y1 = margin + c1.y * self.cell_size + self.cell_size // 2
                x2 = margin + c2.x * self.cell_size + self.cell_size // 2
                y2 = margin + c2.y * self.cell_size + self.cell_size // 2
                self.create_line(x1, y1, x2, y2, fill=path_color, width=line_width, capstyle=tk.ROUND, joinstyle=tk.ROUND)
                
        # Walls
        wall_width = max(1, self.cell_size // 10)
        for y in range(height):
            for x in range(width):
                cell = self.maze.get_cell(x, y)
                if not cell:
                    continue
                
                cx = margin + x * self.cell_size
                cy = margin + y * self.cell_size
                
                if cell.is_wall_north:
                    self.create_line(cx, cy, cx + self.cell_size, cy, fill=wall_color, width=wall_width)
                if cell.is_wall_south:
                    self.create_line(cx, cy + self.cell_size, cx + self.cell_size, cy + self.cell_size, fill=wall_color, width=wall_width)
                if cell.is_wall_east:
                    self.create_line(cx + self.cell_size, cy, cx + self.cell_size, cy + self.cell_size, fill=wall_color, width=wall_width)
                if cell.is_wall_west:
                    self.create_line(cx, cy, cx, cy + self.cell_size, fill=wall_color, width=wall_width)

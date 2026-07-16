from abc import ABC, abstractmethod
from typing import List
import tkinter as tk
from model.maze import Maze
from model.cell import Cell

class IMazeRenderer(ABC):
    @abstractmethod
    def draw(self, maze: Maze, path: List[Cell]) -> None:
        pass

class BaseRenderer(IMazeRenderer):
    def draw(self, maze: Maze, path: List[Cell]) -> None:
        if not self.validate_maze(maze):
            raise ValueError()

    def validate_maze(self, maze: Maze) -> bool:
        return maze is not None and maze.get_width() > 0 and maze.get_height() > 0 and maze.get_grid() is not None

class ASCIIRenderer(BaseRenderer):
    def draw(self, maze: Maze, path: List[Cell]) -> None:
        super().draw(maze, path)
        width = maze.get_width()
        height = maze.get_height()
        is_path = [[False] * width for _ in range(height)]
        if path:
            for cell in path:
                is_path[cell.get_y()][cell.get_x()] = True

        for y in range(height):
            top_line = ""
            for x in range(width):
                cell = maze.get_cell(x, y)
                if cell:
                    top_line += "+---" if cell.is_wall_north() else "+   "
            print(top_line + "+")

            side_line = ""
            for x in range(width):
                cell = maze.get_cell(x, y)
                if cell:
                    character = " "
                    if cell == maze.get_entrance():
                        character = "S"
                    elif cell == maze.get_exit():
                        character = "E"
                    elif is_path[y][x]:
                        character = "*"
                    side_line += "| " + character + " " if cell.is_wall_west() else "  " + character + " "
            print(side_line + "|")

        bottom_line = ""
        for x in range(width):
            bottom_line += "+---"
        print(bottom_line + "+")

class TkinterRenderer(BaseRenderer):
    def __init__(self, cell_size: int = 20):
        self.cell_size = cell_size

    def draw(self, maze: Maze, path: List[Cell]) -> None:
        super().draw(maze, path)
        
        width = maze.get_width()
        height = maze.get_height()
        
        max_dim = max(width, height)
        cell_size = self.cell_size
        if max_dim > 100:
            cell_size = max(4, 800 // max_dim)
            
        margin = cell_size // 2

        window = tk.Toplevel()
        window.title("Maze Visualizer")
        
        canvas_width = width * cell_size + cell_size
        canvas_height = height * cell_size + cell_size
        
        canvas_frame = tk.Frame(window)
        canvas_frame.pack(fill=tk.BOTH, expand=True)
        
        canvas = tk.Canvas(canvas_frame, bg="#121218", width=min(850, canvas_width), height=min(850, canvas_height))
        canvas.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        
        v_scroll = tk.Scrollbar(canvas_frame, orient=tk.VERTICAL, command=canvas.yview)
        v_scroll.pack(side=tk.RIGHT, fill=tk.Y)
        h_scroll = tk.Scrollbar(window, orient=tk.HORIZONTAL, command=canvas.xview)
        h_scroll.pack(side=tk.BOTTOM, fill=tk.X)
        
        canvas.configure(xscrollcommand=h_scroll.set, yscrollcommand=v_scroll.set)
        canvas.configure(scrollregion=(0, 0, canvas_width, canvas_height))
        
        canvas.create_rectangle(
            margin, margin, margin + width * cell_size, margin + height * cell_size,
            fill="#1e293b", outline=""
        )

        entrance = maze.get_entrance()
        if entrance:
            ex_x = margin + entrance.get_x() * cell_size
            ex_y = margin + entrance.get_y() * cell_size
            canvas.create_rectangle(ex_x, ex_y, ex_x + cell_size, ex_y + cell_size, fill="#22c55e", outline="")

        exit_cell = maze.get_exit()
        if exit_cell:
            ex_x = margin + exit_cell.get_x() * cell_size
            ex_y = margin + exit_cell.get_y() * cell_size
            canvas.create_rectangle(ex_x, ex_y, ex_x + cell_size, ex_y + cell_size, fill="#3b82f6", outline="")

        if path and len(path) > 0:
            line_points = []
            for cell in path:
                px = margin + cell.get_x() * cell_size + cell_size // 2
                py = margin + cell.get_y() * cell_size + cell_size // 2
                line_points.extend([px, py])
            canvas.create_line(line_points, fill="#ef4444", width=max(2, cell_size // 4), capstyle=tk.ROUND, joinstyle=tk.ROUND)

        wall_width = max(1, cell_size // 10)
        for y in range(height):
            for x in range(width):
                cell = maze.get_cell(x, y)
                if not cell:
                    continue
                cx = margin + x * cell_size
                cy = margin + y * cell_size

                if cell.is_wall_north():
                    canvas.create_line(cx, cy, cx + cell_size, cy, fill="#4a5568", width=wall_width)
                if cell.is_wall_south():
                    canvas.create_line(cx, cy + cell_size, cx + cell_size, cy + cell_size, fill="#4a5568", width=wall_width)
                if cell.is_wall_east():
                    canvas.create_line(cx + cell_size, cy, cx + cell_size, cy + cell_size, fill="#4a5568", width=wall_width)
                if cell.is_wall_west():
                    canvas.create_line(cx, cy, cx, cy + cell_size, fill="#4a5568", width=wall_width)

import tkinter as tk
from model.maze import Maze
from view.base_renderer import BaseRenderer
from view.maze_panel import MazePanel

class ImageRenderer(BaseRenderer):
    def __init__(self, cell_size=20):
        self.cell_size = cell_size

    def draw(self, maze: Maze, path: list):
        super().draw(maze, path)
        
        root = tk.Toplevel()
        root.title("Maze Visualizer")
        
        calculated_cell_size = self.cell_size
        if maze.width > 100 or maze.height > 100:
            calculated_cell_size = max(4, 800 // max(maze.width, maze.height))
            
        panel = MazePanel(root, maze, path, calculated_cell_size)
        panel.pack(padx=20, pady=20)
        panel.on_paint()

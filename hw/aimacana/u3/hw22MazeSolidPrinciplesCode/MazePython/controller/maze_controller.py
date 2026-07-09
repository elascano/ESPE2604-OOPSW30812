from model.maze_generator import BacktrackingMazeGenerator
from model.maze_solver import DFSMazeSolver
from view.gui_view import GUIView

class MazeController:
    def __init__(self, root):
        self.generator = BacktrackingMazeGenerator()
        self.solver = DFSMazeSolver()
        self.view = GUIView(root, self)
        
    def generate(self, w, h):
        maze = self.generator.generate(w, h)
        path = self.solver.solve(maze)
        self.view.render(maze, path)

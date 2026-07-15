import tkinter as tk
from controller.maze_controller import MazeController

if __name__ == "__main__":
    root = tk.Tk()
    root.geometry("1200x700")
    app = MazeController(root)
    root.after(100, lambda: app.generate(15, 15))
    root.mainloop()

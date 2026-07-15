import tkinter as tk

from controller.maze_controller import MazeController


class MazeFrame:

    def __init__(self):

        self.controller = MazeController()

        self.window = tk.Tk()
        self.window.title("Maze Application")

        tk.Label(self.window, text="Rows").pack()

        self.txt_n = tk.Entry(self.window)
        self.txt_n.pack()

        tk.Label(self.window, text="Columns").pack()

        self.txt_m = tk.Entry(self.window)
        self.txt_m.pack()

        self.btn_generate = tk.Button(
            self.window,
            text="Generate Maze",
            command=self.generate
        )
        self.btn_generate.pack()

        self.txt_maze = tk.Text(self.window, width=40, height=15)
        self.txt_maze.pack()

    def generate(self):

        n = int(self.txt_n.get())
        m = int(self.txt_m.get())

        self.controller.create_maze(n, m)

        self.txt_maze.delete("1.0", tk.END)
        self.txt_maze.insert(
            tk.END,
            self.controller.draw_maze()
        )

    def start(self):
        self.window.mainloop()
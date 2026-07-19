import tkinter as tk
from tkinter import ttk, messagebox
from controller.controller import MazeController
from service.generator import DFSGenerator
from service.solver import DFSSolver
from view.renderer import TkinterRenderer, ASCIIRenderer

class MazeApp:
    def __init__(self, root: tk.Tk):
        self.root = root
        self.root.title("Maze System (SOLID & MVC)")
        self.root.geometry("450x300")
        self.root.configure(bg="#18181b")

        style = ttk.Style()
        style.theme_use("clam")
        style.configure(".", background="#18181b", foreground="#f4f4f5", fieldbackground="#0f172a")

        main_frame = tk.Frame(root, bg="#18181b", padx=20, pady=20)
        main_frame.pack(fill=tk.BOTH, expand=True)

        title_label = tk.Label(
            main_frame, text="Maze System (SOLID & MVC)",
            font=("Segoe UI", 16, "bold"), bg="#18181b", fg="#f4f4f5"
        )
        title_label.pack(pady=(0, 20))

        form_frame = tk.Frame(main_frame, bg="#18181b")
        form_frame.pack(fill=tk.BOTH, expand=True)

        form_frame.columnconfigure(1, weight=1)

        tk.Label(form_frame, text="Width:", font=("Segoe UI", 10), bg="#18181b", fg="#d4d4d8").grid(row=0, column=0, sticky=tk.W, pady=8)
        self.width_var = tk.IntVar(value=30)
        self.width_spin = ttk.Spinbox(form_frame, from_=5, to=200, textvariable=self.width_var, font=("Segoe UI", 10))
        self.width_spin.grid(row=0, column=1, sticky=tk.EW, padx=(10, 0), pady=8)

        tk.Label(form_frame, text="Height:", font=("Segoe UI", 10), bg="#18181b", fg="#d4d4d8").grid(row=1, column=0, sticky=tk.W, pady=8)
        self.height_var = tk.IntVar(value=30)
        self.height_spin = ttk.Spinbox(form_frame, from_=5, to=200, textvariable=self.height_var, font=("Segoe UI", 10))
        self.height_spin.grid(row=1, column=1, sticky=tk.EW, padx=(10, 0), pady=8)

        tk.Label(form_frame, text="Renderer:", font=("Segoe UI", 10), bg="#18181b", fg="#d4d4d8").grid(row=2, column=0, sticky=tk.W, pady=8)
        self.renderer_var = tk.StringVar(value="Graphical Window")
        self.renderer_combo = ttk.Combobox(
            form_frame, textvariable=self.renderer_var,
            values=["Graphical Window", "Console (ASCII)"],
            state="readonly", font=("Segoe UI", 10)
        )
        self.renderer_combo.grid(row=2, column=1, sticky=tk.EW, padx=(10, 0), pady=8)

        self.run_button = tk.Button(
            main_frame, text="Generate & Solve",
            font=("Segoe UI", 11, "bold"), bg="#2563eb", fg="white",
            activebackground="#1d4ed8", activeforeground="white",
            relief=tk.FLAT, bd=0, height=2, command=self.run_maze
        )
        self.run_button.pack(fill=tk.X, pady=(15, 0))

    def run_maze(self):
        try:
            width = self.width_var.get()
            height = self.height_var.get()
            renderer_type = self.renderer_var.get()
        except tk.TclError:
            messagebox.showerror("Error", "Invalid numeric values")
            return

        if width <= 0 or height <= 0:
            messagebox.showerror("Error", "Dimensions must be positive")
            return

        if renderer_type == "Graphical Window":
            renderer = TkinterRenderer()
        else:
            renderer = ASCIIRenderer()

        controller = MazeController(DFSGenerator(), DFSSolver(), renderer)
        try:
            controller.create_and_show_maze(width, height)
        except Exception as ex:
            messagebox.showerror("Error", f"Error running maze: {ex}")

if __name__ == "__main__":
    main_root = tk.Tk()
    app = MazeApp(main_root)
    main_root.mainloop()

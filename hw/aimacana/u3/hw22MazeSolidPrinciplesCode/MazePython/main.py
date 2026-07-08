import sys
import os
sys.path.append(os.path.dirname(os.path.abspath(__file__)))

import tkinter as tk
from tkinter import ttk, messagebox
from controller.maze_controller import MazeController
from service.dfs_generator import DFSGenerator
from service.dfs_solver import DFSSolver
from view.ascii_renderer import ASCIIRenderer
from view.image_renderer import ImageRenderer

def create_and_show_gui():
    root = tk.Tk()
    root.title("Maze Generator & Solver Dashboard")
    root.geometry("450x300")
    root.configure(bg="#18181b")

    main_frame = tk.Frame(root, bg="#18181b", padx=20, pady=20)
    main_frame.pack(fill=tk.BOTH, expand=True)

    title_label = tk.Label(main_frame, text="Maze System (SOLID & MVC)", font=("Segoe UI", 20, "bold"), bg="#18181b", fg="#f4f4f5")
    title_label.pack(pady=(0, 20))

    form_frame = tk.Frame(main_frame, bg="#18181b")
    form_frame.pack(fill=tk.X, expand=True)

    form_frame.columnconfigure(0, weight=1)
    form_frame.columnconfigure(1, weight=1)

    tk.Label(form_frame, text="Width:", font=("Segoe UI", 14), bg="#18181b", fg="#d4d4d8", anchor="w").grid(row=0, column=0, sticky="ew", pady=5)
    width_var = tk.IntVar(value=20)
    width_spin = tk.Spinbox(form_frame, from_=5, to=200, textvariable=width_var, font=("Segoe UI", 14))
    width_spin.grid(row=0, column=1, sticky="ew", pady=5)

    tk.Label(form_frame, text="Height:", font=("Segoe UI", 14), bg="#18181b", fg="#d4d4d8", anchor="w").grid(row=1, column=0, sticky="ew", pady=5)
    height_var = tk.IntVar(value=20)
    height_spin = tk.Spinbox(form_frame, from_=5, to=200, textvariable=height_var, font=("Segoe UI", 14))
    height_spin.grid(row=1, column=1, sticky="ew", pady=5)

    tk.Label(form_frame, text="Renderer:", font=("Segoe UI", 14), bg="#18181b", fg="#d4d4d8", anchor="w").grid(row=2, column=0, sticky="ew", pady=5)
    renderer_var = tk.StringVar(value="Graphical Window")
    renderer_combo = ttk.Combobox(form_frame, textvariable=renderer_var, values=["Graphical Window", "Console (ASCII)"], font=("Segoe UI", 14), state="readonly")
    renderer_combo.grid(row=2, column=1, sticky="ew", pady=5)

    def on_run():
        width = width_var.get()
        height = height_var.get()
        selected_renderer = renderer_var.get()

        if width <= 0 or height <= 0:
            messagebox.showerror("Error", "Dimensions must be positive")
            return

        if selected_renderer == "Graphical Window":
            controller = MazeController(DFSGenerator(), DFSSolver(), ImageRenderer())
        else:
            controller = MazeController(DFSGenerator(), DFSSolver(), ASCIIRenderer())
        
        try:
            controller.create_and_show_maze(width, height)
        except Exception as e:
            messagebox.showerror("Error", f"Error running maze: {e}")

    run_btn = tk.Button(main_frame, text="Generate & Solve", font=("Segoe UI", 15, "bold"), bg="#2563eb", fg="white", command=on_run, height=2)
    run_btn.pack(fill=tk.X, pady=(20, 0))

    root.mainloop()

if __name__ == "__main__":
    create_and_show_gui()

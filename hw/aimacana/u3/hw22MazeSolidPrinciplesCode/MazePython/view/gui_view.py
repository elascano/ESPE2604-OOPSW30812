import tkinter as tk
from tkinter import messagebox
from model.direction import Direction

class IMazeView:
    def render(self, maze, solution):
        pass

class GUIView(IMazeView):
    def __init__(self, root, controller):
        self.controller = controller
        self.root = root
        self.root.title("MazeGen Pro - Python")
        self.root.configure(bg="#0f172a")
        
        sidebar = tk.Frame(root, bg="#1e293b", width=250)
        sidebar.pack(side="left", fill="y", padx=0, pady=0)
        
        tk.Label(sidebar, text="MazeGen Pro", font=("Segoe UI", 20, "bold"), bg="#1e293b", fg="#6366f1").pack(pady=20, padx=20)
        
        tk.Label(sidebar, text="Width (N):", bg="#1e293b", fg="#94a3b8", font=("Segoe UI", 12)).pack(anchor="w", padx=20, pady=(10, 5))
        self.entry_w = tk.Entry(sidebar, bg="#334155", fg="#f8fafc", font=("Segoe UI", 12), relief="flat")
        self.entry_w.insert(0, "15")
        self.entry_w.pack(fill="x", padx=20)
        
        tk.Label(sidebar, text="Height (M):", bg="#1e293b", fg="#94a3b8", font=("Segoe UI", 12)).pack(anchor="w", padx=20, pady=(20, 5))
        self.entry_h = tk.Entry(sidebar, bg="#334155", fg="#f8fafc", font=("Segoe UI", 12), relief="flat")
        self.entry_h.insert(0, "15")
        self.entry_h.pack(fill="x", padx=20)
        
        btn = tk.Button(sidebar, text="Generate Maze", bg="#6366f1", fg="white", font=("Segoe UI", 12, "bold"), relief="flat", cursor="hand2", command=self.on_generate)
        btn.pack(fill="x", padx=20, pady=40)
        
        main_area = tk.Frame(root, bg="#0f172a")
        main_area.pack(side="right", fill="both", expand=True, padx=20, pady=20)
        
        self.canvas = tk.Canvas(main_area, bg="#0f172a", highlightthickness=1, highlightbackground="#334155")
        self.canvas.pack(side="left", fill="both", expand=True, padx=(0, 10))
        
        self.text_area = tk.Text(main_area, bg="#0f172a", fg="#94a3b8", font=("Consolas", 14), highlightthickness=1, highlightbackground="#334155", relief="flat")
        self.text_area.pack(side="right", fill="both", expand=True, padx=(10, 0))
        
    def on_generate(self):
        try:
            w = int(self.entry_w.get())
            h = int(self.entry_h.get())
            self.controller.generate(w, h)
        except ValueError:
            messagebox.showerror("Error", "Invalid inputs")

    def render(self, maze, path):
        self.canvas.delete("all")
        self.text_area.delete(1.0, tk.END)
        
        w, h = maze.width, maze.height
        
        self.canvas.update()
        cw, ch = self.canvas.winfo_width(), self.canvas.winfo_height()
        if cw < 10: cw = 400
        if ch < 10: ch = 400
        cell_size = min(cw//w, ch//h, 40)
        
        offset_x = (cw - w*cell_size)//2
        offset_y = (ch - h*cell_size)//2
        
        for r in [maze.get_room(0, 0), maze.get_room(w-1, h-1)]:
            px = offset_x + r.x * cell_size
            py = offset_y + r.y * cell_size
            if r.is_entrance:
                self.canvas.create_rectangle(px, py, px+cell_size, py+cell_size, fill="#10b981", outline="")
                self.canvas.create_text(px+cell_size//2, py+cell_size//2, text="S", fill="white", font=("Segoe UI", int(cell_size*0.5), "bold"))
            elif r.is_exit:
                self.canvas.create_rectangle(px, py, px+cell_size, py+cell_size, fill="#ef4444", outline="")
                self.canvas.create_text(px+cell_size//2, py+cell_size//2, text="E", fill="white", font=("Segoe UI", int(cell_size*0.5), "bold"))
                    
        if path:
            pts = []
            for r in path:
                pts.append(offset_x + r.x * cell_size + cell_size//2)
                pts.append(offset_y + r.y * cell_size + cell_size//2)
            self.canvas.create_line(pts, fill="#eab308", width=max(2, int(cell_size*0.2)), capstyle="round", joinstyle="round")
            
        for x in range(w):
            for y in range(h):
                r = maze.get_room(x, y)
                px = offset_x + x * cell_size
                py = offset_y + y * cell_size
                
                if not r.has_door(Direction.NORTH) and not (r.is_entrance and y == 0):
                    self.canvas.create_line(px, py, px+cell_size, py, fill="#64748b", width=2, capstyle="round")
                if not r.has_door(Direction.WEST):
                    self.canvas.create_line(px, py, px, py+cell_size, fill="#64748b", width=2, capstyle="round")
                if x == w-1:
                    self.canvas.create_line(px+cell_size, py, px+cell_size, py+cell_size, fill="#64748b", width=2, capstyle="round")
                if y == h-1 and not (r.is_exit and x == w-1):
                    self.canvas.create_line(px, py+cell_size, px+cell_size, py+cell_size, fill="#64748b", width=2, capstyle="round")

        lines = []
        for y in range(h):
            top_line = ""
            mid_line = ""
            for x in range(w):
                r = maze.get_room(x, y)
                top_line += "+"
                top_line += "   " if r.has_door(Direction.NORTH) or (r.is_entrance and y == 0) else "---"
                mid_line += " " if r.has_door(Direction.WEST) else "|"
                if r.is_entrance: mid_line += " S "
                elif r.is_exit: mid_line += " E "
                elif r in path: mid_line += " · "
                else: mid_line += "   "
            top_line += "+"
            mid_line += "|"
            lines.append(top_line)
            lines.append(mid_line)
        bottom_line = ""
        for x in range(w):
            bottom_line += "+"
            bottom_line += "   " if maze.get_room(x, h-1).has_door(Direction.SOUTH) or (maze.get_room(x, h-1).is_exit and x == w-1) else "---"
        bottom_line += "+"
        lines.append(bottom_line)
        
        self.text_area.insert(tk.END, "\n".join(lines))

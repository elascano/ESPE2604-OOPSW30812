import tkinter as tk
from tkinter import messagebox, ttk
from controller.sorting_controller import SortingController

# Jennyfer Nase

class SortApp:
    def __init__(self, root):
        self.ctrl = SortingController()
        root.title("SortApp")
        
        self.entry = tk.Entry(root, width=40)
        self.entry.pack(pady=5)
        
        tk.Button(root, text="Sort & Save", command=self.run).pack(pady=5)
        
        self.tree = ttk.Treeview(root, columns=("U", "S", "A", "O"), show="headings", height=5)
        for c, h in zip(("U", "S", "A", "O"), ("Unsorted", "Size", "Algorithm", "Sorted")):
            self.tree.heading(c, text=h)
            self.tree.column(c, width=100)
        self.tree.pack(pady=5, fill=tk.BOTH, expand=True)

    def run(self):
        try:
            r = self.ctrl.process(self.entry.get())
            self.tree.insert("", "end", values=(r["unsorted"], r["size"], r["algorithm"], r["sorted"]))
        except Exception as e:
            messagebox.showerror("Error", str(e))

if __name__ == "__main__":
    r = tk.Tk()
    SortApp(r)
    r.mainloop()

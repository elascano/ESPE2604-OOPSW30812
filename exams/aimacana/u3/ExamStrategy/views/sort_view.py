import tkinter as tk
from tkinter import ttk, messagebox
from typing import Callable, List, Dict, Any


class SortView(tk.Tk):

    def __init__(self):
        super().__init__()

        self.title("Exam Strategy Pattern")
        self.geometry("650x450")

        input_frame = ttk.Frame(self, padding=10)
        input_frame.pack(fill=tk.X)

        ttk.Label(input_frame, text="Números:").pack(side=tk.LEFT, padx=5)

        self.input_entry = ttk.Entry(input_frame, width=40)
        self.input_entry.insert(0, "5, 8, 7, 2")
        self.input_entry.pack(side=tk.LEFT, padx=5, expand=True, fill=tk.X)

        self.btn_sort = ttk.Button(input_frame, text="Ordenar")
        self.btn_sort.pack(side=tk.LEFT, padx=5)

        res_frame = ttk.LabelFrame(self, text="Resultado", padding=10)
        res_frame.pack(fill=tk.X, padx=10, pady=5)

        grid_frame = ttk.Frame(res_frame)
        grid_frame.pack(fill=tk.X)

        ttk.Label(grid_frame, text="Sin ordenar:").grid(row=0, column=0, sticky=tk.W, padx=5, pady=2)
        self.lbl_unsorted = ttk.Label(grid_frame, text="-")
        self.lbl_unsorted.grid(row=0, column=1, sticky=tk.W, padx=5, pady=2)

        ttk.Label(grid_frame, text="Tamaño:").grid(row=0, column=2, sticky=tk.W, padx=15, pady=2)
        self.lbl_size = ttk.Label(grid_frame, text="-")
        self.lbl_size.grid(row=0, column=3, sticky=tk.W, padx=5, pady=2)

        ttk.Label(grid_frame, text="Algoritmo:").grid(row=1, column=0, sticky=tk.W, padx=5, pady=2)
        self.lbl_algorithm = ttk.Label(grid_frame, text="-", font=("Segoe UI", 9, "bold"))
        self.lbl_algorithm.grid(row=1, column=1, sticky=tk.W, padx=5, pady=2)

        ttk.Label(grid_frame, text="Ordenado:").grid(row=1, column=2, sticky=tk.W, padx=15, pady=2)
        self.lbl_sorted = ttk.Label(grid_frame, text="-", font=("Segoe UI", 9, "bold"))
        self.lbl_sorted.grid(row=1, column=3, sticky=tk.W, padx=5, pady=2)

        table_frame = ttk.Frame(self, padding=10)
        table_frame.pack(fill=tk.BOTH, expand=True)

        columns = ("unsorted", "size", "sort_algorithm", "sorted")
        self.tree = ttk.Treeview(table_frame, columns=columns, show="headings")

        self.tree.heading("unsorted", text="Unsorted")
        self.tree.heading("size", text="Size")
        self.tree.heading("sort_algorithm", text="Sort Algorithm")
        self.tree.heading("sorted", text="Sorted")

        self.tree.column("unsorted", width=160, anchor=tk.W)
        self.tree.column("size", width=60, anchor=tk.CENTER)
        self.tree.column("sort_algorithm", width=140, anchor=tk.CENTER)
        self.tree.column("sorted", width=160, anchor=tk.W)

        v_scroll = ttk.Scrollbar(table_frame, orient=tk.VERTICAL, command=self.tree.yview)
        self.tree.configure(yscrollcommand=v_scroll.set)

        self.tree.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        v_scroll.pack(side=tk.RIGHT, fill=tk.Y)

    def bind_sort(self, handler: Callable[[], None]):
        self.btn_sort.configure(command=handler)

    def get_input_string(self) -> str:
        return self.input_entry.get().strip()

    def display_results(self, unsorted_str: str, size: int, algorithm_name: str, sorted_str: str):
        self.lbl_unsorted.configure(text=unsorted_str)
        self.lbl_size.configure(text=str(size))
        self.lbl_algorithm.configure(text=algorithm_name)
        self.lbl_sorted.configure(text=sorted_str)

    def populate_table(self, records: List[Dict[str, Any]]):
        for item in self.tree.get_children():
            self.tree.delete(item)

        for rec in records:
            self.tree.insert(
                "",
                tk.END,
                values=(
                    rec.get("unsorted", ""),
                    rec.get("size", ""),
                    rec.get("sort algorithm", ""),
                    rec.get("sorted", "")
                )
            )

    def show_error(self, title: str, message: str):
        messagebox.showerror(title, message)

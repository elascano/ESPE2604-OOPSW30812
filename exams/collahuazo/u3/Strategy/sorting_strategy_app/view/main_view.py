import os
import sys

sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

import tkinter as tk
from tkinter import ttk, messagebox

from controller.sort_controller import SortController


class MainView:
    def __init__(self, root: tk.Tk):
        self.root = root
        self.root.title("Sorting App")
        self.root.geometry("580x400")
        self.root.resizable(False, False)

        self.controller = SortController()
        self._build_widgets()

    def _build_widgets(self) -> None:
        frame = ttk.Frame(self.root, padding=15)
        frame.pack(fill="both", expand=True)

        ttk.Label(
            frame,
            text="Introduce elements (Ej: 5, 8, 7, 2):",
        ).pack(anchor="w")

        self.entry = ttk.Entry(frame, width=55)
        self.entry.pack(fill="x", pady=(5, 10))
       

        ttk.Button(frame, text="Sort", command=self._on_sort).pack(pady=5)

        self.lbl_unsorted = ttk.Label(frame, text="Unsorted: ", wraplength=540)
        self.lbl_unsorted.pack(anchor="w", pady=(15, 3))

        self.lbl_size = ttk.Label(frame, text="Size: ")
        self.lbl_size.pack(anchor="w", pady=3)

        self.lbl_algorithm = ttk.Label(frame, text="Algorithm: ")
        self.lbl_algorithm.pack(anchor="w", pady=3)

        self.lbl_sorted = ttk.Label(frame, text="Sorted: ", wraplength=540)
        self.lbl_sorted.pack(anchor="w", pady=3)

        self.lbl_status = ttk.Label(frame, text="", foreground="green")
        self.lbl_status.pack(anchor="w", pady=(15, 0))

    def _on_sort(self) -> None:
        text = self.entry.get()
        try:
            record = self.controller.process(text)
        except ValueError as e:
            messagebox.showerror("Input error", str(e))
            return
        except Exception as e:
            messagebox.showerror("Unexpected error", str(e))
            return

        self.lbl_unsorted.config(text=f"Unsorted: {record.unsorted}")
        self.lbl_size.config(text=f"Size: {record.size}")
        self.lbl_algorithm.config(text=f"Chosen algorithm: {record.algorithm}")
        self.lbl_sorted.config(text=f"Sorted: {record.sorted}")

        if record.saved:
            self.lbl_status.config(text="Saved in database", foreground="green")
        else:
            self.lbl_status.config(
                text="Not saved the record in database",
                foreground="red",
            )


if __name__ == "__main__":
    root = tk.Tk()
    MainView(root)
    root.mainloop()

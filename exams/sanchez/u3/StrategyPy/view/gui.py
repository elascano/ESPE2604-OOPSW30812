import sys
import os

sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

import tkinter as tk
from tkinter import ttk, messagebox

from controller.app_controller import AppController


class GUI:

    def __init__(self, root):

        self.controller = AppController()

        self.window = root
        self.window.title("Strategy Pattern Sorting")
        self.window.geometry("650x350")

        tk.Label(
            self.window,
            text="Enter numbers separated by commas:"
        ).pack(pady=10)

        self.entry = tk.Entry(
            self.window,
            width=50
        )
        self.entry.pack()

        tk.Button(
            self.window,
            text="Sort",
            command=self.sort_numbers
        ).pack(pady=10)

        columns = (
            "Algorithm",
            "Sorted Numbers"
        )

        self.table = ttk.Treeview(
            self.window,
            columns=columns,
            show="headings",
            height=5
        )

        self.table.heading(
            "Algorithm",
            text="Algorithm"
        )

        self.table.heading(
            "Sorted Numbers",
            text="Sorted Numbers"
        )

        self.table.column(
            "Algorithm",
            width=150,
            anchor="center"
        )

        self.table.column(
            "Sorted Numbers",
            width=430,
            anchor="center"
        )

        self.table.pack(
            fill="both",
            expand=True,
            padx=10,
            pady=10
        )

    def sort_numbers(self):

        try:

            text = self.entry.get().strip()

            if text == "":
                raise ValueError("Enter some numbers.")

            numbers = [int(x.strip()) for x in text.split(",")]

            algorithm, result = self.controller.execute(numbers)

            for row in self.table.get_children():
                self.table.delete(row)

            self.table.insert(
                "",
                "end",
                values=(algorithm, result)
            )

        except ValueError:
            messagebox.showerror(
                "Error",
                "Enter only integers separated by commas.\nExample: 8,5,2,9,1"
            )

        except Exception as e:
            messagebox.showerror(
                "Error",
                str(e)
            )


if __name__ == "__main__":

    root = tk.Tk()

    GUI(root)

    root.mainloop()
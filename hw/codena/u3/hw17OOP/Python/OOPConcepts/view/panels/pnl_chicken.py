import tkinter as tk
from tkinter import ttk

class ChickenPanel(ttk.Frame):

    def __init__(self, parent):

        super().__init__(parent)

        self.is_molting = tk.BooleanVar()

        ttk.Checkbutton(
            self,
            text="Molting",
            variable=self.is_molting
        ).grid(row=0, column=0, sticky="w")

        ttk.Label(
            self,
            text="Number of Eggs:"
        ).grid(row=1, column=0, sticky="w")

        self.sld_number_of_eggs = ttk.Scale(
            self,
            from_=0,
            to=10,
            orient="horizontal"
        )

        self.sld_number_of_eggs.grid(
            row=1,
            column=1,
            padx=10
        )
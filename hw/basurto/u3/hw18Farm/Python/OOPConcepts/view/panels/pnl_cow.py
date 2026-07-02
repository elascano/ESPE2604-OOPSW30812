import tkinter as tk
from tkinter import ttk

class CowPanel(ttk.Frame):

    def __init__(self, parent):

        super().__init__(parent)

        self.is_producing_milk = tk.BooleanVar()

        ttk.Checkbutton(
            self,
            text="Produce Milk",
            variable=self.is_producing_milk
        ).grid(
            row=0,
            column=0,
            sticky="w"
        )
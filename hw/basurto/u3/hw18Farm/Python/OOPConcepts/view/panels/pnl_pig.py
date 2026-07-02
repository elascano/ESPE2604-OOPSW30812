import tkinter as tk
from tkinter import ttk


class PigPanel(ttk.Frame):

    def __init__(self, parent):

        super().__init__(parent)

        ttk.Label(self, text="Ideal Weight:").grid(
            row=0,
            column=0,
            padx=10,
            pady=10,
            sticky="w"
        )

        self.txt_ideal_weight = ttk.Entry(self, width=25)

        self.txt_ideal_weight.grid(
            row=0,
            column=1,
            padx=10,
            pady=10
        )
import tkinter as tk
from tkinter import ttk


class SheepPanel(ttk.Frame):

    def __init__(self, parent):

        super().__init__(parent)

        ttk.Label(self, text="Last Shearing:").grid(
            row=0,
            column=0,
            padx=10,
            pady=10,
            sticky="w"
        )

        self.txt_last_shearing = ttk.Entry(
            self,
            width=25
        )

        self.txt_last_shearing.grid(
            row=0,
            column=1,
            padx=10,
            pady=10
        )
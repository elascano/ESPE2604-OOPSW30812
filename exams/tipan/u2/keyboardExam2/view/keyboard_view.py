import tkinter as tk
from tkinter import messagebox

from model.keyboard import Keyboard
from controller.keyboard_controller import KeyboardController

class KeyboardView:

    def __init__(self, root):

        self.root = root
        self.controller = KeyboardController()

        root.title("Keyboard Management")

        tk.Label(root, text="ID").grid(row=0,column=0)
        tk.Label(root, text="Name").grid(row=1,column=0)
        tk.Label(root, text="Price").grid(row=2,column=0)
        tk.Label(root, text="Key Count").grid(row=3,column=0)

        self.txt_id = tk.Entry(root)
        self.txt_name = tk.Entry(root)
        self.txt_price = tk.Entry(root)
        self.txt_keys = tk.Entry(root)

        self.txt_id.grid(row=0,column=1)
        self.txt_name.grid(row=1,column=1)
        self.txt_price.grid(row=2,column=1)
        self.txt_keys.grid(row=3,column=1)

        tk.Button(
            root,
            text="Save",
            command=self.save
        ).grid(row=4,column=0)

        tk.Button(
            root,
            text="Exit",
            command=root.quit
        ).grid(row=4,column=1)

    def save(self):

        try:

            keyboard = Keyboard(
                self.txt_id.get(),
                self.txt_name.get(),
                self.txt_price.get(),
                self.txt_keys.get()
            )

            self.controller.create(keyboard)

            value = keyboard.calculate_value()

            messagebox.showinfo(
                "Success",
                f"Keyboard saved in MongoDB\nBusiness Value = {value}"
            )

        except Exception as e:

            messagebox.showerror(
                "Error",
                str(e)
            )
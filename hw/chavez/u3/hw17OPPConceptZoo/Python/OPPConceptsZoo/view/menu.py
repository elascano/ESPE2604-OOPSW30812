import tkinter as tk
from tkinter import ttk
from tkinter import messagebox


class Menu:

    def __init__(self, window):

        self.window = window

        self.window.title("OPPConceptsZoo")
        self.window.geometry("450x400")

        tk.Label(
            window,
            text="Farm System",
            font=("Arial", 16)
        ).pack(pady=10)

        tk.Label(window, text="ID").pack()
        self.txt_id = tk.Entry(window)
        self.txt_id.pack()

        tk.Label(window, text="Breed").pack()
        self.txt_breed = tk.Entry(window)
        self.txt_breed.pack()

        tk.Label(window, text="Weight").pack()
        self.txt_weight = tk.Entry(window)
        self.txt_weight.pack()

        tk.Label(window, text="Born On").pack()
        self.txt_born_on = tk.Entry(window)
        self.txt_born_on.pack()

        tk.Label(window, text="Animal").pack()

        self.cmb_animal = ttk.Combobox(
            window,
            values=["Cow", "Pig", "Chicken", "Sheep"]
        )

        self.cmb_animal.pack()

        tk.Button(
            window,
            text="Save",
            command=self.save_animal
        ).pack(pady=15)

    def save_animal(self):

        messagebox.showinfo(
            "Saved",
            "Animal saved successfully"
        )
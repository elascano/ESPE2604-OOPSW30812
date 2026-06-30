import tkinter as tk
from tkinter import ttk, messagebox

from controller.food_controller import FoodController
from model.food import Food


class FrmFood(tk.Tk):

    def __init__(self):
        super().__init__()

        self.controller = FoodController()

        self.title("Food")
        self.geometry("600x400")  # Reducido el tamaño
        self.resizable(False, False)

        self.create_widgets()

    def create_widgets(self):

        # Marco principal centrado
        main_frame = ttk.Frame(self)
        main_frame.pack(expand=True, padx=20, pady=20)

        ttk.Label(main_frame, text="Add Food", font=("Arial", 14, "bold")).grid(row=0, column=0, columnspan=2, pady=15)
        
        ttk.Label(main_frame, text="Id").grid(row=1, column=0, pady=10)

        self.txt_id = ttk.Entry(main_frame, width=25)
        self.txt_id.grid(row=1, column=1)

        ttk.Label(main_frame, text="Type").grid(row=2, column=0, pady=10)

        self.cmb_type = ttk.Combobox(main_frame, state="readonly", width=22,
            values=["Grass", "Hay", "Corn", "Mixed Feed"]
        )

        self.cmb_type.current(0)
        self.cmb_type.grid(row=2, column=1)

        button_frame = ttk.Frame(main_frame)
        button_frame.grid(row=3, column=0, columnspan=2, pady=30)

        ttk.Button(button_frame, text="Save", command=self.btn_save).grid(row=0, column=0, padx=5)
        ttk.Button(button_frame, text="Clear", command=self.clear).grid(row=0, column=1, padx=5)
        ttk.Button(button_frame, text="Back", command=self.back_to_menu).grid(row=0, column=2, padx=5)

    def clear(self):
        self.txt_id.delete(0, tk.END)
        self.cmb_type.current(0)

    def btn_save(self):
        try:
            id = int(self.txt_id.get())
            food = Food(id, self.cmb_type.get())

            if self.controller.find_by_id(id):
                messagebox.showerror("Error", "Food ID already exists")
                return

            self.controller.create(food)
            messagebox.showinfo("Success", "Food saved successfully!")
            self.clear()
        except ValueError:
            messagebox.showerror("Error", "Please enter a valid ID")

    def back_to_menu(self):
        from view.frm_menu import FrmMenu

        self.destroy()
        FrmMenu().mainloop()
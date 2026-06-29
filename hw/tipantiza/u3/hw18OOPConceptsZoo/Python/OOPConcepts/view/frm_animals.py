import tkinter as tk
from tkinter import ttk
from tkinter import messagebox

from datetime import datetime


from model.chicken import Chicken
from model.cow import Cow
from model.pig import Pig
from model.sheep import Sheep
from controller.animal_controller import AnimalController

from view.panels.pnl_chicken import ChickenPanel
from view.panels.pnl_cow import CowPanel
from view.panels.pnl_pig import PigPanel
from view.panels.pnl_sheep import SheepPanel


class FrmAnimals(tk.Tk):

    def __init__(self):
        super().__init__()

        self.controller = AnimalController()

        self.title("Animals")
        self.geometry("600x650")  # Reducido el tamaño
        self.resizable(False, False)

        self.create_widgets()

    def create_widgets(self):

        # ==========================
        # Main Frame
        # ==========================

        main_frame = ttk.Frame(self)
        main_frame.pack(expand=True, padx=20, pady=20)

        ttk.Label(
            main_frame,
            text="Animals",
            font=("Arial", 14, "bold")
        ).grid(row=0, column=0, columnspan=2, pady=10)

        ttk.Label(main_frame, text="Animal Type").grid(row=1, column=0, sticky="w")

        self.cmb_type = ttk.Combobox(
            main_frame,
            values=["Chicken", "Cow", "Pig", "Sheep"],
            state="readonly",
            width=25
        )

        self.cmb_type.current(0)

        self.cmb_type.grid(
            row=1,
            column=1,
            pady=5
        )

        self.cmb_type.bind(
            "<<ComboboxSelected>>",
            self.change_panel
        )

        ttk.Label(main_frame, text="Id").grid(row=2, column=0, sticky="w")
        self.txt_id = ttk.Entry(main_frame, width=28)
        self.txt_id.grid(row=2, column=1, pady=5)

        ttk.Label(main_frame, text="Breed").grid(row=3, column=0, sticky="w")
        self.txt_breed = ttk.Entry(main_frame, width=28)
        self.txt_breed.grid(row=3, column=1, pady=5)

        ttk.Label(main_frame, text="Born On Date").grid(row=4, column=0, sticky="w")
        self.txt_birth = ttk.Entry(main_frame, width=28)
        self.txt_birth.grid(row=4, column=1, pady=5)

        ttk.Label(main_frame, text="Weight").grid(row=5, column=0, sticky="w")
        self.txt_weight = ttk.Entry(main_frame, width=28)
        self.txt_weight.grid(row=5, column=1, pady=5)

        # ==========================
        # Specific Panel
        # ==========================

        self.panel_container = ttk.Frame(main_frame)

        self.panel_container.grid(
            row=6,
            column=0,
            columnspan=2,
            pady=20,
            sticky="ew"
        )

        self.pnl_chicken = ChickenPanel(self.panel_container)
        self.pnl_cow = CowPanel(self.panel_container)
        self.pnl_pig = PigPanel(self.panel_container)
        self.pnl_sheep = SheepPanel(self.panel_container)

        self.show_panel(self.pnl_chicken)

        # ==========================
        # Buttons
        # ==========================

        button_frame = ttk.Frame(main_frame)
        button_frame.grid(
            row=7,
            column=0,
            columnspan=2,
            pady=20
        )

        ttk.Button(button_frame, text="Save", width=10, command=self.btn_save).grid(row=0, column=0, padx=5)
        ttk.Button(button_frame, text="Clear", width=10, command=self.clear_form).grid(row=0, column=1, padx=5)
        ttk.Button(button_frame, text="Back", width=10, command=self.back_to_menu).grid(row=0, column=2, padx=5)

    # ====================================================

    def show_panel(self, panel):

        for widget in self.panel_container.winfo_children():
            widget.pack_forget()

        panel.pack(fill="x")

    # ====================================================

    def change_panel(self, event=None):

        animal = self.cmb_type.get()

        if animal == "Chicken":
            self.show_panel(self.pnl_chicken)

        elif animal == "Cow":
            self.show_panel(self.pnl_cow)

        elif animal == "Pig":
            self.show_panel(self.pnl_pig)

        elif animal == "Sheep":
            self.show_panel(self.pnl_sheep)

    def clear_form(self):

        self.txt_id.delete(0, tk.END)
        self.txt_breed.delete(0, tk.END)
        self.txt_birth.delete(0, tk.END)
        self.txt_weight.delete(0, tk.END)

        # Limpiar campos específicos de cada panel
        self.pnl_chicken.is_molting.set(False)
        self.pnl_chicken.sld_number_of_eggs.set(0)
        
        self.pnl_cow.is_producing_milk.set(False)
        
        self.pnl_pig.txt_ideal_weight.delete(0, tk.END)
        self.pnl_pig.txt_ideal_weight.insert(0, "0.0")
        
        self.pnl_sheep.txt_last_shearing.delete(0, tk.END)

        self.cmb_type.current(0)
        self.change_panel()

    def create_animal_from_form(self):

        animal_type = self.cmb_type.get()

        id = int(self.txt_id.get())
        breed = self.txt_breed.get()
        born_on_date = datetime.strptime(self.txt_birth.get(), "%m/%d/%Y")
        weight = float(self.txt_weight.get())

        if animal_type == "Chicken":

            return Chicken(id, breed, born_on_date, weight, 
                          self.pnl_chicken.is_molting.get(),
                          int(self.pnl_chicken.sld_number_of_eggs.get())
            )
        
        elif animal_type == "Cow":

            return Cow(id, breed, born_on_date, weight, 
                      self.pnl_cow.is_producing_milk.get())

        elif animal_type == "Pig":

            return Pig(id, breed, born_on_date, weight, 
                      float(self.pnl_pig.txt_ideal_weight.get()))
        
        else:

            last_shearing = datetime.strptime(self.pnl_sheep.txt_last_shearing.get(), "%m/%d/%Y")

            return Sheep(id, breed, born_on_date, weight, last_shearing)
        
    def btn_save(self):

        try:
            animal = self.create_animal_from_form()

            if self.controller.create(animal):
                messagebox.showinfo("Success", "Animal saved.")
                self.clear_form()

            else:
                messagebox.showerror("Error", "ID already exists.")

        except Exception as e:
            messagebox.showerror("Error", str(e))

    def btn_delete(self):

        try:
            id = int(self.txt_id.get())

            if self.controller.delete(id):
                messagebox.showinfo("Success", "Animal deleted.")
                self.clear_form()

            else:
                messagebox.showerror("Error", "Animal not found.")

        except Exception as e:
            messagebox.showerror("Error", str(e))

    def back_to_menu(self):

        from view.frm_menu import FrmMenu

        self.destroy()
        FrmMenu().mainloop()
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
        self.geometry("1000x650")
        self.resizable(False, False)

        self.create_widgets()

        self.load_animals()


        

    def create_widgets(self):

        # ==========================
        # Left Frame
        # ==========================

        left_frame = ttk.Frame(self)
        left_frame.pack(side="left", fill="both", padx=20, pady=20)

        ttk.Label(
            left_frame,
            text="Animals",
            font=("Arial", 14, "bold")
        ).grid(row=0, column=0, columnspan=2, pady=10)

        ttk.Label(left_frame, text="Animal Type").grid(row=1, column=0, sticky="w")

        self.cmb_type = ttk.Combobox(
            left_frame,
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

        ttk.Label(left_frame, text="Id").grid(row=2, column=0, sticky="w")
        self.txt_id = ttk.Entry(left_frame, width=28)
        self.txt_id.grid(row=2, column=1, pady=5)

        ttk.Label(left_frame, text="Breed").grid(row=3, column=0, sticky="w")
        self.txt_breed = ttk.Entry(left_frame, width=28)
        self.txt_breed.grid(row=3, column=1, pady=5)

        ttk.Label(left_frame, text="Born On Date").grid(row=4, column=0, sticky="w")
        self.txt_birth = ttk.Entry(left_frame, width=28)
        self.txt_birth.grid(row=4, column=1, pady=5)

        ttk.Label(left_frame, text="Weight").grid(row=5, column=0, sticky="w")
        self.txt_weight = ttk.Entry(left_frame, width=28)
        self.txt_weight.grid(row=5, column=1, pady=5)

        # ==========================
        # Specific Panel
        # ==========================

        self.panel_container = ttk.Frame(left_frame)

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

        button_frame = ttk.Frame(left_frame)
        button_frame.grid(
            row=7,
            column=0,
            columnspan=2,
            pady=20
        )

        ttk.Button(button_frame, text="Save", width=10, command=self.btn_save).grid(row=0, column=0, padx=5)
        ttk.Button(button_frame, text="Update", width=10, command=self.btn_update).grid(row=0, column=1, padx=5)
        ttk.Button(button_frame, text="Delete", width=10, command=self.btn_delete).grid(row=0, column=2, padx=5)
        ttk.Button(button_frame, text="Clear", width=10, command=self.clear_form).grid(row=0, column=3, padx=5)
        ttk.Button(button_frame, text="Back", width=10, command=self.back_to_menu).grid(row=0, column=4, padx=5)

        # ==========================
        # Right Frame
        # ==========================

        right_frame = ttk.Frame(self)
        right_frame.pack(
            side="right",
            fill="both",
            expand=True,
            padx=20,
            pady=20
        )

        columns = (
            "ID",
            "Type",
            "Breed",
            "Birth",
            "Weight"
        )

        self.table = ttk.Treeview(
            right_frame,
            columns=columns,
            show="headings",
            height=20
        )

        self.table.bind(
            "<<TreeviewSelect>>",
            self.select_animal
        )

        for column in columns:
            self.table.heading(column, text=column)
            self.table.column(column, width=100)

        self.table.pack(fill="both", expand=True)

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

    def load_animals(self):

        for item in self.table.get_children():
            self.table.delete(item)

        animals = self.controller.read()

        for animal in animals:

            self.table.insert(
                "",
                tk.END,
                values=(

                    animal.id,
                    animal.__class__.__name__,
                    animal.breed,
                    animal.born_on_date,
                    animal.weight

                )
            )

    def select_animal(self,event):

        selected = self.table.selection()

        if not selected:
            return

        values = self.table.item(
            selected[0],
            "values"
        )

        animal = self.controller.find_by_id(
            int(values[0])
        )

        self.load_animal(animal)

    def load_animal(self,animal):

        self.txt_id.delete(0,tk.END)
        self.txt_id.insert(0,animal.id)

        self.txt_breed.delete(0,tk.END)
        self.txt_breed.insert(0,animal.breed)

        self.txt_birth.delete(0,tk.END)
        self.txt_birth.insert(0,animal.born_on_date)

        self.txt_weight.delete(0,tk.END)
        self.txt_weight.insert(0,animal.weight)

        # Chicken
        if isinstance(animal, Chicken):

            self.cmb_type.set("Chicken")
            self.show_panel(self.pnl_chicken)

            self.pnl_chicken.is_molting.set(
                animal.is_molting
            )

            self.pnl_chicken.sld_number_of_eggs.set(
                animal.number_of_eggs
            )

        # Cow
        elif isinstance(animal, Cow):

            self.cmb_type.set("Cow")
            self.show_panel(self.pnl_cow)

            self.pnl_cow.is_producing_milk.set(
                animal.is_producing_milk
            )

        # Pig
        elif isinstance(animal, Pig):

            self.cmb_type.set("Pig")
            self.show_panel(self.pnl_pig)

            self.pnl_pig.txt_ideal_weight.delete(0, tk.END)
            self.pnl_pig.txt_ideal_weight.insert(
                0,
                animal.ideal_weight
            )

        # Sheep
        elif isinstance(animal, Sheep):

            self.cmb_type.set("Sheep")
            self.show_panel(self.pnl_sheep)

            self.pnl_sheep.txt_last_shearing.delete(0, tk.END)
            self.pnl_sheep.txt_last_shearing.insert(
                0,
                animal.last_shearing
            )

    def clear_form(self):

        self.txt_id.delete(0, tk.END)
        self.txt_breed.delete(0, tk.END)
        self.txt_birth.delete(0, tk.END)
        self.txt_weight.delete(0, tk.END)

        self.cmb_type.current(0)

        self.change_panel()

    def create_animal_from_form(self):

        animal_type = self.cmb_type.get()

        id = int(self.txt_id.get())
        breed = self.txt_breed.get()
        born_on_date = datetime.strptime(self.txt_birth.get(),"%m/%d/%Y")
        weight = float(self.txt_weight.get())

        if animal_type == "Chicken":

            return Chicken(id,breed, born_on_date, weight, self.pnl_chicken.is_molting.get(),
                           int(self.pnl_chicken.sld_number_of_eggs.get())
            )
        
        elif animal_type == "Cow":

            return Cow(id, breed, born_on_date, weight, self.pnl_cow.is_producing_milk.get())

        elif animal_type == "Pig":

            return Pig(id,breed, born_on_date, weight, float(self.pnl_pig.txt_ideal_weight.get()))
        
        else:

            last_shearing = datetime.strptime(self.pnl_sheep.txt_last_shearing.get(), "%m/%d/%Y")

            return Sheep(id, breed, born_on_date, weight, last_shearing)
        
    def btn_save(self):

        try:
            animal = self.create_animal_from_form()

            if self.controller.create(animal):
                messagebox.showinfo("Success","Animal saved.")

                self.load_animals()
                self.clear_form()

            else:

                messagebox.showerror("Error","ID already exists.")

        except Exception as e:

            messagebox.showerror("Error",str(e))

    def btn_update(self):

        try:

            animal = self.create_animal_from_form()

            if self.controller.update(animal):
                messagebox.showinfo("Success", "Animal updated.")
                self.load_animals()

            else:

                messagebox.showerror("Error", "Animal not found.")

        except Exception as e:

            messagebox.showerror("Error", str(e))

    def btn_delete(self):

        try:

            id = int(self.txt_id.get())

            if self.controller.delete(id):

                messagebox.showinfo("Success", "Animal deleted.")
                self.load_animals()
                self.clear_form()

            else:

                messagebox.showerror("Error", "Animal not found.")

        except Exception as e:

            messagebox.showerror("Error", str(e))

    def back_to_menu(self):

        from view.frm_menu import FrmMenu

        self.destroy()
        FrmMenu().mainloop()


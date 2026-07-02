import tkinter as tk
from tkinter import ttk
from tkinter import messagebox

from controller.animal_controller import AnimalController
from controller.food_controller import FoodController
from controller.cut_controller import CutController


class FrmAnimalOperations(tk.Tk):

    def __init__(self):
        super().__init__()

        self.animal_controller = AnimalController()
        self.food_controller = FoodController()

        self.title("Animal Operations")
        self.geometry("1100x650")
        self.resizable(False, False)

        self.create_widgets()

        self.load_animal_table()
        self.load_food_combobox()

        self.table.bind(
            "<<TreeviewSelect>>",
            self.select_animal
        )

    def create_widgets(self):

        left_frame = ttk.Frame(self)
        left_frame.pack(side="left", fill="both", padx=20, pady=20)

        ttk.Label(left_frame,text="Animal Operations",font=("Arial", 14, "bold")).grid(row=0, column=0, columnspan=3, pady=15)

        ttk.Label(left_frame, text="Id:").grid(row=1, column=0, sticky="w")
        self.lbl_id = ttk.Label(left_frame, text="-")
        self.lbl_id.grid(row=1, column=1, sticky="w")

        ttk.Label(left_frame, text="Type:").grid(row=2, column=0, sticky="w")
        self.lbl_type = ttk.Label(left_frame, text="-")
        self.lbl_type.grid(row=2, column=1, sticky="w")

        ttk.Label(left_frame,text="Age in Months:").grid(row=3, column=0, pady=20, sticky="w")
        self.lbl_age = ttk.Label(left_frame, text="-")
        self.lbl_age.grid(row=3, column=1, sticky="w")

        self.btn_calculate = ttk.Button(left_frame,text="Calculate",command=self.calculate_age)
        self.btn_calculate.grid(row=3, column=2, padx=15)

        ttk.Label(left_frame,text="Available Food:").grid(row=4, column=0, pady=10, sticky="w")

        self.cmb_food = ttk.Combobox(left_frame,width=25,state="readonly")
        self.cmb_food.grid(row=4, column=1)
        
        self.btn_feed = ttk.Button(left_frame,text="Feed",command=self.feed)
        self.btn_feed.grid(row=4,column=2,padx=15)

        separator = ttk.Separator(left_frame,orient="horizontal")
        separator.grid(row=5,column=0,columnspan=3,sticky="ew",pady=20)

        self.lbl_title = ttk.Label(left_frame,text="-",font=("Arial", 12, "bold"))
        self.lbl_title.grid(row=6,column=0,columnspan=3,pady=10)

        self.lbl_attribute1 = ttk.Label(left_frame,text="Attribute 1:")
        self.lbl_attribute1.grid(row=7,column=0,sticky="w",pady=5)

        self.lbl_value1 = ttk.Label(left_frame,text="-")
        self.lbl_value1.grid(row=7,column=1,sticky="w")

        self.lbl_attribute2 = ttk.Label(left_frame,text="Attribute 2:")
        self.lbl_attribute2.grid(row=8,column=0,sticky="w",pady=5)

        self.lbl_value2 = ttk.Label(left_frame,text="-")
        self.lbl_value2.grid(row=8,column=1,sticky="w")

        self.btn_operation1 = ttk.Button(left_frame)
        self.btn_operation1.grid(row=9,column=0,pady=20)

        self.btn_operation2 = ttk.Button(left_frame)
        self.btn_operation2.grid(row=9,column=1,pady=20)

        self.btn_operation1.grid_remove()
        self.btn_operation2.grid_remove()

        right_frame = ttk.Frame(self)
        right_frame.pack(side="right",fill="both",expand=True,padx=20,pady=20)

        ttk.Label(right_frame,text="Animal Table",font=("Arial", 12, "bold")).pack(anchor="w")

        columns = ("ID","Type","Breed","Birth","Weight")

        self.table = ttk.Treeview(right_frame,columns=columns,show="headings",height=20)

        for column in columns:

            self.table.heading(column, text=column)
            self.table.column(column, width=100)

        self.table.pack(fill="both",expand=True,pady=10)

        bottom = ttk.Frame(self)
        bottom.pack(fill="x",padx=20,pady=15)

        self.btn_clear = ttk.Button(bottom,text="Clear",command=self.clear)
        self.btn_clear.pack(side="left")

        self.btn_back = ttk.Button(bottom,text="Back To Menu", command=self.back_to_menu)
        self.btn_back.pack(side="right")

    def load_animal_table(self):

        for item in self.table.get_children():
            self.table.delete(item)

        animals = self.animal_controller.read()

        for animal in animals:

            self.table.insert("", tk.END,
                values=(
                    animal.id,
                    animal.__class__.__name__,
                    animal.breed,
                    animal.born_on_date.strftime("%m/%d/%Y"),
                    animal.weight
                )
            )

    def load_food_combobox(self):

        foods = self.food_controller.read()
        self.foods = foods
        values = []

        for food in foods:
            values.append(
                f"{food.id} - {food.type_of_food}"
            )

        self.cmb_food["values"] = values

        if values:
            self.cmb_food.current(0)

    def clear(self):

        self.lbl_id.config(text="-")
        self.lbl_type.config(text="-")
        self.lbl_age.config(text="-")

        self.lbl_title.config(text="-")

        self.lbl_attribute1.config(text="Attribute 1:")
        self.lbl_value1.config(text="-")

        self.lbl_attribute2.config(text="Attribute 2:")
        self.lbl_value2.config(text="-")

        self.btn_operation1.grid_remove()
        self.btn_operation2.grid_remove()

    def select_animal(self, event):

        selected = self.table.selection()

        if not selected:
            return

        values = self.table.item(selected[0], "values")

        id = int(values[0])
        animal = self.animal_controller.find_by_id(id)
        self.load_animal(animal)

    def load_animal(self, animal):

        self.lbl_id.config(text=str(animal.id))
        self.lbl_type.config(text=animal.__class__.__name__)
        self.lbl_age.config(text="-")

        if animal.__class__.__name__ == "Chicken":

            self.lbl_title.config(text="Chicken")
            self.lbl_attribute1.config(text="Number Of Eggs:")
            self.lbl_value1.config(text=str(animal.number_of_eggs))
            self.lbl_attribute2.config(text="Is Molting:")
            self.lbl_value2.config(text=str(animal.is_molting))

            self.btn_operation1.grid()
            self.btn_operation1.config(text="Lay An Egg",command=self.lay_an_egg)

            self.btn_operation2.grid_remove()

        elif animal.__class__.__name__ == "Cow":

            self.lbl_title.config(text="Cow")
            self.lbl_attribute1.config(text="Producing Milk:")
            self.lbl_value1.config(text=str(animal.is_producing_milk))
            self.lbl_attribute2.config(text="")
            self.lbl_value2.config(text="")

            self.btn_operation1.grid()
            self.btn_operation1.config(text="Milk",command=self.milk)

            self.btn_operation2.grid()
            self.btn_operation2.config(text="Cut",command=self.cut_cow)

        elif animal.__class__.__name__ == "Pig":

            self.lbl_title.config(text="Pig")
            self.lbl_attribute1.config(text="Weight:")
            self.lbl_value1.config(text=str(animal.weight))
            self.lbl_attribute2.config(text="Ideal Weight:")
            self.lbl_value2.config(text=str(animal.ideal_weight))

            self.btn_operation1.grid()
            self.btn_operation1.config(text="Cut",command=self.cut_pig)

            self.btn_operation2.grid_remove()

        elif animal.__class__.__name__ == "Sheep":

            self.lbl_title.config(text="Sheep")
            self.lbl_attribute1.config(text="Last Shearing:")
            self.lbl_value1.config(text=animal.last_shearing.strftime("%m/%d/%Y"))
            self.lbl_attribute2.config(text="")
            self.lbl_value2.config(text="")

            self.btn_operation1.grid_remove()
            self.btn_operation2.grid_remove()

    def calculate_age(self):

        if self.lbl_id.cget("text") == "-":

            messagebox.showwarning("Warning","Select an animal.")

            return

        animal = self.animal_controller.find_by_id(

            int(self.lbl_id.cget("text"))

        )

        self.lbl_age.config(

            text=str(animal.get_age_in_months())

        )
        
    def feed(self):

        if self.lbl_id.cget("text") == "-":

            messagebox.showwarning(
                "Warning",
                "Select an animal."
            )

            return

        animal = self.animal_controller.find_by_id(

            int(self.lbl_id.cget("text"))

        )

        food = self.foods[

            self.cmb_food.current()

        ]

        if animal.feed(food):

            self.animal_controller.update(animal)

            self.food_controller.delete(food.id)

            messagebox.showinfo(

                "Success",

                "Animal fed."

            )

            self.load_food_combobox()

            self.load_animal_table()

            self.load_animal(animal)

        else:

            messagebox.showerror(

                "Error",

                f"{animal.__class__.__name__} cannot eat {food.type_of_food}"

            )

    def lay_an_egg(self):

        animal = self.animal_controller.find_by_id(

            int(self.lbl_id.cget("text"))

        )

        if animal.lay_an_egg():

            messagebox.showwarning(

                "Chicken",

                "Chicken is molting."

            )

        else:

            self.animal_controller.update(animal)

            messagebox.showinfo(

                "Chicken",

                "A new egg has been laid."

            )

            self.load_animal(animal)

            self.load_animal_table()

    def milk(self):

        animal = self.animal_controller.find_by_id(

            int(self.lbl_id.cget("text"))

        )

        quantity = animal.milk()

        if quantity == 0:

            messagebox.showwarning(

                "Cow",

                "This cow does not produce milk."

            )

        else:

            messagebox.showinfo(

                "Milk",

                f"Milk produced: {quantity:.2f} liters"

            )

    def cut_pig(self):

        animal = self.animal_controller.find_by_id(

            int(self.lbl_id.cget("text"))

        )

        if not animal.send_to_butcher():

            messagebox.showwarning(

                "Pig",

                "The pig has not reached its ideal weight."

            )

            return

        cut_controller = CutController()

        cuts = animal.cut()

        for cut in cuts:

            cut_controller.create(cut)

        self.animal_controller.delete(animal.id)

        messagebox.showinfo(

            "Pig",

            f"{len(cuts)} cuts generated."

        )

        self.load_animal_table()

        self.clear()

    def cut_cow(self):

        animal = self.animal_controller.find_by_id(

            int(self.lbl_id.cget("text"))

        )

        cut_controller = CutController()

        cuts = animal.cut()

        for cut in cuts:

            cut_controller.create(cut)

        self.animal_controller.delete(

            animal.id

        )

        messagebox.showinfo(

            "Cow",

            f"{len(cuts)} cuts generated."

        )

        self.load_animal_table()

        self.clear()

    def back_to_menu(self):

        from view.frm_menu import FrmMenu

        self.destroy()

        FrmMenu().mainloop()



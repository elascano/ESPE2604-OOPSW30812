import tkinter as tk
from tkinter import ttk, messagebox

from controller.food_controller import FoodController
from model.food import Food




class FrmFood(tk.Tk):

    def __init__(self):
        super().__init__()

        self.controller = FoodController()

        self.title("Food")
        self.geometry("900x600")
        self.resizable(False, False)

        self.create_widgets()

        self.load_food_table()

    def create_widgets(self):

        left_frame = ttk.Frame(self)
        left_frame.pack(side="left", padx=20, pady=20)

        ttk.Label(left_frame,text="Add Food",font=("Arial", 14, "bold")).grid(row=0,column=0,columnspan=2,pady=15)
        ttk.Label(left_frame,text="Id").grid(row=1,column=0,pady=10)

        self.txt_id = ttk.Entry(left_frame,width=25)
        self.txt_id.grid(row=1,column=1)

        ttk.Label(left_frame,text="Type").grid(row=2,column=0,pady=10)

        self.cmb_type = ttk.Combobox(left_frame,state="readonly",width=22,
            values=["Grass","Hay","Corn","Mixed Feed"]
        )

        self.cmb_type.current(0)
        self.cmb_type.grid(row=2,column=1)

        button_frame = ttk.Frame(left_frame)
        button_frame.grid(row=3,column=0,columnspan=2,pady=30)

        ttk.Button(button_frame,text="Save",command=self.btn_save).grid(row=0,column=0,padx=5)
        ttk.Button(button_frame,text="Update",command=self.btn_update).grid(row=0,column=1,padx=5)
        ttk.Button(button_frame,text="Delete",command=self.btn_delete).grid(row=0,column=2,padx=5)
        ttk.Button(button_frame,text="Clear",command=self.clear).grid(row=0,column=3,padx=5)
        ttk.Button(button_frame,text="Back",command=self.back_to_menu).grid(row=0,column=4,padx=5)

        right_frame = ttk.Frame(self)
        right_frame.pack(side="right",padx=20,pady=20,fill="both",expand=True)

        self.table = ttk.Treeview(right_frame,columns=("ID","Type"),show="headings",height=20)

        self.table.heading("ID",text="ID")
        self.table.heading("Type",text="Type")

        self.table.column("ID",width=80)
        self.table.column("Type",width=220)

        self.table.pack(fill="both",expand=True)

        self.table.bind(
            "<<TreeviewSelect>>",
            self.select_food
        )

    def clear(self):

        self.txt_id.delete(0,tk.END)
        self.cmb_type.current(0)

    def load_food_table(self):

        for item in self.table.get_children():
            self.table.delete(item)

        foods = self.controller.read()

        for food in foods:
            self.table.insert("", tk.END, values=(food.id,food.type_of_food))

    def btn_save(self):

        id = int(self.txt_id.get())
        food = Food(id, self.cmb_type.get())

        if self.controller.find_by_id(id):

            messagebox.showerror("Error","Food ID already exists")

            return

        self.controller.create(food)
        self.load_food_table()
        self.clear()

    def btn_update(self):

        food = Food(int(self.txt_id.get()), self.cmb_type.get())

        self.controller.update(food)
        self.load_food_table()
        self.clear()

    def btn_delete(self):

        self.controller.delete(int(self.txt_id.get()))

        self.load_food_table()
        self.clear()

    def select_food(self,event):

        selected = self.table.selection()

        if not selected:
            return

        values = self.table.item(selected[0], "values")

        self.txt_id.delete(0,tk.END)
        self.txt_id.insert(0, values[0])
        self.cmb_type.set(values[1])

    def back_to_menu(self):

        from view.frm_menu import FrmMenu

        self.destroy()
        FrmMenu().mainloop()


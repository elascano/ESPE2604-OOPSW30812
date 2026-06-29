import tkinter as tk
from tkinter import ttk, messagebox, simpledialog
from controller.farm_controller import FarmController


class FarmView:
    def __init__(self, root):
        self.root = root
        self.root.title("Farm MVC System")

        self.controller = FarmController()
        self.animal_type = tk.StringVar()

        self.build_ui()

    def build_ui(self):
        top = tk.Frame(self.root)
        top.pack()

        ttk.Combobox(top, textvariable=self.animal_type,
                     values=["Pig", "Cow", "Chicken", "Sheep"]).grid(row=0, column=0)

        tk.Button(top, text="LOAD", command=self.load).grid(row=0, column=1)

        form = tk.Frame(self.root)
        form.pack()

        tk.Label(form, text="ID").grid(row=0, column=0)
        tk.Label(form, text="Breed").grid(row=1, column=0)
        tk.Label(form, text="Age (months)").grid(row=2, column=0)
        tk.Label(form, text="Weight").grid(row=3, column=0)

        self.id_entry = tk.Entry(form)
        self.breed_entry = tk.Entry(form)
        self.age_entry = tk.Entry(form)
        self.weight_entry = tk.Entry(form)

        self.id_entry.grid(row=0, column=1)
        self.breed_entry.grid(row=1, column=1)
        self.age_entry.grid(row=2, column=1)
        self.weight_entry.grid(row=3, column=1)

        btns = tk.Frame(self.root)
        btns.pack()

        tk.Button(btns, text="CREATE", command=self.create).grid(row=0, column=0)
        tk.Button(btns, text="UPDATE", command=self.update).grid(row=0, column=1)
        tk.Button(btns, text="DELETE", command=self.delete).grid(row=0, column=2)

        actions = tk.Frame(self.root)
        actions.pack()

        tk.Button(actions, text="MILK", command=self.milk).grid(row=0, column=0)
        tk.Button(actions, text="EGG", command=self.egg).grid(row=0, column=1)
        tk.Button(actions, text="CUT", command=self.cut).grid(row=0, column=2)
        tk.Button(actions, text="SHEAR", command=self.shear).grid(row=0, column=3)

        self.tree = ttk.Treeview(self.root, columns=("id", "breed", "age", "weight"), show="headings")
        self.tree.heading("id", text="ID")
        self.tree.heading("breed", text="Breed")
        self.tree.heading("age", text="Age (months)")
        self.tree.heading("weight", text="Weight")
        self.tree.pack(fill="both", expand=True)

    def get_data(self):
        return {
            "id": int(self.id_entry.get()),
            "breed": self.breed_entry.get(),
            "age_in_months": int(self.age_entry.get()),
            "weight": float(self.weight_entry.get()),
            "history": []
        }

    def create(self):
        self.controller.create(self.animal_type.get(), self.get_data())
        self.load()

    def load(self):
        data = self.controller.read(self.animal_type.get())
        self.tree.delete(*self.tree.get_children())

        for d in data:
            self.tree.insert("", "end", values=(
                d["id"],
                d["breed"],
                d["age_in_months"],
                d["weight"]
            ))

    def update(self):
        self.controller.update(self.animal_type.get(), self.get_data())
        self.load()

    def delete(self):
        self.controller.delete(self.animal_type.get(), int(self.id_entry.get()))
        self.load()

    def ask_id(self):
        return simpledialog.askinteger("ID", "Animal ID")

    def milk(self):
        if self.animal_type.get() != "Cow":
            return
        i = self.ask_id()
        if i is None:
            return
        self.controller.action("Cow", i, "milk", "milk")
        messagebox.showinfo("OK", f"Cow {i} milked")

    def egg(self):
        if self.animal_type.get() != "Chicken":
            return
        i = self.ask_id()
        if i is None:
            return
        self.controller.action("Chicken", i, "egg", "egg")
        messagebox.showinfo("OK", f"Chicken {i} egg")

    def cut(self):
        i = self.ask_id()
        if i is None:
            return
        self.controller.action(self.animal_type.get(), i, "cut", "cut")
        messagebox.showinfo("OK", f"Animal {i} cut")

    def shear(self):
        if self.animal_type.get() != "Sheep":
            return
        i = self.ask_id()
        if i is None:
            return
        self.controller.action("Sheep", i, "shear", "shear")
        messagebox.showinfo("OK", f"Sheep {i} sheared")
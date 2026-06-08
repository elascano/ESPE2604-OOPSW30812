import tkinter as tk
from tkinter import ttk

from dao.combo_dao import ComboDAO
from model.combo import Combo


class ComboPanel(tk.Frame):

    def __init__(self, parent):
        super().__init__(parent)

        self.dao = ComboDAO()

        tk.Label(self, text="ID").grid(row=0, column=0)
        self.txt_id = tk.Entry(self)
        self.txt_id.grid(row=0, column=1)

        tk.Label(self, text="Name").grid(row=1, column=0)
        self.txt_name = tk.Entry(self)
        self.txt_name.grid(row=1, column=1)

        tk.Label(self, text="Description").grid(row=2, column=0)
        self.txt_description = tk.Entry(self)
        self.txt_description.grid(row=2, column=1)

        tk.Label(self, text="Price").grid(row=3, column=0)
        self.txt_price = tk.Entry(self)
        self.txt_price.grid(row=3, column=1)

        self.table = ttk.Treeview(
            self,
            columns=("ID", "Name", "Description", "Price"),
            show="headings"
        )

        for col in ("ID", "Name", "Description", "Price"):
            self.table.heading(col, text=col)

        self.table.grid(row=4, column=0, columnspan=4, sticky="nsew")

        tk.Button(self, text="Add", command=self.add_combo).grid(row=5, column=0)
        tk.Button(self, text="Delete", command=self.delete_combo).grid(row=5, column=1)
        tk.Button(self, text="Refresh", command=self.load_data).grid(row=5, column=2)

        self.load_data()

    def add_combo(self):

        combo = Combo(
            int(self.txt_id.get()),
            self.txt_name.get(),
            self.txt_description.get(),
            float(self.txt_price.get())
        )

        self.dao.save(combo)

        self.load_data()
        self.clear_fields()

    def delete_combo(self):

        selected = self.table.selection()

        if selected:

            values = self.table.item(selected[0])["values"]

            self.dao.delete(int(values[0]))

            self.load_data()

    def load_data(self):

        for item in self.table.get_children():
            self.table.delete(item)

        for combo in self.dao.find_all():

            self.table.insert(
                "",
                tk.END,
                values=(
                    combo["id"],
                    combo["name"],
                    combo["description"],
                    combo["price"]
                )
            )

    def clear_fields(self):

        self.txt_id.delete(0, tk.END)
        self.txt_name.delete(0, tk.END)
        self.txt_description.delete(0, tk.END)
        self.txt_price.delete(0, tk.END)
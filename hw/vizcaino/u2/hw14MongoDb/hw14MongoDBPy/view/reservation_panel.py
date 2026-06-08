import tkinter as tk
from tkinter import ttk

from dao.reservation_dao import ReservationDAO
from model.reservation import Reservation


class ReservationPanel(tk.Frame):

    def __init__(self, parent):
        super().__init__(parent)

        self.dao = ReservationDAO()

        tk.Label(self, text="ID").grid(row=0, column=0)
        self.txt_id = tk.Entry(self)
        self.txt_id.grid(row=0, column=1)

        tk.Label(self, text="Customer Name").grid(row=1, column=0)
        self.txt_customer_name = tk.Entry(self)
        self.txt_customer_name.grid(row=1, column=1)

        tk.Label(self, text="Phone").grid(row=2, column=0)
        self.txt_phone = tk.Entry(self)
        self.txt_phone.grid(row=2, column=1)

        tk.Label(self, text="Status").grid(row=3, column=0)
        self.txt_status = tk.Entry(self)
        self.txt_status.grid(row=3, column=1)

        self.table = ttk.Treeview(
            self,
            columns=("ID", "Customer Name", "Phone", "Status"),
            show="headings"
        )

        for col in ("ID", "Customer Name", "Phone", "Status"):
            self.table.heading(col, text=col)

        self.table.grid(row=4, column=0, columnspan=4, sticky="nsew")

        tk.Button(self, text="Add", command=self.add_reservation).grid(row=5, column=0)
        tk.Button(self, text="Delete", command=self.delete_reservation).grid(row=5, column=1)
        tk.Button(self, text="Refresh", command=self.load_data).grid(row=5, column=2)

        self.load_data()

    def add_reservation(self):

        reservation = Reservation(
            int(self.txt_id.get()),
            self.txt_customer_name.get(),
            self.txt_phone.get(),
            self.txt_status.get()
        )

        self.dao.save(reservation)

        self.load_data()
        self.clear_fields()

    def delete_reservation(self):

        selected = self.table.selection()

        if selected:

            values = self.table.item(selected[0])["values"]

            self.dao.delete(int(values[0]))

            self.load_data()

    def load_data(self):

        for item in self.table.get_children():
            self.table.delete(item)

        for reservation in self.dao.find_all():

            self.table.insert(
                "",
                tk.END,
                values=(
                    reservation["id"],
                    reservation["customerName"],
                    reservation["phone"],
                    reservation["status"]
                )
            )

    def clear_fields(self):

        self.txt_id.delete(0, tk.END)
        self.txt_customer_name.delete(0, tk.END)
        self.txt_phone.delete(0, tk.END)
        self.txt_status.delete(0, tk.END)
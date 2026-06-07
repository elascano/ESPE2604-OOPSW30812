import tkinter as tk
from tkinter import ttk

from dao.backup_dao import BackupDAO
from model.backup import Backup


class BackupPanel(tk.Frame):

    def __init__(self, parent):
        super().__init__(parent)

        self.dao = BackupDAO()

        tk.Label(self, text="ID").grid(row=0, column=0)
        self.txt_id = tk.Entry(self)
        self.txt_id.grid(row=0, column=1)

        tk.Label(self, text="File Name").grid(row=1, column=0)
        self.txt_file_name = tk.Entry(self)
        self.txt_file_name.grid(row=1, column=1)

        tk.Label(self, text="Status").grid(row=2, column=0)
        self.txt_status = tk.Entry(self)
        self.txt_status.grid(row=2, column=1)

        tk.Label(self, text="Date").grid(row=3, column=0)
        self.txt_date = tk.Entry(self)
        self.txt_date.grid(row=3, column=1)

        self.table = ttk.Treeview(
            self,
            columns=("ID", "File Name", "Status", "Date"),
            show="headings"
        )

        for col in ("ID", "File Name", "Status", "Date"):
            self.table.heading(col, text=col)

        self.table.grid(row=4, column=0, columnspan=4, sticky="nsew")

        tk.Button(self, text="Add", command=self.add_backup).grid(row=5, column=0)
        tk.Button(self, text="Delete", command=self.delete_backup).grid(row=5, column=1)
        tk.Button(self, text="Refresh", command=self.load_data).grid(row=5, column=2)

        self.load_data()

    def add_backup(self):

        backup = Backup(
            int(self.txt_id.get()),
            self.txt_file_name.get(),
            self.txt_status.get(),
            self.txt_date.get()
        )

        self.dao.save(backup)

        self.load_data()
        self.clear_fields()

    def delete_backup(self):

        selected = self.table.selection()

        if selected:

            values = self.table.item(selected[0])["values"]

            self.dao.delete(int(values[0]))

            self.load_data()

    def load_data(self):

        for item in self.table.get_children():
            self.table.delete(item)

        for backup in self.dao.find_all():

            self.table.insert(
                "",
                tk.END,
                values=(
                    backup["id"],
                    backup["fileName"],
                    backup["status"],
                    backup["date"]
                )
            )

    def clear_fields(self):

        self.txt_id.delete(0, tk.END)
        self.txt_file_name.delete(0, tk.END)
        self.txt_status.delete(0, tk.END)
        self.txt_date.delete(0, tk.END)
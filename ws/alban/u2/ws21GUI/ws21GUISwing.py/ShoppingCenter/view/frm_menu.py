import tkinter as tk
from tkinter import Menu

class FrmMenu(tk.Toplevel):
    def __init__(self, parent):
        super().__init__(parent)
        self.parent = parent
        self.title("Shopping Center - Menu")
        self.geometry("800x600")
        self.init_components()

    def init_components(self):
        main_menu = Menu(self)
        self.config(menu=main_menu)

        system_menu = Menu(main_menu, tearoff=0)
        system_menu.add_command(label="Quit", command=self.destroy_all)
        main_menu.add_cascade(label="System", menu=system_menu)

        products_menu = Menu(main_menu, tearoff=0)
        products_menu.add_command(label="Buy")
        products_menu.add_command(label="Sell")
        main_menu.add_cascade(label="Products", menu=products_menu)

        reports_menu = Menu(main_menu, tearoff=0)
        reports_sub_menu = Menu(reports_menu, tearoff=0)
        reports_sub_menu.add_command(label="Generate PDF")
        reports_menu.add_cascade(label="Generate", menu=reports_sub_menu)
        main_menu.add_cascade(label="Reports", menu=reports_menu)

        customers_menu = Menu(main_menu, tearoff=0)
        customers_menu.add_command(label="Add to Stock")
        main_menu.add_cascade(label="Customers", menu=customers_menu)

        help_menu = Menu(main_menu, tearoff=0)
        main_menu.add_cascade(label="Help", menu=help_menu)

    def destroy_all(self):
        self.parent.destroy()
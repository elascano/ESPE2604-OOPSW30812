import tkinter as tk
from tkinter import Menu

from view.frm_animals import FrmAnimals
from view.frm_food import FrmFood
from view.frm_animal_operations import FrmAnimalOperations


class FrmMenu(tk.Tk):

    def __init__(self):
        super().__init__()

        self.title("Farm System")
        self.geometry("900x600")
        self.resizable(False, False)

        self.create_menu()
        self.create_widgets()

    def create_menu(self):

        menu_bar = Menu(self)

        file_menu = Menu(menu_bar,tearoff=0)

        manage_menu = Menu(menu_bar,tearoff=0)
        manage_menu.add_command(label="Animals",command=self.open_animals)
        manage_menu.add_command(label="Food",command=self.open_food)

        operations_menu = Menu(menu_bar,tearoff=0)
        operations_menu.add_command(label="Animals",command=self.open_animal_operations)

        menu_bar.add_cascade(label="File",menu=file_menu)
        menu_bar.add_cascade(label="Manage",menu=manage_menu)
        menu_bar.add_cascade(label="Operations",menu=operations_menu)

        self.config(menu=menu_bar)

    def create_widgets(self):

        lbl_title = tk.Label(self,text="Farm System",font=("Arial", 26, "bold italic"))
        lbl_title.place(relx=0.5,rely=0.75,anchor="center")

    def open_animals(self):

        self.destroy()
        FrmAnimals().mainloop()

    def open_food(self):

        self.destroy()
        FrmFood().mainloop()

    def open_animal_operations(self):

        self.destroy()
        FrmAnimalOperations().mainloop()


if __name__ == "__main__":

    app = FrmMenu()

    app.mainloop()
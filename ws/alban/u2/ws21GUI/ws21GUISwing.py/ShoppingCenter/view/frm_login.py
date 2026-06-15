import tkinter as tk
from tkinter import messagebox
from controller.user_controller import UserController
from view.frm_menu import FrmMenu

class FrmLogin(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Login")
        self.geometry("450x400")
        self.user_controller = UserController()
        self.init_components()

    def init_components(self):
        self.lbl_user = tk.Label(self, text="Usuario:")
        self.lbl_user.place(x=30, y=72, width=57, height=20)

        self.txt_user = tk.Entry(self)
        self.txt_user.place(x=105, y=72, width=139, height=20)

        self.lbl_password = tk.Label(self, text="Contraseña:")
        self.lbl_password.place(x=17, y=127, width=69, height=20)

        self.psd_password = tk.Entry(self, show="*")
        self.psd_password.place(x=104, y=127, width=135, height=20)

        self.btn_accept = tk.Button(self, text="Ingresar", command=self.btn_accept_action_performed)
        self.btn_accept.place(x=180, y=226)

    def btn_accept_action_performed(self):
        username_input = self.txt_user.get()
        password_input = self.psd_password.get()

        if self.user_controller.login(username_input, password_input):
            self.withdraw()
            menu_window = FrmMenu(self)
            menu_window.deiconify()
        else:
            messagebox.showerror("Error", "Invalid username or password")
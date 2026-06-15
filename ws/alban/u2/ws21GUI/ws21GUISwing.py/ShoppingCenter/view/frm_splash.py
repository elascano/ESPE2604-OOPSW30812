import tkinter as tk
from view.frm_login import FrmLogin

class FrmSplash(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Shopping Center")
        self.geometry("500x400")
        
        self.after(3000, self._abrir_login)

    def _abrir_login(self):
        self.destroy()
        login_win = FrmLogin()
        login_win.mainloop()
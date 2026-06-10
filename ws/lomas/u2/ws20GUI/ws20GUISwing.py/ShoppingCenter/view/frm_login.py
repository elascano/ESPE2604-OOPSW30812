import tkinter as tk
from tkinter import messagebox
from view.frm_customer import FrmCustomer

class FrmLogin(tk.Toplevel):
    def __init__(self, parent):
        super().__init__(parent)
        self.parent = parent
        self.title("FrmLogin")
        self.geometry("400x450")
        
     
        x = int(self.winfo_screenwidth() / 2 - 200)
        y = int(self.winfo_screenheight() / 2 - 225)
        self.geometry(f"+{x}+{y}")
        
        
        self.protocol("WM_DELETE_WINDOW", self.parent.destroy)
        
        
        frame = tk.Frame(self)
        frame.pack(pady=50, padx=30, fill="both", expand=True)
        
      
        tk.Label(frame, text="Usuario...", font=("Arial", 11)).pack(anchor="w", pady=(10, 2))
        self.txtUsuario = tk.Entry(frame, font=("Arial", 11))
        self.txtUsuario.pack(fill="x", pady=5)
        
        tk.Label(frame, text="Contraseña:", font=("Arial", 11)).pack(anchor="w", pady=(20, 2))
        self.psdPassword = tk.Entry(frame, font=("Arial", 11), show="*") # Oculta los caracteres
        self.psdPassword.pack(fill="x", pady=5)
        
       
        btn_ingresar = tk.Button(frame, text="Ingresar", font=("Arial", 11), command=self._btn_ingresar_action)
        btn_ingresar.pack(pady=40)

    def _btn_ingresar_action(self):
        usuario = self.txtUsuario.get()
        contrasena = self.psdPassword.get()
        
    
        if usuario == "admin" and contrasena == "1234":
            # Abre tu archivo FrmCustomer pasando la raíz
            customer_win = FrmCustomer(self.parent)
            
            
            customer_win.protocol("WM_DELETE_WINDOW", self.parent.destroy)
            
            self.destroy() # Destruye el Login
        else:
            messagebox.showerror("Error de Login", "Usuario o Contraseña incorrectos")
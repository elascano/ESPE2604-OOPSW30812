import tkinter as tk
from view.frm_login import FrmLogin

class FrmSplash(tk.Tk): 
    def __init__(self):
        super().__init__()
        
       
        self.overrideredirect(True)
        self.geometry("550x380")
        
        # Centrar el Splash
        x = int(self.winfo_screenwidth() / 2 - 275)
        y = int(self.winfo_screenheight() / 2 - 190)
        self.geometry(f"+{x}+{y}")
        
      
        self.configure(bg="#e0e0e0")
        
        
        tk.Label(self, text="SHOPPING CENTER", font=("Arial", 20, "bold"), bg="#e0e0e0", fg="#333333").pack(pady=(40, 20))
        
        tk.Label(self, text="(C): Christopher Lomas", font=("Arial", 12), bg="#e0e0e0").pack(pady=5)
        tk.Label(self, text="(R): ESPE", font=("Arial", 12), bg="#e0e0e0").pack(pady=5)
        tk.Label(self, text="License", font=("Arial", 11, "italic"), bg="#e0e0e0", fg="gray").pack(pady=10)
        
        tk.Label(self, text="Cargando sistema...", font=("Arial", 10), bg="#e0e0e0", fg="#666666").pack(side="bottom", pady=20)
        
      
        self.after(5000, self._abrir_login)

    def _abrir_login(self):
        self.withdraw() 
        login_win = FrmLogin(self) 
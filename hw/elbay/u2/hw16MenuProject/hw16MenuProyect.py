import tkinter as tk
from tkinter import messagebox

def validar():
    if txt_usuario.get() == "admin" and txt_pass.get() == "1234":
        messagebox.showinfo("Sistema", "Acceso concedido")
    else:
        messagebox.showerror("Error", "Usuario o contraseña incorrectos")

# Configuración de ventana
ventana = tk.Tk()
ventana.title("Acceso al Sistema")
ventana.geometry("300x200")

tk.Label(ventana, text="Usuario:").pack()
txt_usuario = tk.Entry(ventana)
txt_usuario.pack()

tk.Label(ventana, text="Contraseña:").pack()
txt_pass = tk.Entry(ventana, show="*")
txt_pass.pack()

tk.Button(ventana, text="Ingresar", command=validar).pack()

ventana.mainloop()
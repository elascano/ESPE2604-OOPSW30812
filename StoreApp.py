import tkinter as tk
from tkinter import ttk

def guardar():
    print("Guardado")

ventana = tk.Tk()
ventana.title("Gestión de Estudiantes")
ventana.geometry("500x400")

# ID
tk.Label(ventana, text="ID").grid(row=0, column=0, padx=10, pady=5)
id_entry = tk.Entry(ventana)
id_entry.grid(row=0, column=1)

# Nombre
tk.Label(ventana, text="Nombre").grid(row=1, column=0)
nombre_entry = tk.Entry(ventana)
nombre_entry.grid(row=1, column=1)

# Edad
tk.Label(ventana, text="Edad").grid(row=2, column=0)
edad_scale = tk.Scale(ventana, from_=0, to=100, orient="horizontal")
edad_scale.grid(row=2, column=1)

# Curso
tk.Label(ventana, text="Curso").grid(row=3, column=0)
curso_combo = ttk.Combobox(
    ventana,
    values=["Matemáticas", "Física", "Inglés"]
)
curso_combo.grid(row=3, column=1)

# Botones
tk.Button(ventana, text="Guardar", command=guardar).grid(row=4, column=0)
tk.Button(ventana, text="Buscar").grid(row=4, column=1)
tk.Button(ventana, text="Eliminar").grid(row=4, column=2)

# Tabla
tabla = ttk.Treeview(
    ventana,
    columns=("ID", "Nombre", "Edad", "Curso"),
    show="headings"
)

for col in ("ID", "Nombre", "Edad", "Curso"):
    tabla.heading(col, text=col)

tabla.grid(row=5, column=0, columnspan=3)

ventana.mainloop()
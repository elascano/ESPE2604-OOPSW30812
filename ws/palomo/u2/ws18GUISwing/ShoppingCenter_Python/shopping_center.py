"""
shopping_center.py
Punto de entrada principal - abre la ventana Customer
@author Cristian (convertido a Python)
"""
import tkinter as tk
from customer_form import CustomerForm


def main():
    root = tk.Tk()
    app = CustomerForm(root)
    root.mainloop()


if __name__ == "__main__":
    main()

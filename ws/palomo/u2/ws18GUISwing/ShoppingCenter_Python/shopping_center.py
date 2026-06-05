"""
shopping_center.py
@author Cristian
"""
import tkinter as tk
from customer_form import CustomerForm


def main():
    root = tk.Tk()
    app = CustomerForm(root)
    root.mainloop()


if __name__ == "__main__":
    main()

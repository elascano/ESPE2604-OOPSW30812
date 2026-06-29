import tkinter as tk
from view.farm_view import FarmView


if __name__ == "__main__":
    root = tk.Tk()
    app = FarmView(root)
    root.mainloop()
import tkinter as tk
from view.main_view import MainView

#@author Christopher Lomas,<CodeBros,@ESPE>

if __name__ == "__main__":
    root = tk.Tk()
    app = MainView(root)
    root.mainloop()
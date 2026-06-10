import tkinter as tk
from view.frm_doctor import FrmDoctor

if __name__ == "__main__":
    root = tk.Tk()
    app = FrmDoctor(root)
    root.eval('tk::PlaceWindow . center')
    root.mainloop()
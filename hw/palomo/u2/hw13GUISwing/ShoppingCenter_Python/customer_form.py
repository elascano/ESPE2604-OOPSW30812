"""
customer_form.py
@author Cristian 
"""
import tkinter as tk
from tkinter import ttk, messagebox
from customer import Customer


class CustomerForm:
    def __init__(self, root):
        self.root = root
        self.root.title("Customer")
        self.root.geometry("400x550")
        self.root.resizable(False, False)
        self.root.configure(bg="#d4d0c8")

        self.customers = []
        self._build_ui()

    def _build_ui(self):
        tk.Label(self.root, text="CUSTOMER", bg="#d4d0c8",
                 font=("Arial", 11)).place(x=160, y=20)

        tk.Label(self.root, text="id", bg="#d4d0c8").place(x=50, y=65)
        self.entry_id = tk.Entry(self.root, width=10,
                                 highlightbackground="blue", highlightthickness=1)
        self.entry_id.place(x=180, y=63)

        tk.Label(self.root, text="Firts Name", bg="#d4d0c8").place(x=50, y=105)
        self.entry_first = tk.Entry(self.root, width=18)
        self.entry_first.place(x=180, y=103)

        tk.Label(self.root, text="Last Name", bg="#d4d0c8").place(x=50, y=145)
        self.entry_last = tk.Entry(self.root, width=18)
        self.entry_last.place(x=180, y=143)

        tk.Label(self.root, text="Gender", bg="#d4d0c8").place(x=50, y=185)
        self.combo_gender = ttk.Combobox(self.root, values=["Male", "Female"], width=10, state="readonly")
        self.combo_gender.set("Male")
        self.combo_gender.place(x=180, y=183)

        tk.Label(self.root, text="Money Spent", bg="#d4d0c8").place(x=50, y=225)
        self.spin_money = tk.Spinbox(self.root, from_=0, to=99999, width=10)
        self.spin_money.place(x=180, y=223)

        tk.Label(self.root, text="Age", bg="#d4d0c8").place(x=50, y=265)
        self.age_var = tk.IntVar()
        self.slider_age = tk.Scale(self.root, from_=0, to=100, orient=tk.HORIZONTAL,
                                   variable=self.age_var, bg="#d4d0c8",
                                   length=180, showvalue=True)
        self.slider_age.place(x=180, y=255)

        tk.Label(self.root, text="Type of customer", bg="#d4d0c8").place(x=50, y=315)
        self.combo_type = ttk.Combobox(self.root,
                                       values=["Frequent", "New", "VIP", "Regular"],
                                       width=12, state="readonly")
        self.combo_type.set("Frequent")
        self.combo_type.place(x=180, y=313)

        tk.Label(self.root, text="Hobbies:", bg="#d4d0c8").place(x=50, y=355)
        hobbies_list = ["Play Music", "Listening to Music", "Play Soccer",
                        "Play an Instrument", "Paint", "Study English"]
        self.listbox_hobbies = tk.Listbox(self.root, selectmode=tk.MULTIPLE,
                                          height=6, width=22)
        for h in hobbies_list:
            self.listbox_hobbies.insert(tk.END, h)
        self.listbox_hobbies.place(x=180, y=353)

        btn_style = {"width": 8, "bg": "#d4d0c8", "relief": "raised"}
        tk.Button(self.root, text="Insert", command=self.insert_customer,
                  **btn_style).place(x=70, y=490)
        tk.Button(self.root, text="Cancel", command=self.cancel,
                  **btn_style).place(x=170, y=490)
        tk.Button(self.root, text="Quit", command=self.root.quit,
                  **btn_style).place(x=270, y=490)

    def insert_customer(self):
        try:
            cid = int(self.entry_id.get())
            first = self.entry_first.get()
            last = self.entry_last.get()
            gender = self.combo_gender.get()
            money = float(self.spin_money.get())
            age = self.age_var.get()
            ctype = self.combo_type.get()
            selected = self.listbox_hobbies.curselection()
            hobbies = [self.listbox_hobbies.get(i) for i in selected]

            if not first or not last:
                messagebox.showwarning("Atención", "Nombre y apellido son obligatorios.")
                return

            c = Customer(cid, first, last, gender, money, age, ctype, hobbies)
            self.customers.append(c)
            messagebox.showinfo("Éxito", f"Cliente insertado:\n{c}")
            self.cancel()

        except ValueError:
            messagebox.showerror("Error", "ID debe ser un número entero válido.")

    def cancel(self):
        self.entry_id.delete(0, tk.END)
        self.entry_first.delete(0, tk.END)
        self.entry_last.delete(0, tk.END)
        self.combo_gender.set("Male")
        self.spin_money.delete(0, tk.END)
        self.spin_money.insert(0, "0")
        self.age_var.set(0)
        self.combo_type.set("Frequent")
        self.listbox_hobbies.selection_clear(0, tk.END)


if __name__ == "__main__":
    root = tk.Tk()
    app = CustomerForm(root)
    root.mainloop()

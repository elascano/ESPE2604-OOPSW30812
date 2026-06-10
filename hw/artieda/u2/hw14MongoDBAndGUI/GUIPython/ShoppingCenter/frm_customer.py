import tkinter as tk
from tkinter import ttk, messagebox
from customer import Customer

class FrmCustomer:
    def __init__(self, root):
        self.root = root
        self.root.title("Shopping Center - Customer Registration")
        self.root.geometry("450x650")

        # Header Panel
        header_frame = tk.Frame(self.root)
        header_frame.pack(pady=20)
        tk.Label(header_frame, text="Customers", font=("Segoe UI", 18, "bold")).pack()

        # Body Panel
        body_frame = tk.Frame(self.root)
        body_frame.pack(padx=20, fill="both", expand=True)

        # Labels and Entries (Matching FrmCustomer.java)
        tk.Label(body_frame, text="Id:").grid(row=0, column=0, sticky="e", pady=5)
        self.txt_id = tk.Entry(body_frame)
        self.txt_id.grid(row=0, column=1, pady=5, padx=10, sticky="w")

        tk.Label(body_frame, text="First Name:").grid(row=1, column=0, sticky="e", pady=5)
        self.txt_first_name = tk.Entry(body_frame)
        self.txt_first_name.grid(row=1, column=1, pady=5, padx=10, sticky="w")

        tk.Label(body_frame, text="Last Name:").grid(row=2, column=0, sticky="e", pady=5)
        self.txt_last_name = tk.Entry(body_frame)
        self.txt_last_name.grid(row=2, column=1, pady=5, padx=10, sticky="w")

        tk.Label(body_frame, text="Gender:").grid(row=3, column=0, sticky="e", pady=5)
        self.cmb_gender = ttk.Combobox(body_frame, values=["Male", "Female", "Other"])
        self.cmb_gender.grid(row=3, column=1, pady=5, padx=10, sticky="w")
        self.cmb_gender.current(0)

        tk.Label(body_frame, text="Money Spent:").grid(row=4, column=0, sticky="e", pady=5)
        self.txt_money_spent = tk.Entry(body_frame)
        self.txt_money_spent.grid(row=4, column=1, pady=5, padx=10, sticky="w")

        tk.Label(body_frame, text="Age:").grid(row=5, column=0, sticky="e", pady=5)
        self.age_val = tk.IntVar(value=50)
        self.sld_age = tk.Scale(body_frame, from_=0, to=100, orient="horizontal", variable=self.age_val, command=self.update_age_label)
        self.sld_age.grid(row=5, column=1, pady=5, padx=10, sticky="w")
        self.lbl_age_val = tk.Label(body_frame, text="50")
        self.lbl_age_val.grid(row=5, column=2, sticky="w")

        tk.Label(body_frame, text="Type of Customer:").grid(row=6, column=0, sticky="e", pady=5)
        self.cmb_type = ttk.Combobox(body_frame, values=["Frequent", "Ocassional", "Friend", "Preferencial"])
        self.cmb_type.grid(row=6, column=1, pady=5, padx=10, sticky="w")
        self.cmb_type.current(0)

        tk.Label(body_frame, text="Hobbies:").grid(row=7, column=0, sticky="ne", pady=5)
        self.lst_hobbies = tk.Listbox(body_frame, selectmode="multiple", height=6)
        hobbies_list = ["Play Music", "Listening to Music", "Play Soccer", "Play an Instrument", "Paint", "Study English"]
        for hobby in hobbies_list:
            self.lst_hobbies.insert(tk.END, hobby)
        self.lst_hobbies.grid(row=7, column=1, pady=5, padx=10, sticky="w")

        # Footer Panel
        footer_frame = tk.Frame(self.root)
        footer_frame.pack(pady=30)

        tk.Button(footer_frame, text="Insert", command=self.btn_insert_clicked).pack(side="left", padx=10)
        tk.Button(footer_frame, text="Cancel", command=self.clear_fields).pack(side="left", padx=10)
        tk.Button(footer_frame, text="Quit", command=self.root.destroy).pack(side="left", padx=10)

    def update_age_label(self, val):
        self.lbl_age_val.config(text=str(val))

    def btn_insert_clicked(self):
        try:
            id_val = self.txt_id.get()
            first_name = self.txt_first_name.get()
            last_name = self.txt_last_name.get()
            gender = self.cmb_gender.get()
            money = float(self.txt_money_spent.get())
            age = self.age_val.get()
            customer_type = self.cmb_type.get()
            
            selected_indices = self.lst_hobbies.curselection()
            hobbies = [self.lst_hobbies.get(i) for i in selected_indices]

            customer = Customer(id_val, first_name, last_name, gender, money, age, customer_type, hobbies)
            messagebox.showinfo("Shopping Center", f"Customer Successfully Registered:\n{customer}")
            self.clear_fields()
        except ValueError:
            messagebox.showerror("Error", "Input Error: Please enter a valid number for Money Spent")

    def clear_fields(self):
        self.txt_id.delete(0, tk.END)
        self.txt_first_name.delete(0, tk.END)
        self.txt_last_name.delete(0, tk.END)
        self.txt_money_spent.delete(0, tk.END)
        self.age_val.set(50)
        self.lbl_age_val.config(text="50")
        self.cmb_gender.current(0)
        self.cmb_type.current(0)
        self.lst_hobbies.selection_clear(0, tk.END)

if __name__ == "__main__":
    root = tk.Tk()
    app = FrmCustomer(root)
    root.mainloop()

import tkinter as tk
from tkinter import ttk, messagebox
from model.customer import Customer

class FrmCustomer(tk.Toplevel): 
    def __init__(self, parent): 
        super().__init__(parent) 
        self.title("Customers")
        self.geometry("500x600")
        
      
        x = int(self.winfo_screenwidth() / 2 - 250)
        y = int(self.winfo_screenheight() / 2 - 300)
        self.geometry(f"+{x}+{y}")
        
        tk.Label(self, text="Customers", font=("Arial", 16)).pack(pady=10)
        
        frame = tk.Frame(self)
        frame.pack(pady=10, padx=20, fill="both", expand=True)
        
        tk.Label(frame, text="id:").grid(row=0, column=0, sticky="w", pady=5)
        vcmd_num = (self.register(self._validate_numeric), '%P')
        self.txt_id = tk.Entry(frame, validate="key", validatecommand=vcmd_num)
        self.txt_id.grid(row=0, column=1, pady=5, sticky="ew")
        
        tk.Label(frame, text="First Name:").grid(row=1, column=0, sticky="w", pady=5)
        vcmd_alpha = (self.register(self._validate_alpha), '%P')
        self.txt_first_name = tk.Entry(frame, validate="key", validatecommand=vcmd_alpha)
        self.txt_first_name.grid(row=1, column=1, pady=5, sticky="ew")
        
        tk.Label(frame, text="Last Name:").grid(row=2, column=0, sticky="w", pady=5)
        self.txt_last_name = tk.Entry(frame, validate="key", validatecommand=vcmd_alpha)
        self.txt_last_name.grid(row=2, column=1, pady=5, sticky="ew")
        
        tk.Label(frame, text="Gender:").grid(row=3, column=0, sticky="w", pady=5)
        self.cmb_gender = ttk.Combobox(frame, values=["Male", "Female", "Other"], state="readonly")
        self.cmb_gender.current(0)
        self.cmb_gender.grid(row=3, column=1, pady=5, sticky="ew")
        
        tk.Label(frame, text="Money Spent:").grid(row=4, column=0, sticky="w", pady=5)
        vcmd_float = (self.register(self._validate_float), '%P')
        self.txt_money_spent = tk.Entry(frame, validate="key", validatecommand=vcmd_float)
        self.txt_money_spent.grid(row=4, column=1, pady=5, sticky="ew")
        
        tk.Label(frame, text="Age:").grid(row=5, column=0, sticky="w", pady=5)
        self.lbl_age_val = tk.Label(frame, text="0")
        self.lbl_age_val.grid(row=5, column=2, padx=5)
        self.sld_age = tk.Scale(frame, from_=0, to=100, orient="horizontal", command=self._on_scale)
        self.sld_age.grid(row=5, column=1, pady=5, sticky="ew")
        
        tk.Label(frame, text="Type of Customer:").grid(row=6, column=0, sticky="w", pady=5)
        self.cmb_type = ttk.Combobox(frame, values=["Frequent", "Casual", "VIP"], state="readonly")
        self.cmb_type.current(0)
        self.cmb_type.grid(row=6, column=1, pady=5, sticky="ew")
        
        tk.Label(frame, text="Hobbies:").grid(row=7, column=0, sticky="w", pady=5)
        self.lst_hobbies = tk.Listbox(frame, selectmode="multiple", height=5)
        hobbies_list = ["Play Music", "Listening to Music", "Play Soccer", "Play an Instrument", "Paint", "Study English"]
        for h in hobbies_list:
            self.lst_hobbies.insert(tk.END, h)
        self.lst_hobbies.grid(row=7, column=1, pady=5, sticky="ew")
        
        frame.grid_columnconfigure(1, weight=1)
        
        btn_frame = tk.Frame(self)
        btn_frame.pack(pady=20)
        
        tk.Button(btn_frame, text="Insert", command=self._on_insert).pack(side="left", padx=5)
        tk.Button(btn_frame, text="Cancel", command=self._on_cancel).pack(side="left", padx=5)
        tk.Button(btn_frame, text="Quit", command=self.quit).pack(side="left", padx=5)

    def _on_scale(self, val):
        self.lbl_age_val.config(text=str(val))

    def _validate_numeric(self, P):
        if P == "" or P.isdigit():
            return True
        return False

    def _validate_alpha(self, P):
        if P == "" or all(c.isalpha() or c.isspace() for c in P):
            return True
        return False

    def _validate_float(self, P):
        if P == "":
            return True
        try:
            float(P)
            return True
        except ValueError:
            return False

    def _on_insert(self):
        if not self.txt_id.get() or not self.txt_first_name.get() or not self.txt_last_name.get() or not self.txt_money_spent.get():
            messagebox.showwarning("Warning", "All fields must be filled")
            return
            
        selected_hobbies = [self.lst_hobbies.get(i) for i in self.lst_hobbies.curselection()]
        
        customer = Customer(
            int(self.txt_id.get()),
            self.txt_first_name.get(),
            self.txt_last_name.get(),
            self.cmb_gender.get(),
            float(self.txt_money_spent.get()),
            int(self.sld_age.get()),
            self.cmb_type.get(),
            selected_hobbies
        )
        print(customer)
        messagebox.showinfo("Success", "Customer data captured successfully")

    def _on_cancel(self):
        self.txt_id.delete(0, tk.END)
        self.txt_first_name.delete(0, tk.END)
        self.txt_last_name.delete(0, tk.END)
        self.cmb_gender.current(0)
        self.txt_money_spent.delete(0, tk.END)
        self.sld_age.set(0)
        self.cmb_type.current(0)
        self.lst_hobbies.selection_clear(0, tk.END)
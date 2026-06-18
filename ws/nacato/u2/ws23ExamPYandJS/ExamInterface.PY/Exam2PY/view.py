import tkinter as tk
from tkinter import messagebox
from tkinter import ttk

class BankView(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("ACME COMPANY: BANK MANAGEMENT (CRUD)")
        self.geometry("550x550")
        self.resizable(False, False)
        
        tk.Label(self, text="BANK MANAGEMENT SYSTEM", font=("Arial", 14, "bold")).pack(pady=10)
        
        form_frame = tk.Frame(self)
        form_frame.pack(pady=10)
        
        tk.Label(form_frame, text="Bank ID:").grid(row=0, column=0, sticky="e", padx=5, pady=5)
        self.ent_id = tk.Entry(form_frame, width=25)
        self.ent_id.grid(row=0, column=1, padx=5, pady=5)
        
        tk.Label(form_frame, text="Bank Name:").grid(row=1, column=0, sticky="e", padx=5, pady=5)
        self.ent_name = tk.Entry(form_frame, width=25)
        self.ent_name.grid(row=1, column=1, padx=5, pady=5)
        
        tk.Label(form_frame, text="Total Deposits:").grid(row=2, column=0, sticky="e", padx=5, pady=5)
        self.ent_deposits = tk.Entry(form_frame, width=25)
        self.ent_deposits.grid(row=2, column=1, padx=5, pady=5)
        
        tk.Label(form_frame, text="Total Loans:").grid(row=3, column=0, sticky="e", padx=5, pady=5)
        self.ent_loans = tk.Entry(form_frame, width=25)
        self.ent_loans.grid(row=3, column=1, padx=5, pady=5)
        
        btn_frame = tk.Frame(self)
        btn_frame.pack(pady=10)
        
        self.btn_create = tk.Button(btn_frame, text="Add / Create", bg="#4CAF50", fg="white", width=12, font=("Arial", 9, "bold"))
        self.btn_create.grid(row=0, column=0, padx=5)
        
        self.btn_update = tk.Button(btn_frame, text="Modify / Update", bg="#2196F3", fg="white", width=12, font=("Arial", 9, "bold"))
        self.btn_update.grid(row=0, column=1, padx=5)
        
        self.btn_delete = tk.Button(btn_frame, text="Delete", bg="#f44336", fg="white", width=12, font=("Arial", 9, "bold"))
        self.btn_delete.grid(row=0, column=2, padx=5)
        
        self.btn_clear = tk.Button(btn_frame, text="Clear Fields", bg="#ff9800", fg="white", width=12, font=("Arial", 9, "bold"))
        self.btn_clear.grid(row=0, column=3, padx=5)
        
        tk.Label(self, text="Registered Banks (Click to select):", font=("Arial", 10, "bold")).pack(anchor="w", padx=25)
        
        self.tree = ttk.Treeview(self, columns=("ID", "Name", "Deposits", "Loans", "Net Worth"), show="headings", height=8)
        self.tree.pack(pady=5, fill="x", padx=25)
        
        self.tree.heading("ID", text="ID")
        self.tree.heading("Name", text="Name")
        self.tree.heading("Deposits", text="Deposits")
        self.tree.heading("Loans", text="Loans")
        self.tree.heading("Net Worth", text="Net Worth")
        
        self.tree.column("ID", width=50, anchor="center")
        self.tree.column("Name", width=120, anchor="w")
        self.tree.column("Deposits", width=90, anchor="e")
        self.tree.column("Loans", width=90, anchor="e")
        self.tree.column("Net Worth", width=100, anchor="e")

    def get_bank_data(self) -> dict:
        try:
            return {
                "id": self.ent_id.get().strip(),
                "name": self.ent_name.get().strip(),
                "total_deposits": float(self.ent_deposits.get()),
                "total_loans": float(self.ent_loans.get())
            }
        except ValueError:
            raise ValueError("Deposits and Loans must be valid numbers.")

    def set_bank_data(self, id_val, name_val, deposits_val, loans_val):
        self.clear_inputs()
        self.ent_id.insert(0, id_val)
        self.ent_name.insert(0, name_val)
        self.ent_deposits.insert(0, deposits_val)
        self.ent_loans.insert(0, loans_val)

    def clear_inputs(self):
        self.ent_id.delete(0, tk.END)
        self.ent_name.delete(0, tk.END)
        self.ent_deposits.delete(0, tk.END)
        self.ent_loans.delete(0, tk.END)

    def update_tree(self, banks_list):
        for item in self.tree.get_children():
            self.tree.delete(item)
        for bank in banks_list:
            self.tree.insert("", tk.END, values=(bank.id, bank.name, f"${bank.total_deposits:.2f}", f"${bank.total_loans:.2f}", f"${bank.compute_net_worth():.2f}"))

    def display_message(self, message: str):
        messagebox.showinfo("INFO", message)

    def display_error(self, message: str):
        messagebox.showerror("ERROR", message)
import sys
import os
import tkinter as tk
from tkinter import messagebox, ttk

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from model.person import Person, Product, Payment
from controller.billing_controller import BillingController

class BillingView:
    def __init__(self):
        self.controller = BillingController()
        self.window = tk.Tk()
        self.window.title("Billing Management System (MVC)")
        self.window.geometry("520x680")
        self.window.resizable(False, False)
        self._create_widgets()

    def _create_widgets(self):
       
        frame_person = tk.LabelFrame(self.window, text=" Person Management ", padx=15, pady=10)
        frame_person.pack(padx=15, pady=10, fill="x")

        tk.Label(frame_person, text="ID:").grid(row=0, column=0, sticky="w", pady=5)
        self.txt_person_id = tk.Entry(frame_person, width=22)
        self.txt_person_id.grid(row=0, column=1, pady=5, padx=5)

        tk.Label(frame_person, text="NAME:").grid(row=1, column=0, sticky="w", pady=5)
        self.txt_person_name = tk.Entry(frame_person, width=22)
        self.txt_person_name.grid(row=1, column=1, pady=5, padx=5)

        tk.Label(frame_person, text="EMAIL:").grid(row=2, column=0, sticky="w", pady=5)
        self.txt_person_email = tk.Entry(frame_person, width=22)
        self.txt_person_email.grid(row=2, column=1, pady=5, padx=5)

        tk.Button(frame_person, text="Save/Update Person", width=18, command=self._save_person).grid(row=0, column=2, padx=10, pady=2)
        tk.Button(frame_person, text="Load Person", width=18, command=self._load_person).grid(row=1, column=2, padx=10, pady=2)

        
        frame_product = tk.LabelFrame(self.window, text=" Product Management ", padx=15, pady=10)
        frame_product.pack(padx=15, pady=10, fill="x")

        tk.Label(frame_product, text="ID:").grid(row=0, column=0, sticky="w", pady=5)
        self.txt_product_id = tk.Entry(frame_product, width=22)
        self.txt_product_id.grid(row=0, column=1, pady=5, padx=5)

        tk.Label(frame_product, text="NAME:").grid(row=1, column=0, sticky="w", pady=5)
        self.txt_product_name = tk.Entry(frame_product, width=22)
        self.txt_product_name.grid(row=1, column=1, pady=5, padx=5)

        tk.Label(frame_product, text="PRICE:").grid(row=2, column=0, sticky="w", pady=5)
        self.spn_product_price = tk.Spinbox(frame_product, from_=0.0, to=10000.0, increment=0.5, width=20)
        self.spn_product_price.grid(row=2, column=1, pady=5, padx=5)

        tk.Button(frame_product, text="Save/Update Product", width=18, command=self._save_product).grid(row=0, column=2, padx=10, pady=2)
        tk.Button(frame_product, text="Load Product", width=18, command=self._load_product).grid(row=1, column=2, padx=10, pady=2)

        
        frame_payment = tk.LabelFrame(self.window, text=" Payment Management ", padx=15, pady=10)
        frame_payment.pack(padx=15, pady=10, fill="x")

        tk.Label(frame_payment, text="ID:").grid(row=0, column=0, sticky="w", pady=5)
        self.txt_payment_id = tk.Entry(frame_payment, width=22)
        self.txt_payment_id.grid(row=0, column=1, pady=5, padx=5)

        tk.Label(frame_payment, text="METHOD:").grid(row=1, column=0, sticky="w", pady=5)
        self.cmb_method = ttk.Combobox(frame_payment, values=["Cash", "Credit Card", "PayPal", "Transfer"], width=19, state="readonly")
        self.cmb_method.current(0)
        self.cmb_method.grid(row=1, column=1, pady=5, padx=5)

        tk.Label(frame_payment, text="AMOUNT:").grid(row=2, column=0, sticky="w", pady=5)
        self.spn_payment_amount = tk.Spinbox(frame_payment, from_=0.0, to=10000.0, increment=0.5, width=20)
        self.spn_payment_amount.grid(row=2, column=1, pady=5, padx=5)

        tk.Button(frame_payment, text="Save/Update Payment", width=18, command=self._save_payment).grid(row=0, column=2, padx=10, pady=2)
        tk.Button(frame_payment, text="Load Payment", width=18, command=self._load_payment).grid(row=1, column=2, padx=10, pady=2)

    
    def _save_person(self):
        p_id, name, email = self.txt_person_id.get().strip(), self.txt_person_name.get().strip(), self.txt_person_email.get().strip()
        if not p_id or not name or not email: return messagebox.showwarning("Warning", "Fill all fields!")
        try:
            self.controller.save_or_update_person(Person(p_id, name, email))
            messagebox.showinfo("Message", "Person saved successfully!")
        except Exception as e: messagebox.showerror("Error", str(e))

    def _load_person(self):
        p_id = self.txt_person_id.get().strip()
        if not p_id: return messagebox.showwarning("Warning", "Enter ID!")
        res = self.controller.find_person(p_id)
        if res:
            self.txt_person_name.delete(0, tk.END); self.txt_person_name.insert(0, res.get('name', ''))
            self.txt_person_email.delete(0, tk.END); self.txt_person_email.insert(0, res.get('email', ''))
            messagebox.showinfo("Message", "Person loaded successfully!")
        else: messagebox.showinfo("Message", "Person not found!")

    def _save_product(self):
        p_id, name, price = self.txt_product_id.get().strip(), self.txt_product_name.get().strip(), float(self.spn_product_price.get())
        if not p_id or not name: return messagebox.showwarning("Warning", "Fill fields!")
        try:
            self.controller.save_or_update_product(Product(p_id, name, price))
            messagebox.showinfo("Message", "Product saved successfully!")
        except Exception as e: messagebox.showerror("Error", str(e))

    def _load_product(self):
        p_id = self.txt_product_id.get().strip()
        if not p_id: return messagebox.showwarning("Warning", "Enter ID!")
        res = self.controller.find_product(p_id)
        if res:
            self.txt_product_name.delete(0, tk.END); self.txt_product_name.insert(0, res.get('name', ''))
            self.spn_product_price.delete(0, tk.END); self.spn_product_price.insert(0, res.get('price', 0.0))
            messagebox.showinfo("Message", "Product loaded successfully!")
        else: messagebox.showinfo("Message", "Product not found!")

    def _save_payment(self):
        pay_id, method, amount = self.txt_payment_id.get().strip(), self.cmb_method.get(), float(self.spn_payment_amount.get())
        if not pay_id: return messagebox.showwarning("Warning", "Enter ID!")
        try:
            self.controller.save_or_update_payment(Payment(pay_id, method, amount))
            messagebox.showinfo("Message", "Payment saved successfully!")
        except Exception as e: messagebox.showerror("Error", str(e))

    def _load_payment(self):
        pay_id = self.txt_payment_id.get().strip()
        if not pay_id: return messagebox.showwarning("Warning", "Enter ID!")
        res = self.controller.find_payment(pay_id)
        if res:
            self.cmb_method.set(res.get('paymentMethod', 'Cash'))
            self.spn_payment_amount.delete(0, tk.END); self.spn_payment_amount.insert(0, res.get('amount', 0.0))
            messagebox.showinfo("Message", "Payment loaded successfully!")
        else: messagebox.showinfo("Message", "Payment not found!")

    def run(self):
        self.window.mainloop()

if __name__ == "__main__":
    app = BillingView()
    app.run()
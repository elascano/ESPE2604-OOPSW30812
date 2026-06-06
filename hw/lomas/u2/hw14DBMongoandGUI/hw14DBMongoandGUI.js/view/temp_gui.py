
import tkinter as tk
from tkinter import messagebox, ttk
import json
import sys

window = tk.Tk()
window.title("Billing Management System (Node.js MVC Bridge)")
window.geometry("520x680")
window.resizable(False, False)


frame_person = tk.LabelFrame(window, text=" Person Management ", padx=15, pady=10)
frame_person.pack(padx=15, pady=10, fill="x")

tk.Label(frame_person, text="ID:").grid(row=0, column=0, sticky="w", pady=5)
txt_person_id = tk.Entry(frame_person, width=22)
txt_person_id.grid(row=0, column=1, pady=5, padx=5)

tk.Label(frame_person, text="NAME:").grid(row=1, column=0, sticky="w", pady=5)
txt_person_name = tk.Entry(frame_person, width=22)
txt_person_name.grid(row=1, column=1, pady=5, padx=5)

tk.Label(frame_person, text="EMAIL:").grid(row=2, column=0, sticky="w", pady=5)
txt_person_email = tk.Entry(frame_person, width=22)
txt_person_email.grid(row=2, column=1, pady=5, padx=5)


frame_product = tk.LabelFrame(window, text=" Product Management ", padx=15, pady=10)
frame_product.pack(padx=15, pady=10, fill="x")

tk.Label(frame_product, text="ID:").grid(row=0, column=0, sticky="w", pady=5)
txt_product_id = tk.Entry(frame_product, width=22)
txt_product_id.grid(row=0, column=1, pady=5, padx=5)

tk.Label(frame_product, text="NAME:").grid(row=1, column=0, sticky="w", pady=5)
txt_product_name = tk.Entry(frame_product, width=22)
txt_product_name.grid(row=1, column=1, pady=5, padx=5)

tk.Label(frame_product, text="PRICE:").grid(row=2, column=0, sticky="w", pady=5)
spn_product_price = tk.Spinbox(frame_product, from_=0.0, to=10000.0, increment=0.5, width=20)
spn_product_price.grid(row=2, column=1, pady=5, padx=5)


frame_payment = tk.LabelFrame(window, text=" Payment Management ", padx=15, pady=10)
frame_payment.pack(padx=15, pady=10, fill="x")

tk.Label(frame_payment, text="ID:").grid(row=0, column=0, sticky="w", pady=5)
txt_payment_id = tk.Entry(frame_payment, width=22)
txt_payment_id.grid(row=0, column=1, pady=5, padx=5)

tk.Label(frame_payment, text="METHOD:").grid(row=1, column=0, sticky="w", pady=5)
cmb_method = ttk.Combobox(frame_payment, values=["Cash", "Credit Card", "PayPal", "Transfer"], width=19, state="readonly")
cmb_method.current(0)
cmb_method.grid(row=1, column=1, pady=5, padx=5)

tk.Label(frame_payment, text="AMOUNT:").grid(row=2, column=0, sticky="w", pady=5)
spn_payment_amount = tk.Spinbox(frame_payment, from_=0.0, to=10000.0, increment=0.5, width=20)
spn_payment_amount.grid(row=2, column=1, pady=5, padx=5)

def send_to_node(action_type, payload):
    print(json.dumps({"action": action_type, "data": payload}))
    sys.stdout.flush()

def save_person():
    send_to_node("SAVE_PERSON", {"id": txt_person_id.get(), "name": txt_person_name.get(), "email": txt_person_email.get()})
    messagebox.showinfo("Message", "Person processing request sent to Node.js!")

def load_person():
    send_to_node("LOAD_PERSON", {"id": txt_person_id.get()})

def save_product():
    send_to_node("SAVE_PRODUCT", {"id": txt_product_id.get(), "name": txt_product_name.get(), "price": spn_product_price.get()})
    messagebox.showinfo("Message", "Product processing request sent to Node.js!")

def load_product():
    send_to_node("LOAD_PRODUCT", {"id": txt_product_id.get()})

def save_payment():
    send_to_node("SAVE_PAYMENT", {"id": txt_payment_id.get(), "method": cmb_method.get(), "amount": spn_payment_amount.get()})
    messagebox.showinfo("Message", "Payment processing request sent to Node.js!")

def load_payment():
    send_to_node("LOAD_PAYMENT", {"id": txt_payment_id.get()})

tk.Button(frame_person, text="Save/Update Person", width=18, command=save_person).grid(row=0, column=2, padx=10, pady=2)
tk.Button(frame_person, text="Load Person", width=18, command=load_person).grid(row=1, column=2, padx=10, pady=2)
tk.Button(frame_product, text="Save/Update Product", width=18, command=save_product).grid(row=0, column=2, padx=10, pady=2)
tk.Button(frame_product, text="Load Product", width=18, command=load_product).grid(row=1, column=2, padx=10, pady=2)
tk.Button(frame_payment, text="Save/Update Payment", width=18, command=save_payment).grid(row=0, column=2, padx=10, pady=2)
tk.Button(frame_payment, text="Load Payment", width=18, command=load_payment).grid(row=1, column=2, padx=10, pady=2)

window.mainloop()

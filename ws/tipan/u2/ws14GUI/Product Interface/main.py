import tkinter as tk
from tkinter import messagebox
from tkinter import ttk
import json
import os

filename = "products.json"


# ---------------------------
# LOAD PRODUCTS
# ---------------------------
def load_products():
    if os.path.exists(filename):
        with open(filename, "r") as file:
            return json.load(file)
    return []


# ---------------------------
# SAVE PRODUCTS
# ---------------------------
def save_products():
    with open(filename, "w") as file:
        json.dump(products, file, indent=4)


# ---------------------------
# ADD PRODUCT
# ---------------------------
def add_product():

    name = entry_name.get().strip()

    # Validate empty name
    if name == "":
        messagebox.showerror("Error", "Product name cannot be empty.")
        return

    # Validate price
    try:
        price = float(entry_price.get())
    except ValueError:
        messagebox.showerror("Error", "Price must be a number.")
        return

    # Validate quantity
    try:
        quantity = int(entry_quantity.get())
    except ValueError:
        messagebox.showerror("Error", "Quantity must be an integer.")
        return

    # Validate negative numbers
    if price < 0 or quantity < 0:
        messagebox.showerror(
            "Error",
            "Price and quantity must be positive."
        )
        return

    total = price * quantity

    product = {
        "name": name,
        "price": price,
        "quantity": quantity,
        "total": total
    }

    products.append(product)

    save_products()

    update_table()

    clear_inputs()

    messagebox.showinfo(
        "Success",
        "Product added successfully."
    )


# ---------------------------
# UPDATE TABLE
# ---------------------------
def update_table():

    # Clear table
    for row in table.get_children():
        table.delete(row)

    # Insert products
    for p in products:
        table.insert(
            "",
            tk.END,
            values=(
                p["name"],
                f"${p['price']:.2f}",
                p["quantity"],
                f"${p['total']:.2f}"
            )
        )


# ---------------------------
# CALCULATE GRAND TOTAL
# ---------------------------
def calculate_total():

    grand_total = sum(p["total"] for p in products)

    label_total.config(
        text=f"GRAND TOTAL: ${grand_total:.2f}"
    )


# ---------------------------
# CLEAR INPUTS
# ---------------------------
def clear_inputs():
    entry_name.delete(0, tk.END)
    entry_price.delete(0, tk.END)
    entry_quantity.delete(0, tk.END)


# ---------------------------
# MAIN WINDOW
# ---------------------------
root = tk.Tk()
root.title("Product Management System")
root.geometry("700x500")
root.config(bg="#f0f0f0")

products = load_products()


# ---------------------------
# TITLE
# ---------------------------
title = tk.Label(
    root,
    text="PRODUCT MANAGEMENT",
    font=("Arial", 18, "bold"),
    bg="#f0f0f0"
)
title.pack(pady=10)


# ---------------------------
# INPUT FRAME
# ---------------------------
frame_inputs = tk.Frame(root, bg="#f0f0f0")
frame_inputs.pack(pady=10)

# Product Name
tk.Label(
    frame_inputs,
    text="Product Name:",
    bg="#f0f0f0"
).grid(row=0, column=0, padx=5, pady=5)

entry_name = tk.Entry(frame_inputs)
entry_name.grid(row=0, column=1, padx=5)

# Price
tk.Label(
    frame_inputs,
    text="Price:",
    bg="#f0f0f0"
).grid(row=1, column=0, padx=5, pady=5)

entry_price = tk.Entry(frame_inputs)
entry_price.grid(row=1, column=1, padx=5)

# Quantity
tk.Label(
    frame_inputs,
    text="Quantity:",
    bg="#f0f0f0"
).grid(row=2, column=0, padx=5, pady=5)

entry_quantity = tk.Entry(frame_inputs)
entry_quantity.grid(row=2, column=1, padx=5)


# ---------------------------
# BUTTONS
# ---------------------------
frame_buttons = tk.Frame(root, bg="#f0f0f0")
frame_buttons.pack(pady=10)

# Add Product Button
btn_add = tk.Button(
    frame_buttons,
    text="Add Product",
    command=add_product,
    bg="#4CAF50",
    fg="white",
    width=18
)
btn_add.grid(row=0, column=0, padx=10)

# Calculate Total Button
btn_total = tk.Button(
    frame_buttons,
    text="Calculate Total",
    command=calculate_total,
    bg="#2196F3",
    fg="white",
    width=18
)
btn_total.grid(row=0, column=1, padx=10)

# Clear Button
btn_clear = tk.Button(
    frame_buttons,
    text="Clear",
    command=clear_inputs,
    bg="gray",
    fg="white",
    width=18
)
btn_clear.grid(row=0, column=2, padx=10)


# ---------------------------
# TABLE
# ---------------------------
columns = ("Name", "Price", "Quantity", "Total")

table = ttk.Treeview(
    root,
    columns=columns,
    show="headings",
    height=10
)

for col in columns:
    table.heading(col, text=col)
    table.column(col, width=150)

table.pack(pady=20)


# ---------------------------
# TOTAL LABEL
# ---------------------------
label_total = tk.Label(
    root,
    text="GRAND TOTAL: $0.00",
    font=("Arial", 14, "bold"),
    bg="#f0f0f0"
)
label_total.pack(pady=10)


# Load existing products
update_table()

# Run application
root.mainloop()
import tkinter as tk
from tkinter import ttk
from tkinter import messagebox

products = []

# ---------------- ADD PRODUCT ----------------

def add_product():

    product_id = txt_id.get()
    name = txt_name.get()
    price = txt_price.get()

    if product_id == "" or name == "" or price == "":
        messagebox.showerror(
            "Error",
            "Complete all fields"
        )
        return

    products.append({
        "id": product_id,
        "name": name,
        "price": price
    })

    update_table()

    clear_fields()

    messagebox.showinfo(
        "Saved",
        "Product Saved"
    )

# ---------------- UPDATE TABLE ----------------

def update_table():

    for row in table.get_children():
        table.delete(row)

    for product in products:

        table.insert(
            "",
            tk.END,
            values=(
                product["id"],
                product["name"],
                product["price"]
            )
        )

# ---------------- DELETE PRODUCT ----------------

def delete_product():

    selected = table.selection()

    if not selected:
        return

    values = table.item(selected)["values"]

    product_id = values[0]

    for product in products:

        if product["id"] == product_id:
            products.remove(product)
            break

    update_table()

    messagebox.showinfo(
        "Deleted",
        "Product Deleted"
    )

# ---------------- CLEAR ----------------

def clear_fields():

    txt_id.delete(0, tk.END)
    txt_name.delete(0, tk.END)
    txt_price.delete(0, tk.END)

# ---------------- WINDOW ----------------

window = tk.Tk()

window.title("Product System")
window.geometry("700x500")

# ---------------- FORM ----------------

frame = tk.Frame(window)
frame.pack(pady=20)

tk.Label(frame, text="ID").grid(row=0, column=0)
txt_id = tk.Entry(frame)
txt_id.grid(row=0, column=1)

tk.Label(frame, text="Name").grid(row=1, column=0)
txt_name = tk.Entry(frame)
txt_name.grid(row=1, column=1)

tk.Label(frame, text="Price").grid(row=2, column=0)
txt_price = tk.Entry(frame)
txt_price.grid(row=2, column=1)

btn_add = tk.Button(
    frame,
    text="Add Product",
    command=add_product
)

btn_add.grid(row=3, columnspan=2, pady=10)

# ---------------- TABLE ----------------

columns = ("ID", "NAME", "PRICE")

table = ttk.Treeview(
    window,
    columns=columns,
    show="headings"
)

for column in columns:
    table.heading(column, text=column)

table.pack(fill=tk.BOTH, expand=True, padx=20)

# ---------------- DELETE BUTTON ----------------

btn_delete = tk.Button(
    window,
    text="Delete Selected Product",
    command=delete_product
)

btn_delete.pack(pady=10)

window.mainloop()
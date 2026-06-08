import json
import os
import tkinter as tk
from tkinter import messagebox
from model.product_tax import ProductTax

class Product_Tax:
    def __init__(self, window):
        self.controller = ProductTax()

        self.window = window
        self.window.title("Shopping List (15% VAT)")
        self.window.geometry("420x560")

        # Product
        tk.Label(window, text="Product Name").pack()

        self.entry_name = tk.Entry(window)
        self.entry_name.pack()

        # Price
        tk.Label(window, text="Price").pack()

        self.entry_price = tk.Entry(window)
        self.entry_price.pack()

        # Buttons
        button_frame = tk.Frame(window)
        button_frame.pack(pady=10)

        tk.Button(
            button_frame,
            text="Add Product",
            command=self.add_product,
            bg="green",
            fg="white",
            width=15
        ).grid(row=0, column=0, padx=5)

        tk.Button(
            button_frame,
            text="Delete Product",
            command=self.delete_product,
            bg="red",
            fg="white",
            width=15
        ).grid(row=0, column=1, padx=5)

        # Listbox
        self.product_list = tk.Listbox(window, width=55, height=12)
        self.product_list.pack(pady=10)

        # Total
        self.label_total = tk.Label(
            window,
            text="Total IVA: $0.00",
            font=("Arial", 12, "bold")
        )
        self.label_total.pack()

        self.result = tk.Label(window, text="", justify="left")
        self.result.pack(pady=10)

        os.makedirs("data", exist_ok=True)

    def add_product(self):
        name = self.entry_name.get().strip()
        price_text = self.entry_price.get().strip()

        if not name or not price_text:
            messagebox.showwarning("Required Data", "Please enter product name and price.")
            return

        try:
            price = float(price_text)
        except ValueError:
            messagebox.showerror("Invalid Price", "Please enter a valid numeric price.")
            return

        tax = self.controller.add_product(name, price)

        self.product_list.insert(
            tk.END,
            f"{name} - Price: ${price:.2f} - VAT: ${tax:.2f}"
        )

        self.update_total()
        self.entry_name.delete(0, tk.END)
        self.entry_price.delete(0, tk.END)

        self.save_products()

        self.result.config(
            text=(
                f"Last product:\n"
                f"Name: {name}\n"
                f"Price: ${price:.2f}\n"
                f"VAT: ${tax:.2f}\n"
                f"Total VAT: ${self.controller.get_total_tax():.2f}"
            )
        )

    def delete_product(self):
        selection = self.product_list.curselection()
        if not selection:
            messagebox.showwarning("Select Product", "Please select a product from the list to delete.")
            return

        index = selection[0]
        item = self.controller.remove_product(index)
        if item is None:
            messagebox.showerror("Delete Error", "No product was found at the selected position.")
            return

        self.product_list.delete(index)
        self.update_total()
        self.save_products()

        self.result.config(
            text=(
                f"Product deleted:\n"
                f"Name: {item['product']}\n"
                f"Price: ${item['price']:.2f}\n"
                f"VAT: ${item['iva']:.2f}\n"
                f"Total VAT: ${self.controller.get_total_tax():.2f}"
            )
        )

    def update_total(self):
        self.label_total.config(
            text=f"Total IVA: ${self.controller.get_total_tax():.2f}"
        )

    def save_products(self):
        try:
            with open("data/products.json", "w", encoding="utf-8") as file:
                json.dump(self.controller.get_products(), file, indent=4)
        except OSError:
            messagebox.showerror("File Error", "Unable to save the product list.")

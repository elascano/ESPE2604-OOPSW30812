import tkinter as tk
from tkinter import ttk, messagebox
from model.product_model import ProductModel

class ProductView:
    def __init__(self):
        self.model = ProductModel()
        self.shopping_cart = []
        
        self.root = tk.Tk()
        self.root.title("PC Components Hardware Shop")
        self.root.geometry("750x550")
        self.root.resizable(False, False)
        
        self.style = ttk.Style()
        self.style.theme_use("clam")
        
        self.create_widgets()

    def create_widgets(self):
        title_label = ttk.Label(self.root, text="HARDWARE SHOPPING SYSTEM", font=("Arial", 16, "bold"))
        title_label.pack(pady=15)

        catalog_frame = ttk.LabelFrame(self.root, text=" Available Products (From JSON) ", padding=10)
        catalog_frame.pack(fill="x", padx=20, pady=5)

        ttk.Label(catalog_frame, text="Select Product:", font=("Arial", 10)).grid(row=0, column=0, padx=5, sticky="w")
        
        self.catalog = self.model.read_catalog()
        self.catalog_options = [f"{item['product']} (${item['price']:.2f})" for item in self.catalog]
        
        self.combo_products = ttk.Combobox(catalog_frame, values=self.catalog_options, state="readonly", width=40)
        self.combo_products.grid(row=0, column=1, padx=5)
        if self.catalog_options:
            self.combo_products.current(0)

        btn_add = ttk.Button(catalog_frame, text="Add to Cart", command=self.add_to_cart)
        btn_add.grid(row=0, column=2, padx=10)

        cart_frame = ttk.LabelFrame(self.root, text=" Shopping Cart Summary ", padding=10)
        cart_frame.pack(fill="both", expand=True, padx=20, pady=10)

        columns = ("product", "price", "vat", "total")
        self.tree = ttk.Treeview(cart_frame, columns=columns, show="headings", height=8)
        
        self.tree.heading("product", text="Product Name")
        self.tree.heading("price", text="Base Price")
        self.tree.heading("vat", text="VAT (15%)")
        self.tree.heading("total", text="Total Price")

        self.tree.column("product", width=250, anchor="w")
        self.tree.column("price", width=120, anchor="center")
        self.tree.column("vat", width=120, anchor="center")
        self.tree.column("total", width=120, anchor="center")
        
        self.tree.pack(fill="both", expand=True)

        totals_frame = tk.Frame(self.root)
        totals_frame.pack(fill="x", padx=25, pady=5)

        self.lbl_subtotal = ttk.Label(totals_frame, text="Subtotal: $0.00", font=("Arial", 11))
        self.lbl_subtotal.pack(anchor="e")

        self.lbl_vat = ttk.Label(totals_frame, text="Total VAT (15%): $0.00", font=("Arial", 11))
        self.lbl_vat.pack(anchor="e")

        self.lbl_total = ttk.Label(totals_frame, text="Net Total to Pay: $0.00", font=("Arial", 12, "bold"), foreground="green")
        self.lbl_total.pack(anchor="e", pady=2)

        footer_frame = tk.Frame(self.root)
        footer_frame.pack(fill="x", padx=20, pady=15)

        btn_clear = ttk.Button(footer_frame, text="Clear Cart", command=self.clear_cart)
        btn_clear.pack(side="left", padx=5)

        btn_exit = ttk.Button(footer_frame, text="Exit Application", command=self.root.quit)
        btn_exit.pack(side="right", padx=5)

    def add_to_cart(self):
        selected_index = self.combo_products.current()
        if selected_index == -1:
            messagebox.showwarning("Warning", "Please select a valid product from the catalog.")
            return
        
        matched_item = self.catalog[selected_index]
        
        vat, total = self.model.calculate_item_values(matched_item['price'])
        
        cart_item = {
            "product": matched_item['product'],
            "price": matched_item['price'],
            "vat": vat,
            "total": total
        }
        
        self.shopping_cart.append(cart_item)
        self.tree.insert("", "end", values=(cart_item['product'], f"${cart_item['price']:.2f}", f"${cart_item['vat']:.2f}", f"${cart_item['total']:.2f}"))
        
        self.update_totals_display()

    def update_totals_display(self):
        subtotal, vat, total = self.model.calculate_list_totals(self.shopping_cart)
        
        self.lbl_subtotal.config(text=f"Subtotal: ${subtotal:.2f}")
        self.lbl_vat.config(text=f"Total VAT (15%): ${vat:.2f}")
        self.lbl_total.config(text=f"Net Total to Pay: ${total:.2f}")

    def clear_cart(self):
        self.shopping_cart.clear()
        # Clear UI table rows
        for item in self.tree.get_children():
            self.tree.delete(item)
        self.update_totals_display()
        messagebox.showinfo("Info", "Shopping cart has been successfully cleared.")

    def run(self):
        self.root.mainloop()
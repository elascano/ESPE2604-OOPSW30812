"""
Main GUI Application - SafeStore
@author Alexander Tipantiza, The Softwarriors, @ESPE
"""

import tkinter as tk
from tkinter import ttk, messagebox
from datetime import datetime
from typing import List, Dict, Any

from model.mongodb_connection import MongoDBConnection
from model.product_management import ProductManagement


class MainApp:
    """Main application window"""
    
    def __init__(self):
        self.root = tk.Tk()
        self.root.title("SafeStore - Sales System")
        self.root.geometry("1300x800")
        self.root.configure(bg='#f0f0f0')
        
        # Variables
        self.sale_counter = 1
        self.cart_items = []
        
        # Create notebook (tabs)
        self.notebook = ttk.Notebook(self.root)
        self.notebook.pack(fill=tk.BOTH, expand=True, padx=5, pady=5)
        
        # Create tabs
        self.create_sales_tab()
        self.create_products_tab()
        self.create_suppliers_tab()
        self.create_history_tab()
        
        # Connect to database
        self.connect_database()
        
        # Load initial data
        self.load_products()
        self.load_suppliers()
        self.load_history()
        self.load_product_combo()
    
    def run(self):
        """Run the application"""
        self.root.mainloop()
    
    # ==================== DATABASE ====================
    
    def connect_database(self):
        """Connect to MongoDB"""
        if MongoDBConnection.is_connected():
            print("Database connected")
            self.status_label.config(text="Status: Connected to MongoDB", foreground="green")
        else:
            self.status_label.config(text="Status: Offline mode (JSON only)", foreground="orange")
    
    # ==================== SALES TAB ====================
    
    def create_sales_tab(self):
        """Create sales tab"""
        tab = ttk.Frame(self.notebook)
        self.notebook.add(tab, text="SALES")
        
        # Main container
        main_frame = ttk.Frame(tab)
        main_frame.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        # Customer Information Frame
        info_frame = ttk.LabelFrame(main_frame, text="Customer Information", padding=10)
        info_frame.pack(fill=tk.X, pady=(0, 10))
        
        # Customer name
        ttk.Label(info_frame, text="Customer Name:").grid(row=0, column=0, sticky=tk.W, padx=5, pady=5)
        self.customer_entry = ttk.Entry(info_frame, width=30)
        self.customer_entry.grid(row=0, column=1, padx=5, pady=5)
        
        # Sale type
        ttk.Label(info_frame, text="Sale Type:").grid(row=0, column=2, sticky=tk.W, padx=5, pady=5)
        self.sale_type_combo = ttk.Combobox(info_frame, values=["Retail", "Wholesale"], width=15, state="readonly")
        self.sale_type_combo.set("Retail")
        self.sale_type_combo.grid(row=0, column=3, padx=5, pady=5)
        
        # Payment method
        ttk.Label(info_frame, text="Payment Method:").grid(row=1, column=0, sticky=tk.W, padx=5, pady=5)
        self.payment_combo = ttk.Combobox(info_frame, values=["Cash", "Credit", "Transfer"], width=15, state="readonly")
        self.payment_combo.set("Cash")
        self.payment_combo.grid(row=1, column=1, padx=5, pady=5)
        
        # Start button
        self.start_btn = ttk.Button(info_frame, text="Start New Sale", command=self.start_new_sale)
        self.start_btn.grid(row=1, column=2, columnspan=2, padx=5, pady=5)
        
        # Add Product Frame
        add_frame = ttk.LabelFrame(main_frame, text="Add Product", padding=10)
        add_frame.pack(fill=tk.X, pady=(0, 10))
        
        ttk.Label(add_frame, text="Product:").pack(side=tk.LEFT, padx=5)
        self.product_combo = ttk.Combobox(add_frame, width=30, state="readonly")
        self.product_combo.pack(side=tk.LEFT, padx=5)
        
        ttk.Label(add_frame, text="Quantity:").pack(side=tk.LEFT, padx=5)
        self.quantity_spin = ttk.Spinbox(add_frame, from_=1, to=999, width=10)
        self.quantity_spin.set(1)
        self.quantity_spin.pack(side=tk.LEFT, padx=5)
        
        self.add_btn = ttk.Button(add_frame, text="Add to Cart", command=self.add_to_cart)
        self.add_btn.pack(side=tk.LEFT, padx=10)
        
        # Cart Frame
        cart_frame = ttk.LabelFrame(main_frame, text="Shopping Cart", padding=10)
        cart_frame.pack(fill=tk.BOTH, expand=True, pady=(0, 10))
        
        # Cart Treeview
        columns = ("ID", "Product", "Quantity", "Price", "Total")
        self.cart_tree = ttk.Treeview(cart_frame, columns=columns, show="headings", height=8)
        
        for col in columns:
            self.cart_tree.heading(col, text=col)
            self.cart_tree.column(col, width=120)
        
        scrollbar = ttk.Scrollbar(cart_frame, orient=tk.VERTICAL, command=self.cart_tree.yview)
        self.cart_tree.configure(yscrollcommand=scrollbar.set)
        
        self.cart_tree.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
        
        # Totals Frame
        totals_frame = ttk.Frame(main_frame)
        totals_frame.pack(fill=tk.X, pady=(0, 10))
        
        self.subtotal_label = ttk.Label(totals_frame, text="Subtotal: $0.00", font=('Arial', 12))
        self.subtotal_label.pack(side=tk.LEFT, padx=20)
        
        self.tax_label = ttk.Label(totals_frame, text="IVA (15%): $0.00", font=('Arial', 12))
        self.tax_label.pack(side=tk.LEFT, padx=20)
        
        self.total_label = ttk.Label(totals_frame, text="TOTAL: $0.00", font=('Arial', 14, 'bold'))
        self.total_label.pack(side=tk.LEFT, padx=20)
        
        # Action Buttons
        action_frame = ttk.Frame(main_frame)
        action_frame.pack(fill=tk.X)
        
        self.finalize_btn = ttk.Button(action_frame, text="Finalize Sale", command=self.finalize_sale)
        self.finalize_btn.pack(side=tk.LEFT, padx=5)
        
        self.clear_btn = ttk.Button(action_frame, text="Clear Cart", command=self.clear_cart)
        self.clear_btn.pack(side=tk.LEFT, padx=5)
        
        # Status label
        self.status_label = ttk.Label(main_frame, text="Status: Ready", font=('Arial', 10))
        self.status_label.pack(fill=tk.X, pady=(10, 0))
    
    def start_new_sale(self):
        """Start a new sale"""
        customer = self.customer_entry.get().strip()
        if not customer:
            messagebox.showwarning("Warning", "Please enter customer name")
            return
        
        self.status_label.config(text=f"Status: Sale active - {customer}")
        self.sale_counter = len(self.cart_tree.get_children()) + 1
        messagebox.showinfo("Sale Started", f"New sale started for {customer}")
    
    def load_product_combo(self):
        """Load products into combo box"""
        products = MongoDBConnection.get_all_products()
        if products:
            items = [f"{p.get('name')} - ${p.get('retail_price', 0):.2f}" for p in products if p.get('name')]
            self.product_combo['values'] = items
            if items:
                self.product_combo.set(items[0])
    
    def add_to_cart(self):
        """Add product to cart"""
        if not self.product_combo.get():
            messagebox.showwarning("Warning", "Select a product")
            return
        
        selection = self.product_combo.get()
        product_name = selection.split(" - $")[0]
        quantity = int(self.quantity_spin.get())
        
        # Find product in database
        products = MongoDBConnection.get_all_products()
        selected = None
        for p in products:
            if p.get('name') == product_name:
                selected = p
                break
        
        if not selected:
            messagebox.showerror("Error", "Product not found")
            return
        
        product_id = selected.get('productId')
        stock = selected.get('stock', 0)
        price = selected.get('retailPrice', 0)
        
        if quantity > stock:
            messagebox.showerror("Error", f"Insufficient stock. Available: {stock}")
            return
        
        total = quantity * price
        self.cart_tree.insert("", tk.END, values=(product_id, product_name, quantity, f"${price:.2f}", f"${total:.2f}"))
        self.update_totals()
    
    def update_totals(self):
        """Update totals display"""
        subtotal = 0
        for item in self.cart_tree.get_children():
            values = self.cart_tree.item(item)['values']
            total_str = values[4].replace("$", "")
            subtotal += float(total_str)
        
        tax = subtotal * 0.15
        total = subtotal + tax
        
        self.subtotal_label.config(text=f"Subtotal: ${subtotal:.2f}")
        self.tax_label.config(text=f"IVA (15%): ${tax:.2f}")
        self.total_label.config(text=f"TOTAL: ${total:.2f}")
    
    def finalize_sale(self):
        """Finalize current sale"""
        if not self.cart_tree.get_children():
            messagebox.showwarning("Warning", "Cart is empty. Add products first.")
            return
        
        customer = self.customer_entry.get().strip()
        if not customer:
            messagebox.showwarning("Warning", "Please enter customer name")
            return
        
        total_text = self.total_label.cget("text").replace("TOTAL: $", "")
        total = float(total_text)
        
        confirm = messagebox.askyesno("Confirm Sale", f"Complete sale for {customer}?\nTotal: ${total:.2f}")
        
        if confirm:
            try:
                # Create sale document
                sale = {
                    "saleId": self.sale_counter,
                    "customerName": customer,
                    "date": datetime.now().strftime("%Y-%m-%d %H:%M:%S"),
                    "saleType": self.sale_type_combo.get(),
                    "paymentMethod": self.payment_combo.get(),
                    "subtotal": float(self.subtotal_label.cget("text").replace("Subtotal: $", "")),
                    "tax": float(self.tax_label.cget("text").replace("IVA (15%): $", "")),
                    "total": total,
                    "items": []
                }
                
                # Add items and update stock
                for item in self.cart_tree.get_children():
                    values = self.cart_tree.item(item)['values']
                    product_id = values[0]
                    sold = int(values[2])
                    price = float(values[3].replace("$", ""))
                    total_price = float(values[4].replace("$", ""))
                    
                    sale["items"].append({
                        "productId": product_id,
                        "productName": values[1],
                        "quantity": sold,
                        "unitPrice": price,
                        "totalPrice": total_price
                    })
                    
                    # Update stock
                    products = MongoDBConnection.get_all_products()
                    for p in products:
                        if p.get('productId') == product_id:
                            new_stock = p.get('stock', 0) - sold
                            update = {
                                "productId": p.get('productId'),
                                "name": p.get('name'),
                                "stock": new_stock,
                                "retailPrice": p.get('retailPrice'),
                                "wholesalePrice": p.get('wholesalePrice'),
                                "category": p.get('category', 'Other')
                            }
                            MongoDBConnection.update_product(p.get('_id'), update)
                            break
                
                MongoDBConnection.save_sale(sale)
                
                messagebox.showinfo("Success", f"✅ Sale saved!\nSale ID: {self.sale_counter}")
                
                # Clear cart
                self.clear_cart()
                self.customer_entry.delete(0, tk.END)
                self.status_label.config(text="Status: Ready")
                
                # Refresh data
                self.load_products()
                self.load_product_combo()
                self.load_history()
                
                self.sale_counter += 1
                
            except Exception as e:
                messagebox.showerror("Error", f"Error: {e}")
    
    def clear_cart(self):
        """Clear shopping cart"""
        for item in self.cart_tree.get_children():
            self.cart_tree.delete(item)
        self.update_totals()
        self.status_label.config(text="Status: Cart cleared")
    
    # ==================== PRODUCTS TAB ====================
    
    def create_products_tab(self):
        """Create products tab"""
        tab = ttk.Frame(self.notebook)
        self.notebook.add(tab, text="PRODUCTS")
        
        main_frame = ttk.Frame(tab)
        main_frame.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        # Search Frame
        search_frame = ttk.Frame(main_frame)
        search_frame.pack(fill=tk.X, pady=(0, 10))
        
        ttk.Label(search_frame, text="Search:").pack(side=tk.LEFT, padx=5)
        self.product_search_entry = ttk.Entry(search_frame, width=30)
        self.product_search_entry.pack(side=tk.LEFT, padx=5)
        
        ttk.Button(search_frame, text="Search", command=self.search_products).pack(side=tk.LEFT, padx=5)
        ttk.Button(search_frame, text="Refresh", command=self.load_products).pack(side=tk.LEFT, padx=5)
        ttk.Button(search_frame, text="Add Product", command=self.show_add_product_dialog).pack(side=tk.RIGHT, padx=5)
        ttk.Button(search_frame, text="Edit", command=self.show_edit_product_dialog).pack(side=tk.RIGHT, padx=5)
        ttk.Button(search_frame, text="Delete", command=self.delete_product).pack(side=tk.RIGHT, padx=5)
        
        # Products Treeview
        columns = ("ID", "Name", "Stock", "Retail", "Wholesale", "Category")
        self.products_tree = ttk.Treeview(main_frame, columns=columns, show="headings", height=15)
        
        for col in columns:
            self.products_tree.heading(col, text=col)
            self.products_tree.column(col, width=120)
        
        scrollbar = ttk.Scrollbar(main_frame, orient=tk.VERTICAL, command=self.products_tree.yview)
        self.products_tree.configure(yscrollcommand=scrollbar.set)
        
        self.products_tree.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
    
    def load_products(self):
        """Load products into treeview"""
        for item in self.products_tree.get_children():
            self.products_tree.delete(item)
        
        products = MongoDBConnection.get_all_products()
        
        if not products:
            self.products_tree.insert("", tk.END, values=("--", "No products yet", 0, "--", "--", "--"))
        else:
            for p in products:
                self.products_tree.insert("", tk.END, values=(
                    p.get('productId', '--'),
                    p.get('name', '--'),
                    p.get('stock', 0),
                    f"${p.get('retailPrice', 0):.2f}",
                    f"${p.get('wholesalePrice', 0):.2f}",
                    p.get('category', '--')
                ))
    
    def search_products(self):
        """Search products by name or ID"""
        term = self.product_search_entry.get().strip().lower()
        if not term:
            self.load_products()
            return
        
        for item in self.products_tree.get_children():
            self.products_tree.delete(item)
        
        products = MongoDBConnection.get_all_products()
        
        for p in products:
            name = p.get('name', '').lower()
            pid = p.get('productId', '').lower()
            if term in name or term in pid:
                self.products_tree.insert("", tk.END, values=(
                    p.get('productId', '--'),
                    p.get('name', '--'),
                    p.get('stock', 0),
                    f"${p.get('retailPrice', 0):.2f}",
                    f"${p.get('wholesalePrice', 0):.2f}",
                    p.get('category', '--')
                ))
    
    def show_add_product_dialog(self):
        """Show add product dialog"""
        dialog = tk.Toplevel(self.root)
        dialog.title("Add Product")
        dialog.geometry("400x350")
        dialog.transient(self.root)
        dialog.grab_set()
        
        ttk.Label(dialog, text="ID:").grid(row=0, column=0, padx=10, pady=10, sticky=tk.W)
        id_entry = ttk.Entry(dialog, width=30)
        id_entry.grid(row=0, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Name:").grid(row=1, column=0, padx=10, pady=10, sticky=tk.W)
        name_entry = ttk.Entry(dialog, width=30)
        name_entry.grid(row=1, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Stock:").grid(row=2, column=0, padx=10, pady=10, sticky=tk.W)
        stock_spin = ttk.Spinbox(dialog, from_=0, to=9999, width=28)
        stock_spin.set(0)
        stock_spin.grid(row=2, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Retail Price:").grid(row=3, column=0, padx=10, pady=10, sticky=tk.W)
        retail_entry = ttk.Entry(dialog, width=30)
        retail_entry.grid(row=3, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Wholesale Price:").grid(row=4, column=0, padx=10, pady=10, sticky=tk.W)
        wholesale_entry = ttk.Entry(dialog, width=30)
        wholesale_entry.grid(row=4, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Category:").grid(row=5, column=0, padx=10, pady=10, sticky=tk.W)
        category_combo = ttk.Combobox(dialog, values=["Electronics", "Clothing", "Food", "Other"], width=27, state="readonly")
        category_combo.set("Other")
        category_combo.grid(row=5, column=1, padx=10, pady=10)
        
        def save():
            try:
                product = {
                    "productId": id_entry.get().strip(),
                    "name": name_entry.get().strip(),
                    "stock": int(stock_spin.get()),
                    "retailPrice": float(retail_entry.get()),
                    "wholesalePrice": float(wholesale_entry.get()),
                    "category": category_combo.get()
                }
                MongoDBConnection.save_product(product)
                self.load_products()
                self.load_product_combo()
                messagebox.showinfo("Success", "Product saved!")
                dialog.destroy()
            except Exception as e:
                messagebox.showerror("Error", f"Error: {e}")
        
        ttk.Button(dialog, text="Save", command=save).grid(row=6, column=0, padx=10, pady=20)
        ttk.Button(dialog, text="Cancel", command=dialog.destroy).grid(row=6, column=1, padx=10, pady=20)
    
    def show_edit_product_dialog(self):
        """Show edit product dialog"""
        selection = self.products_tree.selection()
        if not selection:
            messagebox.showwarning("Warning", "Select a product")
            return
        
        values = self.products_tree.item(selection[0])['values']
        if values[0] == "--":
            messagebox.showwarning("Warning", "Select a valid product")
            return
        
        product_id = values[0]
        name = values[1]
        stock = values[2]
        retail = values[3].replace("$", "")
        wholesale = values[4].replace("$", "")
        category = values[5]
        
        dialog = tk.Toplevel(self.root)
        dialog.title("Edit Product")
        dialog.geometry("400x350")
        dialog.transient(self.root)
        dialog.grab_set()
        
        ttk.Label(dialog, text="ID:").grid(row=0, column=0, padx=10, pady=10, sticky=tk.W)
        ttk.Label(dialog, text=product_id).grid(row=0, column=1, padx=10, pady=10, sticky=tk.W)
        
        ttk.Label(dialog, text="Name:").grid(row=1, column=0, padx=10, pady=10, sticky=tk.W)
        name_entry = ttk.Entry(dialog, width=30)
        name_entry.insert(0, name)
        name_entry.grid(row=1, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Stock:").grid(row=2, column=0, padx=10, pady=10, sticky=tk.W)
        stock_spin = ttk.Spinbox(dialog, from_=0, to=9999, width=28)
        stock_spin.set(stock)
        stock_spin.grid(row=2, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Retail Price:").grid(row=3, column=0, padx=10, pady=10, sticky=tk.W)
        retail_entry = ttk.Entry(dialog, width=30)
        retail_entry.insert(0, retail)
        retail_entry.grid(row=3, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Wholesale Price:").grid(row=4, column=0, padx=10, pady=10, sticky=tk.W)
        wholesale_entry = ttk.Entry(dialog, width=30)
        wholesale_entry.insert(0, wholesale)
        wholesale_entry.grid(row=4, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Category:").grid(row=5, column=0, padx=10, pady=10, sticky=tk.W)
        category_combo = ttk.Combobox(dialog, values=["Electronics", "Clothing", "Food", "Other"], width=27, state="readonly")
        category_combo.set(category)
        category_combo.grid(row=5, column=1, padx=10, pady=10)
        
        def update():
            try:
                updated = {
                    "productId": product_id,
                    "name": name_entry.get().strip(),
                    "stock": int(stock_spin.get()),
                    "retailPrice": float(retail_entry.get()),
                    "wholesalePrice": float(wholesale_entry.get()),
                    "category": category_combo.get()
                }
                
                products = MongoDBConnection.get_all_products()
                for p in products:
                    if p.get('productId') == product_id:
                        MongoDBConnection.update_product(p.get('_id'), updated)
                        break
                
                self.load_products()
                self.load_product_combo()
                messagebox.showinfo("Success", "Product updated!")
                dialog.destroy()
            except Exception as e:
                messagebox.showerror("Error", f"Error: {e}")
        
        ttk.Button(dialog, text="Update", command=update).grid(row=6, column=0, padx=10, pady=20)
        ttk.Button(dialog, text="Cancel", command=dialog.destroy).grid(row=6, column=1, padx=10, pady=20)
    
    def delete_product(self):
        """Delete selected product"""
        selection = self.products_tree.selection()
        if not selection:
            messagebox.showwarning("Warning", "Select a product")
            return
        
        values = self.products_tree.item(selection[0])['values']
        if values[0] == "--":
            messagebox.showwarning("Warning", "Select a valid product")
            return
        
        product_id = values[0]
        name = values[1]
        
        confirm = messagebox.askyesno("Confirm", f"Delete {name}?")
        if confirm:
            products = MongoDBConnection.get_all_products()
            for p in products:
                if p.get('productId') == product_id:
                    MongoDBConnection.delete_product(p.get('_id'))
                    break
            
            self.load_products()
            self.load_product_combo()
            messagebox.showinfo("Success", "Product deleted")
    
    # ==================== SUPPLIERS TAB ====================
    
    def create_suppliers_tab(self):
        """Create suppliers tab"""
        tab = ttk.Frame(self.notebook)
        self.notebook.add(tab, text="SUPPLIERS")
        
        main_frame = ttk.Frame(tab)
        main_frame.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        # Search Frame
        search_frame = ttk.Frame(main_frame)
        search_frame.pack(fill=tk.X, pady=(0, 10))
        
        ttk.Label(search_frame, text="Search:").pack(side=tk.LEFT, padx=5)
        self.supplier_search_entry = ttk.Entry(search_frame, width=30)
        self.supplier_search_entry.pack(side=tk.LEFT, padx=5)
        
        ttk.Button(search_frame, text="Search", command=self.search_suppliers).pack(side=tk.LEFT, padx=5)
        ttk.Button(search_frame, text="Refresh", command=self.load_suppliers).pack(side=tk.LEFT, padx=5)
        ttk.Button(search_frame, text="Add Supplier", command=self.show_add_supplier_dialog).pack(side=tk.RIGHT, padx=5)
        ttk.Button(search_frame, text="Edit", command=self.show_edit_supplier_dialog).pack(side=tk.RIGHT, padx=5)
        ttk.Button(search_frame, text="Delete", command=self.delete_supplier).pack(side=tk.RIGHT, padx=5)
        
        # Suppliers Treeview
        columns = ("ID", "Name", "Phone", "Email", "Address")
        self.suppliers_tree = ttk.Treeview(main_frame, columns=columns, show="headings", height=15)
        
        for col in columns:
            self.suppliers_tree.heading(col, text=col)
            self.suppliers_tree.column(col, width=140)
        
        scrollbar = ttk.Scrollbar(main_frame, orient=tk.VERTICAL, command=self.suppliers_tree.yview)
        self.suppliers_tree.configure(yscrollcommand=scrollbar.set)
        
        self.suppliers_tree.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
    
    def load_suppliers(self):
        """Load suppliers into treeview"""
        for item in self.suppliers_tree.get_children():
            self.suppliers_tree.delete(item)
        
        suppliers = MongoDBConnection.get_all_suppliers()
        
        if not suppliers:
            self.suppliers_tree.insert("", tk.END, values=("--", "No suppliers yet", "--", "--", "--"))
        else:
            for s in suppliers:
                self.suppliers_tree.insert("", tk.END, values=(
                    s.get('supplierId', '--'),
                    s.get('name', '--'),
                    s.get('phone', '--'),
                    s.get('email', '--'),
                    s.get('address', '--')
                ))
    
    def search_suppliers(self):
        """Search suppliers by name or ID"""
        term = self.supplier_search_entry.get().strip().lower()
        if not term:
            self.load_suppliers()
            return
        
        for item in self.suppliers_tree.get_children():
            self.suppliers_tree.delete(item)
        
        suppliers = MongoDBConnection.get_all_suppliers()
        
        for s in suppliers:
            name = s.get('name', '').lower()
            sid = s.get('supplierId', '').lower()
            if term in name or term in sid:
                self.suppliers_tree.insert("", tk.END, values=(
                    s.get('supplierId', '--'),
                    s.get('name', '--'),
                    s.get('phone', '--'),
                    s.get('email', '--'),
                    s.get('address', '--')
                ))
    
    def show_add_supplier_dialog(self):
        """Show add supplier dialog"""
        dialog = tk.Toplevel(self.root)
        dialog.title("Add Supplier")
        dialog.geometry("400x350")
        dialog.transient(self.root)
        dialog.grab_set()
        
        ttk.Label(dialog, text="ID:").grid(row=0, column=0, padx=10, pady=10, sticky=tk.W)
        id_entry = ttk.Entry(dialog, width=30)
        id_entry.grid(row=0, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Name:").grid(row=1, column=0, padx=10, pady=10, sticky=tk.W)
        name_entry = ttk.Entry(dialog, width=30)
        name_entry.grid(row=1, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Phone:").grid(row=2, column=0, padx=10, pady=10, sticky=tk.W)
        phone_entry = ttk.Entry(dialog, width=30)
        phone_entry.grid(row=2, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Email:").grid(row=3, column=0, padx=10, pady=10, sticky=tk.W)
        email_entry = ttk.Entry(dialog, width=30)
        email_entry.grid(row=3, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Address:").grid(row=4, column=0, padx=10, pady=10, sticky=tk.W)
        address_entry = ttk.Entry(dialog, width=30)
        address_entry.grid(row=4, column=1, padx=10, pady=10)
        
        def save():
            supplier = {
                "supplierId": id_entry.get().strip(),
                "name": name_entry.get().strip(),
                "phone": phone_entry.get().strip(),
                "email": email_entry.get().strip(),
                "address": address_entry.get().strip()
            }
            MongoDBConnection.save_supplier(supplier)
            self.load_suppliers()
            messagebox.showinfo("Success", "Supplier saved!")
            dialog.destroy()
        
        ttk.Button(dialog, text="Save", command=save).grid(row=5, column=0, padx=10, pady=20)
        ttk.Button(dialog, text="Cancel", command=dialog.destroy).grid(row=5, column=1, padx=10, pady=20)
    
    def show_edit_supplier_dialog(self):
        """Show edit supplier dialog"""
        selection = self.suppliers_tree.selection()
        if not selection:
            messagebox.showwarning("Warning", "Select a supplier")
            return
        
        values = self.suppliers_tree.item(selection[0])['values']
        if values[0] == "--":
            messagebox.showwarning("Warning", "Select a valid supplier")
            return
        
        supplier_id = values[0]
        name = values[1]
        phone = values[2]
        email = values[3]
        address = values[4]
        
        dialog = tk.Toplevel(self.root)
        dialog.title("Edit Supplier")
        dialog.geometry("400x350")
        dialog.transient(self.root)
        dialog.grab_set()
        
        ttk.Label(dialog, text="ID:").grid(row=0, column=0, padx=10, pady=10, sticky=tk.W)
        ttk.Label(dialog, text=supplier_id).grid(row=0, column=1, padx=10, pady=10, sticky=tk.W)
        
        ttk.Label(dialog, text="Name:").grid(row=1, column=0, padx=10, pady=10, sticky=tk.W)
        name_entry = ttk.Entry(dialog, width=30)
        name_entry.insert(0, name)
        name_entry.grid(row=1, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Phone:").grid(row=2, column=0, padx=10, pady=10, sticky=tk.W)
        phone_entry = ttk.Entry(dialog, width=30)
        phone_entry.insert(0, phone)
        phone_entry.grid(row=2, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Email:").grid(row=3, column=0, padx=10, pady=10, sticky=tk.W)
        email_entry = ttk.Entry(dialog, width=30)
        email_entry.insert(0, email)
        email_entry.grid(row=3, column=1, padx=10, pady=10)
        
        ttk.Label(dialog, text="Address:").grid(row=4, column=0, padx=10, pady=10, sticky=tk.W)
        address_entry = ttk.Entry(dialog, width=30)
        address_entry.insert(0, address)
        address_entry.grid(row=4, column=1, padx=10, pady=10)
        
        def update():
            updated = {
                "supplierId": supplier_id,
                "name": name_entry.get().strip(),
                "phone": phone_entry.get().strip(),
                "email": email_entry.get().strip(),
                "address": address_entry.get().strip()
            }
            
            suppliers = MongoDBConnection.get_all_suppliers()
            for s in suppliers:
                if s.get('supplierId') == supplier_id:
                    MongoDBConnection.update_supplier(s.get('_id'), updated)
                    break
            
            self.load_suppliers()
            messagebox.showinfo("Success", "Supplier updated!")
            dialog.destroy()
        
        ttk.Button(dialog, text="Update", command=update).grid(row=5, column=0, padx=10, pady=20)
        ttk.Button(dialog, text="Cancel", command=dialog.destroy).grid(row=5, column=1, padx=10, pady=20)
    
    def delete_supplier(self):
        """Delete selected supplier"""
        selection = self.suppliers_tree.selection()
        if not selection:
            messagebox.showwarning("Warning", "Select a supplier")
            return
        
        values = self.suppliers_tree.item(selection[0])['values']
        if values[0] == "--":
            messagebox.showwarning("Warning", "Select a valid supplier")
            return
        
        supplier_id = values[0]
        name = values[1]
        
        confirm = messagebox.askyesno("Confirm", f"Delete {name}?")
        if confirm:
            suppliers = MongoDBConnection.get_all_suppliers()
            for s in suppliers:
                if s.get('supplierId') == supplier_id:
                    MongoDBConnection.delete_supplier(s.get('_id'))
                    break
            
            self.load_suppliers()
            messagebox.showinfo("Success", "Supplier deleted")
    
    # ==================== HISTORY TAB ====================
    
    def create_history_tab(self):
        """Create history tab"""
        tab = ttk.Frame(self.notebook)
        self.notebook.add(tab, text="HISTORY")
        
        main_frame = ttk.Frame(tab)
        main_frame.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        # Refresh button
        btn_frame = ttk.Frame(main_frame)
        btn_frame.pack(fill=tk.X, pady=(0, 10))
        ttk.Button(btn_frame, text="Refresh", command=self.load_history).pack(side=tk.LEFT)
        
        # History Treeview
        columns = ("ID", "Date", "Customer", "Payment", "Total")
        self.history_tree = ttk.Treeview(main_frame, columns=columns, show="headings", height=20)
        
        for col in columns:
            self.history_tree.heading(col, text=col)
            self.history_tree.column(col, width=150)
        
        scrollbar = ttk.Scrollbar(main_frame, orient=tk.VERTICAL, command=self.history_tree.yview)
        self.history_tree.configure(yscrollcommand=scrollbar.set)
        
        self.history_tree.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
    
    def load_history(self):
        """Load sales history"""
        for item in self.history_tree.get_children():
            self.history_tree.delete(item)
        
        sales = MongoDBConnection.get_all_sales()
        
        if not sales:
            self.history_tree.insert("", tk.END, values=("--", "No sales yet", "--", "--", "--"))
        else:
            for s in sales:
                sale_id = s.get('saleId', '--')
                date = s.get('date', '--')
                customer = s.get('customerName', '--')
                payment = s.get('paymentMethod', '--')
                total = s.get('total', 0)
                
                self.history_tree.insert("", tk.END, values=(
                    sale_id, date, customer, payment, f"${total:.2f}"
                ))
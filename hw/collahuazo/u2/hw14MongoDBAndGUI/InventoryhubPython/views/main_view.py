import tkinter as tk
from tkinter import messagebox
from tkinter import ttk

from controllers import (
    get_all_customers,
    get_all_products,
    get_all_suppliers,
    insert_customer,
    insert_product,
    insert_supplier,
)
from models import Customer, Product, Supplier


class InventoryHubGUI:
    def __init__(self, root: tk.Tk) -> None:
        self.root = root
        self.root.title("InventoryHub")
        self.root.geometry("760x520")

        notebook = ttk.Notebook(self.root)
        notebook.pack(fill="both", expand=True)

        self.customer_frame = ttk.Frame(notebook)
        self.product_frame = ttk.Frame(notebook)
        self.supplier_frame = ttk.Frame(notebook)
        self.info_frame = ttk.Frame(notebook)

        notebook.add(self.customer_frame, text="Customer")
        notebook.add(self.product_frame, text="Product")
        notebook.add(self.supplier_frame, text="Supplier")
        notebook.add(self.info_frame, text="Info")

        self._create_customer_tab()
        self._create_product_tab()
        self._create_supplier_tab()
        self._create_info_tab()

    def _create_customer_tab(self) -> None:
        fields = [
            ("RUC", "customer_ruc"),
            ("Name", "customer_name"),
            ("Address", "customer_address"),
            ("Gmail", "customer_email"),
        ]
        self.customer_vars = {name: tk.StringVar() for _, name in fields}

        for index, (label_text, var_name) in enumerate(fields):
            label = ttk.Label(self.customer_frame, text=label_text)
            label.grid(row=index, column=0, padx=10, pady=10, sticky="e")
            entry = ttk.Entry(self.customer_frame, textvariable=self.customer_vars[var_name], width=40)
            entry.grid(row=index, column=1, padx=10, pady=10, sticky="w")

        insert_btn = ttk.Button(self.customer_frame, text="Insert", command=self._handle_insert_customer)
        insert_btn.grid(row=len(fields), column=0, columnspan=2, pady=20)

    def _create_product_tab(self) -> None:
        fields = [
            ("ID", "product_id"),
            ("Name", "product_name"),
            ("Unit Price", "product_price"),
            ("Stock", "product_stock"),
        ]
        self.product_vars = {name: tk.StringVar() for _, name in fields}

        for index, (label_text, var_name) in enumerate(fields):
            label = ttk.Label(self.product_frame, text=label_text)
            label.grid(row=index, column=0, padx=10, pady=10, sticky="e")
            if var_name == "product_stock":
                entry = ttk.Spinbox(
                    self.product_frame,
                    from_=0,
                    to=10000,
                    textvariable=self.product_vars[var_name],
                    width=38,
                )
            else:
                entry = ttk.Entry(self.product_frame, textvariable=self.product_vars[var_name], width=40)
            entry.grid(row=index, column=1, padx=10, pady=10, sticky="w")

        insert_btn = ttk.Button(self.product_frame, text="Insert", command=self._handle_insert_product)
        insert_btn.grid(row=len(fields), column=0, columnspan=2, pady=20)

    def _create_supplier_tab(self) -> None:
        fields = [
            ("RUC", "supplier_ruc"),
            ("Company Name", "supplier_company"),
            ("Address", "supplier_address"),
            ("Phone", "supplier_phone"),
            ("Email", "supplier_email"),
        ]
        self.supplier_vars = {name: tk.StringVar() for _, name in fields}

        for index, (label_text, var_name) in enumerate(fields):
            label = ttk.Label(self.supplier_frame, text=label_text)
            label.grid(row=index, column=0, padx=10, pady=10, sticky="e")
            entry = ttk.Entry(self.supplier_frame, textvariable=self.supplier_vars[var_name], width=40)
            entry.grid(row=index, column=1, padx=10, pady=10, sticky="w")

        insert_btn = ttk.Button(self.supplier_frame, text="Insert", command=self._handle_insert_supplier)
        insert_btn.grid(row=len(fields), column=0, columnspan=2, pady=20)

    def _create_info_tab(self) -> None:
        selection_frame = ttk.Frame(self.info_frame)
        selection_frame.pack(fill="x", pady=10)

        label = ttk.Label(selection_frame, text="Consult information of:")
        label.pack(side="left", padx=8)

        self.info_selection = tk.StringVar(value="Customer")
        combo = ttk.Combobox(
            selection_frame,
            textvariable=self.info_selection,
            values=["Customer", "Product", "Supplier"],
            state="readonly",
            width=18,
        )
        combo.pack(side="left", padx=8)
        combo.bind("<<ComboboxSelected>>", lambda _: self._populate_info_table())

        button = ttk.Button(selection_frame, text="Accept", command=self._populate_info_table)
        button.pack(side="left", padx=8)

        self.tree = ttk.Treeview(self.info_frame, show="headings", selectmode="browse")
        self.tree.pack(fill="both", expand=True, padx=10, pady=10)

        self._populate_info_table()

    def _handle_insert_customer(self) -> None:
        try:
            ruc = int(self.customer_vars["customer_ruc"].get().strip())
            name = self.customer_vars["customer_name"].get().strip()
            address = self.customer_vars["customer_address"].get().strip()
            gmail_customer = self.customer_vars["customer_email"].get().strip()

            customer = Customer(ruc=ruc, name=name, address=address, gmail_customer=gmail_customer)
            insert_customer(customer)

            messagebox.showinfo("Success", "Customer saved successfully.")
            self._clear_customer_fields()
            self._populate_info_table()
        except ValueError:
            messagebox.showerror("Validation error", "The RUC must be a valid number.")
        except Exception as exc:
            messagebox.showerror("Error", f"Error saving customer: {exc}")

    def _handle_insert_product(self) -> None:
        try:
            product_id = self.product_vars["product_id"].get().strip()
            name = self.product_vars["product_name"].get().strip()
            unit_price = float(self.product_vars["product_price"].get().strip())
            stock = int(self.product_vars["product_stock"].get().strip())

            product = Product(id=product_id, name=name, unit_price=unit_price, stock=stock)
            insert_product(product)

            messagebox.showinfo("Success", "Product inserted successfully.")
            self._clear_product_fields()
            self._populate_info_table()
        except ValueError:
            messagebox.showerror("Validation error", "Please enter valid values for price and stock.")
        except Exception as exc:
            messagebox.showerror("Error", f"Error saving product: {exc}")

    def _handle_insert_supplier(self) -> None:
        try:
            ruc = self.supplier_vars["supplier_ruc"].get().strip()
            company_name = self.supplier_vars["supplier_company"].get().strip()
            address = self.supplier_vars["supplier_address"].get().strip()
            phone = self.supplier_vars["supplier_phone"].get().strip()
            email = self.supplier_vars["supplier_email"].get().strip()

            supplier = Supplier(
                ruc=ruc,
                company_name=company_name,
                address=address,
                phone=phone,
                email=email,
            )
            insert_supplier(supplier)

            messagebox.showinfo("Success", "Supplier saved successfully.")
            self._clear_supplier_fields()
            self._populate_info_table()
        except ValueError as exc:
            messagebox.showerror("Validation error", str(exc))
        except Exception as exc:
            messagebox.showerror("Error", f"Error saving supplier: {exc}")

    def _clear_customer_fields(self) -> None:
        for var in self.customer_vars.values():
            var.set("")

    def _clear_product_fields(self) -> None:
        for var in self.product_vars.values():
            var.set("")

    def _clear_supplier_fields(self) -> None:
        for var in self.supplier_vars.values():
            var.set("")

    def _populate_info_table(self) -> None:
        selection = self.info_selection.get()
        if selection == "Customer":
            columns = ["ruc", "name", "address", "gmailCustomer"]
            headings = ["RUC", "Name", "Address", "Gmail"]
            documents = get_all_customers()
        elif selection == "Product":
            columns = ["id", "name", "unitPrice", "stock"]
            headings = ["ID", "Name", "Unit Price", "Stock"]
            documents = get_all_products()
        else:
            columns = ["ruc", "companyName", "address", "phone", "email"]
            headings = ["RUC", "Company", "Address", "Phone", "Email"]
            documents = get_all_suppliers()

        for item in self.tree.get_children():
            self.tree.delete(item)

        self.tree["columns"] = headings
        for heading in headings:
            self.tree.heading(heading, text=heading)
            self.tree.column(heading, width=130, anchor="center")

        for doc in documents:
            values = [doc.get(col, "") for col in columns]
            self.tree.insert("", "end", values=values)

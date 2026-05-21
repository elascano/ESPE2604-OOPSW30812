import tkinter as tk
from tkinter import messagebox, ttk


class InventoryApp:

    def __init__(self, root):
        self.root = root
        self.root.title("Product Management")
        self.root.geometry("600x400")

        self.products = {}

        frame_inputs = tk.LabelFrame(
            root, text=" Register Product ", padx=10, pady=10
        )
        frame_inputs.pack(fill="x", padx=15, pady=(15, 10))

        tk.Label(frame_inputs, text="Product ID:").grid(
            row=0, column=0, sticky="w", padx=5, pady=5
        )
        self.entry_id = tk.Entry(frame_inputs)
        self.entry_id.grid(row=0, column=1, padx=5, pady=5)

        tk.Label(frame_inputs, text="Name:").grid(
            row=0, column=2, sticky="w", padx=5, pady=5
        )
        self.entry_name = tk.Entry(frame_inputs)
        self.entry_name.grid(row=0, column=3, padx=5, pady=5)

        btn_save = tk.Button(
            frame_inputs,
            text="Save",
            command=self.add_product,
            bg="#4CAF50",
            fg="white",
        )
        btn_save.grid(row=0, column=4, padx=10, pady=5)

        frame_table = tk.Frame(root)
        frame_table.pack(fill="both", expand=True, padx=15, pady=5)

        self.table = ttk.Treeview(
            frame_table, columns=("ID", "Name"), show="headings"
        )
        self.table.heading("ID", text="Product ID")
        self.table.heading("Name", text="Product Name")

        self.table.column("ID", width=150, anchor="center")
        self.table.column("Name", width=350, anchor="w")
        self.table.pack(side="left", fill="both", expand=True)

        scrollbar = ttk.Scrollbar(
            frame_table, orient="vertical", command=self.table.yview
        )
        self.table.configure(yscrollcommand=scrollbar.set)
        scrollbar.pack(side="right", fill="y")

        frame_actions = tk.Frame(root, padx=10, pady=10)
        frame_actions.pack(fill="x", padx=15, pady=10)

        tk.Label(frame_actions, text="ID to Delete:").pack(side="left", padx=5)
        self.entry_delete_id = tk.Entry(frame_actions, width=15)
        self.entry_delete_id.pack(side="left", padx=5)

        btn_delete = tk.Button(
            frame_actions,
            text="Delete by ID",
            command=self.delete_by_id,
            bg="#f44336",
            fg="white",
        )
        btn_delete.pack(side="left", padx=10)

    def update_table(self):
        for row in self.table.get_children():
            self.table.delete(row)

        for prod_id, prod_name in self.products.items():
            self.table.insert("", "end", values=(prod_id, prod_name))

    def add_product(self):
        prod_id = self.entry_id.get().strip()
        name = self.entry_name.get().strip()

        if not prod_id or not name:
            messagebox.showwarning(
                "Empty Fields", "Please fill in both ID and Name."
            )
            return

        if prod_id in self.products:
            messagebox.showerror(
                "ID Error", f"The ID '{prod_id}' already exists in the system."
            )
            return

        self.products[prod_id] = name
        self.update_table()

        self.entry_id.delete(0, tk.END)
        self.entry_name.delete(0, tk.END)
        self.entry_id.focus()

    def delete_by_id(self):
        id_to_delete = self.entry_delete_id.get().strip()

        if not id_to_delete:
            messagebox.showwarning(
                "Empty Field", "Please type the product ID you want to delete."
            )
            return

        if id_to_delete in self.products:
            del self.products[id_to_delete]
            self.update_table()
            self.entry_delete_id.delete(0, tk.END)
            messagebox.showinfo(
                "Success", f"Product with ID '{id_to_delete}' has been deleted."
            )
        else:
            messagebox.showerror(
                "Not Found", f"No product found with ID '{id_to_delete}'."
            )


if __name__ == "__main__":
    main_window = tk.Tk()
    app = InventoryApp(main_window)
    main_window.mainloop()
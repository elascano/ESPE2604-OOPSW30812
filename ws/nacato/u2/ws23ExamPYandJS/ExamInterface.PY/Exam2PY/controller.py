from model import Bank
from view import BankView

class BankController:
    def __init__(self, view: BankView):
        self.banks = []
        self.view = view
        
        self.view.btn_create.config(command=self.create_bank)
        self.view.btn_update.config(command=self.update_bank)
        self.view.btn_delete.config(command=self.delete_bank)
        self.view.btn_clear.config(command=self.view.clear_inputs)
        
        self.view.tree.bind("<<TreeviewSelect>>", self.on_tree_select)

    def create_bank(self):
        try:
            data = self.view.get_bank_data()
            if not data["id"] or not data["name"]:
                self.view.display_error("All fields are required.")
                return

            for bank in self.banks:
                if bank.id == data["id"]:
                    self.view.display_error("A bank with this ID already exists.")
                    return

            new_bank = Bank(data["id"], data["name"], data["total_deposits"], data["total_loans"])
            self.banks.append(new_bank)
            
            self.view.display_message(f"Bank '{new_bank.name}' added successfully.")
            self.view.clear_inputs()
            self.view.update_tree(self.banks)
        except ValueError as e:
            self.view.display_error(str(e))

    def update_bank(self):
        try:
            data = self.view.get_bank_data()
            
            for bank in self.banks:
                if bank.id == data["id"]:
                    bank.name = data["name"]
                    bank.total_deposits = data["total_deposits"]
                    bank.total_loans = data["total_loans"]
                    
                    self.view.display_message("Bank updated successfully.")
                    self.view.clear_inputs()
                    self.view.update_tree(self.banks)
                    return
            
            self.view.display_error("Bank ID not found. You cannot change the ID of a bank.")
        except ValueError as e:
            self.view.display_error(str(e))

    def delete_bank(self):
        id_to_delete = self.view.ent_id.get().strip()
        
        if not id_to_delete:
            self.view.display_error("Please enter or select a Bank ID to delete.")
            return

        for bank in self.banks:
            if bank.id == id_to_delete:
                self.banks.remove(bank)
                self.view.display_message("Bank deleted successfully.")
                self.view.clear_inputs()
                self.view.update_tree(self.banks)
                return
                
        self.view.display_error("Bank ID not found.")

    def on_tree_select(self, event):
        selected_items = self.view.tree.selection()
        if not selected_items:
            return
            
        item = selected_items[0]
        values = self.view.tree.item(item, "values")
        
        id_val = values[0]
        name_val = values[1]
        deposits_val = values[2].replace("$", "")
        loans_val = values[3].replace("$", "")
        
        self.view.set_bank_data(id_val, name_val, deposits_val, loans_val)

    def start(self):
        self.view.mainloop()
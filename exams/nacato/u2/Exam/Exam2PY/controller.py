from model import Bank
from view import BankView

class BankController:
    def __init__(self):
        self.banks = []
        self.view = BankView()

    def create_bank(self):
        data = self.view.get_bank_data()
        
        new_bank = Bank(data["id"], data["name"], data["total_deposits"], data["total_loans"])
        
        self.banks.append(new_bank)
        
        self.view.display_message(f"Bank '{new_bank.name}' created successfully!")
        print(f"Calculated Business Logic (Net Worth): ${new_bank.compute_net_worth():.2f}")

    def start(self):
        while True:
            self.view.show_menu()
            option = input("Select an option: ")
            if option == "1":
                self.create_bank()
            elif option == "2":
                print("Exiting system...")
                break
            else:
                print("Invalid option.")

if __name__ == "__main__":
    controller = BankController()
    controller.start()
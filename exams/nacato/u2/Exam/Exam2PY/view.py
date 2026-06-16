class BankView:
    @staticmethod
    def show_menu():
        print("\nACME COMPANY: BANK MANAGEMENT")
        print("1. Create Bank")
        print("2. Exit")
        
    @staticmethod
    def get_bank_data() -> dict:
        print("\nCreate New Bank")
        id_bank = input("Enter Bank ID: ")
        name = input("Enter Bank Name: ")
        while True:
            try:
                total_deposits = float(input("Enter Total Deposits: "))
                total_loans = float(input("Enter Total Loans: "))
                break
            except ValueError:
                print("Invalid numeric value. Try again.")
        return {
            "id": id_bank,
            "name": name,
            "total_deposits": total_deposits,
            "total_loans": total_loans
        }

    @staticmethod
    def display_message(message: str):
        print(f"\n[INFO] {message}")
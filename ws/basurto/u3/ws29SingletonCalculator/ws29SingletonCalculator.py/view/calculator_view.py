class CalculatorView:
    def get_input_amount(self):
        return float(input("Enter the subtotal amount: "))

    def get_input_tax_rate(self):
        return float(input("Enter the tax rate percentage: "))

    def display_result(self, total):
        print("=======================================")
        print(f"Total sales with tax: ${total:.2f}")
        print("=======================================")
from model.us_tax import USTax

class CalculatorController:
    def __init__(self, view):
        self.view = view

    def run_default_calculation(self):
        tax = USTax.get_instance()
        total = tax.sales_total()
        self.view.display_result(total)

    def run_interactive_calculation(self):
        amount = self.view.get_input_amount()
        tax_rate = self.view.get_input_tax_rate()
        tax = USTax.get_instance()
        total = tax.calculate_tax(amount, tax_rate)
        self.view.display_result(total)
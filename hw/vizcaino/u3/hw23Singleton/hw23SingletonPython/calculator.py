from ustax import USTax

class Calculator:
    @staticmethod
    def main():
        tax_service = USTax.get_instance()

        sale_amount = 100.0
        tax = tax_service.calculate_tax(sale_amount)
        total = sale_amount + tax

        print(f"Sale Amount: ${sale_amount}")
        print(f"Applied Tax Rate: {tax_service.get_tax_rate() * 100}%")
        print(f"Calculated Tax: ${tax}")
        print(f"Total Sale: ${total}")


if __name__ == "__main__":
    Calculator.main()
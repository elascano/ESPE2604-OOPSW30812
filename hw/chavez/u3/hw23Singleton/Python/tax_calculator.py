from tax import Tax

class TaxCalculator:

    @staticmethod
    def main():
        # Gets the single instance (Singleton)    
        tax = Tax()

        tax.updateTaxPercentage(15.0)

        subtotal = 250.0

        print("Tax Percentage:", str(tax.getPercentage()) + "%")
        print("Subtotal: $", subtotal)
        print("Total with Tax: $", tax.salesTotal(subtotal))


TaxCalculator.main()
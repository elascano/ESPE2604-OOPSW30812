class Tax:

    @staticmethod
    def compute_iva(amount, tax_percentage):
        return amount * tax_percentage / 100

    @staticmethod
    def compute_total(amount, tax_percentage):
        return amount + Tax.compute_iva(amount, tax_percentage)
#Jennyfer Nase
class Tax:

    @staticmethod
    def compute_iva(amount, tax_percentage):
        tax_value = amount * tax_percentage / 100
        return tax_value

    @staticmethod
    def compute_total(amount, tax_percentage):
        total_value = amount + Tax.compute_iva(amount, tax_percentage)
        return total_value
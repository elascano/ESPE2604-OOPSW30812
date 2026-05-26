class Tax:
    @staticmethod
    def compute_iva(amount: float, tax_percentage: float) -> float:
        """
        Computes the IVA value based on the amount and tax percentage.
        """
        return amount * (tax_percentage / 100.0)

    @staticmethod
    def compute_total(amount: float, tax_percentage: float) -> float:
        """
        Computes the total amount, which is base amount + IVA.
        """
        return amount + Tax.compute_iva(amount, tax_percentage)

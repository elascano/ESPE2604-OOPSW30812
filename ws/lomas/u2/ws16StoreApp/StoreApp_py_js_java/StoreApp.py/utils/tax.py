class Tax:
    @staticmethod
    def compute_total(price: float, tax_percentage: float) -> float:
        return price + (price * (tax_percentage / 100))
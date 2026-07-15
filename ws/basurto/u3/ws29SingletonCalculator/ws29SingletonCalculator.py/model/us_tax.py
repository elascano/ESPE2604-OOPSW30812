class USTax:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(USTax, cls).__new__(cls)
        return cls._instance

    @classmethod
    def get_instance(cls):
        if cls._instance is None:
            cls._instance = cls()
        return cls._instance

    def sales_total(self):
        tax_rate = 0.12
        subtotal = 100.0
        return subtotal + (subtotal * tax_rate)

    def calculate_tax(self, amount, tax_rate):
        return amount + (amount * (tax_rate / 100))
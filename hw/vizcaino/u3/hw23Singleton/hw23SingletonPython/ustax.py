class USTax:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(USTax, cls).__new__(cls)
            cls._instance.tax_rate = 0.0825
        return cls._instance

    @classmethod
    def get_instance(cls):
        return cls()

    def get_tax_rate(self):
        return self.tax_rate

    def set_tax_rate(self, tax_rate):
        self.tax_rate = tax_rate

    def calculate_tax(self, amount):
        return amount * self.tax_rate
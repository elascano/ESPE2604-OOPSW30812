class Tax:
    _instance = None
    _percentage = 0

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(Tax, cls).__new__(cls)
            cls._instance._percentage = 0
        return cls._instance

    def update_tax_percentage(self, percentage):
        self._percentage = percentage

    def get_percentage(self):
        return self._percentage

    def sales_total(self, subtotal):
        tax_amount = subtotal * (self._percentage / 100)
        return subtotal + tax_amount
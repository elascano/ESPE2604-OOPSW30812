class Tax:
    _instance = None

    def __init__(self):
        self.percentage = 0.0

    @classmethod
    def get_instance(cls):
        if cls._instance is None:
            cls._instance = cls()
        return cls._instance

    def update_tax_percentage(self, percentage):
        self.percentage = percentage

    def get_percentage(self):
        return self.percentage

    def sales_total(self, sale):
        return sale + (sale * self.percentage / 100)
class Tax:
    _instance=None
    def __new__(cls):
        if cls._instance is None:
            cls._instance=super().__new__(cls)
            cls._instance.percentage=0.0
        return cls._instance
    def update_tax_percentage(self,p): self.percentage=p
    def sales_total(self,price): return price+price*self.percentage

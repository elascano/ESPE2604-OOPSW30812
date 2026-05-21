class ProductTax:
    def __init__(self):
        self.total_tax = 0.0
        self.products = []

    def add_product(self, name, price):
        tax = price * 0.15
        self.total_tax += tax
        item = {
            "product": name,
            "price": price,
            "iva": tax
        }
        self.products.append(item)
        return tax

    def remove_product(self, index):
        if index < 0 or index >= len(self.products):
            return None
        item = self.products.pop(index)
        self.total_tax -= item["iva"]
        if self.total_tax < 0:
            self.total_tax = 0.0
        return item

    def get_total_tax(self):
        return self.total_tax

    def get_products(self):
        return list(self.products)
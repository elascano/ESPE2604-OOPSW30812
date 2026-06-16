class Product:
    def __init__(self, product_id: int, name: str, category: str, price: float):
        self.id = product_id
        self.name = name
        self.category = category
        self.price = price

    def calculate_subtotal(self, quantity: int) -> float:
        return self.price * quantity

    def calculate_tax(self, subtotal: float) -> float:
        return subtotal * 0.12

    def calculate_total(self, subtotal: float, tax: float) -> float:
        return subtotal + tax
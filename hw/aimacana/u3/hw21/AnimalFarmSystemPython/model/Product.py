class Product:
    def __init__(self, id, description, unit, quantity):
        self.id = id
        self.description = description
        self.unit = unit
        self.quantity = quantity

    def __str__(self):
        return (f"Product{{id={self.id}, "
                f"description={self.description}, "
                f"unit={self.unit}, "
                f"quantity={self.quantity}}}")
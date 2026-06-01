from taxlib import compute_total


class Product:

    def __init__(self, id, description, price):
        self.id = id
        self.description = description
        self.price = price

        self.pvp = compute_total(price, 15)

    def __str__(self):
        return f"""
Product
{{
    id={self.id}
    description={self.description}
    price={self.price}
    pvp={self.pvp}
}}
"""
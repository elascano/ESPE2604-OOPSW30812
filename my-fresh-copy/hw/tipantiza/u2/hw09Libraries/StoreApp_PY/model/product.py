# model/product.py

from utils.tax import Tax

class Product:

    def __init__(self, id, description, price, pvp=None):
        self.id = id
        self.description = description
        self.price = price

        
        if pvp is None:
            self.pvp = Tax.compute_total(price, 15)
        else:
            self.pvp = pvp

    def __str__(self):
        return (
            "Product{\n"
            f"  id={self.id}\n"
            f"  description={self.description}\n"
            f"  price={self.price}\n"
            f"  pvp={self.pvp}\n"
            "}"
        )
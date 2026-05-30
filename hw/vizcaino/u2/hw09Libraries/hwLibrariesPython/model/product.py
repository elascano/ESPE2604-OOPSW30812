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
        return f"Product(id={self.id}, description={self.description}, price={self.price}, pvp={self.pvp})"
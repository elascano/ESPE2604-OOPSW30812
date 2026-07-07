class Product:
    def __init__(self, id, description, unit, quantity):
        self._id = id
        self._description = description
        self._unit = unit
        self._quantity = quantity

    def get_id(self): return self._id
    def set_id(self, id): self._id = id
    def get_description(self): return self._description
    def set_description(self, description): self._description = description
    def get_unit(self): return self._unit
    def set_unit(self, unit): self._unit = unit
    def get_quantity(self): return self._quantity
    def set_quantity(self, quantity): self._quantity = quantity
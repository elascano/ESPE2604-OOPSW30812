class SlaughterHouse:
    def __init__(self, id_house: int, name: str, address: str, cell_phone: str):
        self._id = id_house
        self._name = name
        self._address = address
        self._cell_phone_numbers = cell_phone

class Cut:
    def __init__(self, id_cut: int, description: str, procedure: str, weight: float):
        self._id = id_cut
        self._description = description
        self._procedure = procedure
        self._weight = weight

class Food:
    def __init__(self, id_food: int, description: str):
        self._id = id_food
        self._description = description

class Product:
    def __init__(self, id_product: int, description: str, unit: str, quantity: float):
        self._id = id_product
        self._description = description
        self._unit = unit
        self._quantity = quantity
from abc import ABC

class Item(ABC):
    def __init__(self, item_id: str, name: str, weight: float, description: str, base_value: float):
        self.id = item_id
        self.name = name
        self.weight = weight
        self.description = description
        self.base_value = base_value

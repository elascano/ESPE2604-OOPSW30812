from .item import Item
from models.interfaces.i_consumable import IConsumable
from models.interfaces.i_sellable import ISellable
from .character import Character

class Potion(Item, IConsumable, ISellable):
    def __init__(self, item_id: str, name: str, weight: float, description: str, base_value: float, restoration_amount: float):
        super().__init__(item_id, name, weight, description, base_value)
        self.restoration_amount = restoration_amount

    def consume(self, target: Character):
        print(f"{target.name} consumes {self.name}")
        target.take_damage(-self.restoration_amount)

    def calculate_sale_value(self) -> float:
        return self.base_value

from .item import Item
from models.interfaces.i_equippable import IEquippable
from models.interfaces.i_sellable import ISellable
from models.enums.armor_slot import ArmorSlot
from .character import Character
from models.exceptions.inventory_full_exception import InventoryFullException

class Armor(Item, IEquippable, ISellable):
    def __init__(self, item_id: str, name: str, weight: float, description: str, base_value: float, defense: float, slot: ArmorSlot):
        super().__init__(item_id, name, weight, description, base_value)
        self.defense = defense
        self.slot = slot

    def equip(self, target: Character):
        currently_equipped = target.get_equipped_armor(self.slot)
        target.remove_item(self)
        if currently_equipped is not None:
            currently_equipped.unequip(target)
        target.bonus_defense += self.defense
        target.set_equipped_armor(self.slot, self)

    def unequip(self, target: Character):
        target.bonus_defense -= self.defense
        target.set_equipped_armor(self.slot, None)
        try:
            target.add_item(self)
        except InventoryFullException:
            pass

    def calculate_sale_value(self) -> float:
        return self.base_value

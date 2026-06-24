from .item import Item
from models.interfaces.i_equippable import IEquippable
from models.interfaces.i_sellable import ISellable
from models.enums.artifact_slot import ArtifactSlot
from .character import Character
from models.exceptions.inventory_full_exception import InventoryFullException

class Artifact(Item, IEquippable, ISellable):
    def __init__(self, item_id: str, name: str, weight: float, description: str, base_value: float, bonus_health: float, slot: ArtifactSlot):
        super().__init__(item_id, name, weight, description, base_value)
        self.bonus_health = bonus_health
        self.slot = slot

    def equip(self, target: Character):
        currently_equipped = target.get_equipped_artifact(self.slot)
        target.remove_item(self)
        if currently_equipped is not None:
            currently_equipped.unequip(target)
        target.max_hp += self.bonus_health
        target.heal(self.bonus_health)
        target.set_equipped_artifact(self.slot, self)

    def unequip(self, target: Character):
        target.max_hp -= self.bonus_health
        if target.hp > target.max_hp:
            target.take_damage(target.hp - target.max_hp)
        target.set_equipped_artifact(self.slot, None)
        try:
            target.add_item(self)
        except InventoryFullException:
            pass

    def calculate_sale_value(self) -> float:
        return self.base_value * 1.5

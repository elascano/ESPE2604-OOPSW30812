from .item import Item
from models.interfaces.i_equippable import IEquippable
from models.interfaces.i_repairable import IRepairable
from models.interfaces.i_sellable import ISellable
from .character import Character

class Weapon(Item, IEquippable, IRepairable, ISellable):
    def __init__(self, item_id: str, name: str, weight: float, description: str, base_value: float, base_damage: float, attack_speed: float):
        super().__init__(item_id, name, weight, description, base_value)
        self.base_damage = base_damage
        self.attack_speed = attack_speed
        self.durability = 100.0

    def equip(self, target: Character):
        target.bonus_damage += self.base_damage

    def unequip(self, target: Character):
        target.bonus_damage -= self.base_damage

    def repair(self, amount: float):
        self.durability += amount
        if self.durability > 100.0:
            self.durability = 100.0

    def get_durability(self) -> float:
        return self.durability

    def calculate_sale_value(self) -> float:
        return self.base_value * (self.durability / 100.0)

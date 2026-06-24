from abc import ABC, abstractmethod
from typing import List, Dict, Optional, TYPE_CHECKING
from models.enums.armor_slot import ArmorSlot
from models.enums.artifact_slot import ArtifactSlot

if TYPE_CHECKING:
    from .item import Item
    from .armor import Armor
    from .artifact import Artifact

class Character(ABC):
    def __init__(self, char_id: str, name: str, level: int, max_hp: float):
        self.id = char_id
        self.name = name
        self.level = level
        self.max_hp = max_hp
        self.hp = max_hp
        self.exp = 0
        self.bonus_damage = 0.0
        self.bonus_defense = 0.0
        self.inventory: List['Item'] = []
        self.equipped_armor: Dict[ArmorSlot, 'Armor'] = {}
        self.equipped_artifacts: Dict[ArtifactSlot, 'Artifact'] = {}

    def get_equipped_armor(self, slot: ArmorSlot) -> Optional['Armor']:
        return self.equipped_armor.get(slot)

    def set_equipped_armor(self, slot: ArmorSlot, armor: Optional['Armor']):
        if armor is None:
            self.equipped_armor.pop(slot, None)
        else:
            self.equipped_armor[slot] = armor

    def get_equipped_artifact(self, slot: ArtifactSlot) -> Optional['Artifact']:
        return self.equipped_artifacts.get(slot)

    def set_equipped_artifact(self, slot: ArtifactSlot, artifact: Optional['Artifact']):
        if artifact is None:
            self.equipped_artifacts.pop(slot, None)
        else:
            self.equipped_artifacts[slot] = artifact

    def take_damage(self, amount: float):
        real_damage = amount - self.bonus_defense
        if real_damage < 1:
            real_damage = 1
        
        self.hp -= real_damage
        if self.hp > self.max_hp:
            self.hp = self.max_hp
        if self.hp < 0:
            self.hp = 0

    def heal(self, amount: float):
        self.hp += amount
        if self.hp > self.max_hp:
            self.hp = self.max_hp

    def gain_exp(self, amount: int) -> bool:
        self.exp += amount
        if self.exp >= 100:
            self.level += 1
            self.exp -= 100
            self.max_hp += 20
            self.hp = self.max_hp
            return True
        return False

    def add_item(self, item: 'Item'):
        self.inventory.append(item)

    def remove_item(self, item: 'Item'):
        if item in self.inventory:
            self.inventory.remove(item)

    @abstractmethod
    def attack(self, target: 'Character'):
        pass

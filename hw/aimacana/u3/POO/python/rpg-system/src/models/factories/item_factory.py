import uuid
import random
from models.entities.item import Item
from models.entities.potion import Potion
from models.entities.weapon import Weapon
from models.entities.armor import Armor
from models.entities.artifact import Artifact
from models.enums.armor_slot import ArmorSlot
from models.enums.artifact_slot import ArtifactSlot

class ItemFactory:
    @staticmethod
    def create_random_loot(player_level: int) -> Item:
        roll = random.random()
        if roll < 0.35:
            restore = 20.0 + (player_level * 10)
            return Potion(str(uuid.uuid4()), f"Poción Nvl {player_level}", 0.5, f"Cura {restore} HP", 20.0 * player_level, restore)
        elif roll < 0.70:
            damage = 10.0 + (player_level * 5)
            return Weapon(str(uuid.uuid4()), f"Arma Nvl {player_level}", 5.0, f"Daño +{damage}", 50.0 * player_level, damage, 1.2)
        elif roll < 0.90:
            def_val = 5.0 + (player_level * 2)
            slot_roll = random.random()
            if slot_roll < 0.25:
                slot = ArmorSlot.HELMET
                name_prefix = "Casco"
            elif slot_roll < 0.5:
                slot = ArmorSlot.CHEST
                name_prefix = "Pechera"
            elif slot_roll < 0.75:
                slot = ArmorSlot.LEGS
                name_prefix = "Pantalones"
            else:
                slot = ArmorSlot.BOOTS
                name_prefix = "Botas"
                
            return Armor(str(uuid.uuid4()), f"{name_prefix} Nvl {player_level}", 10.0, f"Defensa +{def_val}", 100.0 * player_level, def_val, slot)
        else:
            bonus_hp = 50.0 + (player_level * 20)
            art_slot = ArtifactSlot.RING if random.random() > 0.5 else ArtifactSlot.AMULET
            name_prefix = "Anillo" if art_slot == ArtifactSlot.RING else "Amuleto"
            
            return Artifact(str(uuid.uuid4()), f"{name_prefix} Nvl {player_level}", 1.0, f"Max HP +{bonus_hp}", 200.0 * player_level, bonus_hp, art_slot)

    @staticmethod
    def create_from_doc(item_doc: dict) -> Item:
        item_type = item_doc.get("type")
        if item_type == "Potion":
            return Potion(
                item_doc.get("id"), item_doc.get("name"), item_doc.get("weight"),
                item_doc.get("description"), item_doc.get("baseValue"), item_doc.get("restorationAmount")
            )
        elif item_type == "Weapon":
            return Weapon(
                item_doc.get("id"), item_doc.get("name"), item_doc.get("weight"),
                item_doc.get("description"), item_doc.get("baseValue"), item_doc.get("baseDamage"),
                item_doc.get("attackSpeed")
            )
        elif item_type == "Armor":
            slot = ArmorSlot[item_doc.get("slot")]
            return Armor(
                item_doc.get("id"), item_doc.get("name"), item_doc.get("weight"),
                item_doc.get("description"), item_doc.get("baseValue"), item_doc.get("defense"), slot
            )
        elif item_type == "Artifact":
            slot = ArtifactSlot[item_doc.get("slot")]
            return Artifact(
                item_doc.get("id"), item_doc.get("name"), item_doc.get("weight"),
                item_doc.get("description"), item_doc.get("baseValue"), item_doc.get("bonusHealth"), slot
            )
        raise ValueError(f"Unknown item type: {item_type}")

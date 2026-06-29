from typing import Optional
from models.entities.character import Character
from models.entities.warrior import Warrior
from models.entities.mage import Mage
from models.factories.item_factory import ItemFactory
from models.enums.armor_slot import ArmorSlot
from models.enums.artifact_slot import ArtifactSlot

class CharacterFactory:
    @staticmethod
    def create_from_doc(doc: dict) -> Optional[Character]:
        char_type = doc.get("type")
        character = None

        # Calculate artifact health bonuses to prevent infinite max HP growth
        artifacts_bonus = 0.0
        equipped_artifacts = doc.get("equippedArtifacts", [])
        for art_doc in equipped_artifacts:
            artifacts_bonus += float(art_doc.get("bonusHealth", 0.0))

        base_max_hp = float(doc.get("maxHp", 100.0)) - artifacts_bonus

        if char_type == "Warrior":
            character = Warrior(
                doc.get("_id"),
                doc.get("name"),
                doc.get("level"),
                base_max_hp,
                doc.get("strength")
            )
            character.exp = doc.get("exp", 0)
        elif char_type == "Mage":
            character = Mage(
                doc.get("_id"),
                doc.get("name"),
                doc.get("level"),
                base_max_hp,
                doc.get("intelligence"),
                doc.get("mana")
            )
            character.mana = doc.get("mana")
            character.exp = doc.get("exp", 0)

        if character is not None:
            # Load inventory (without auto-equipping!)
            inventory_docs = doc.get("inventory", [])
            for item_doc in inventory_docs:
                try:
                    item = ItemFactory.create_from_doc(item_doc)
                    character.add_item(item)
                except Exception:
                    pass

            # Load equipped weapon
            weapon_doc = doc.get("equippedWeapon")
            if weapon_doc is not None:
                try:
                    w = ItemFactory.create_from_doc(weapon_doc)
                    character.bonus_damage += w.base_damage
                    character.set_equipped_weapon(w)
                except Exception:
                    pass

            # Load equipped armor
            equipped_armor = doc.get("equippedArmor", [])
            for armor_doc in equipped_armor:
                try:
                    a = ItemFactory.create_from_doc(armor_doc)
                    character.bonus_defense += a.defense
                    character.set_equipped_armor(a.slot, a)
                except Exception:
                    pass

            # Load equipped artifacts
            for art_doc in equipped_artifacts:
                try:
                    art = ItemFactory.create_from_doc(art_doc)
                    character.max_hp += art.bonus_health
                    character.set_equipped_artifact(art.slot, art)
                except Exception:
                    pass

            # Set current HP safely after equipment is fully loaded
            character.set_hp(doc.get("hp", character.max_hp))

        return character

    @staticmethod
    def create_character(char_type: str, char_id: str, name: str) -> Character:
        if char_type.lower() == "warrior":
            return Warrior(char_id, name, 1, 100.0, 15.0)
        elif char_type.lower() == "mage":
            return Mage(char_id, name, 1, 80.0, 20.0, 50.0)
        raise ValueError(f"Unknown character type: {char_type}")

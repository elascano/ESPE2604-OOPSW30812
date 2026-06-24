from typing import Optional
from models.entities.character import Character
from models.entities.warrior import Warrior
from models.entities.mage import Mage
from models.factories.item_factory import ItemFactory

class CharacterFactory:
    @staticmethod
    def create_from_doc(doc: dict) -> Optional[Character]:
        char_type = doc.get("type")
        character = None

        if char_type == "Warrior":
            character = Warrior(
                doc.get("_id"),
                doc.get("name"),
                doc.get("level"),
                doc.get("maxHp"),
                doc.get("strength")
            )
            character.exp = doc.get("exp", 0)
            character.hp = doc.get("hp", character.max_hp)
        elif char_type == "Mage":
            character = Mage(
                doc.get("_id"),
                doc.get("name"),
                doc.get("level"),
                doc.get("maxHp"),
                doc.get("intelligence"),
                doc.get("mana")
            )
            character.exp = doc.get("exp", 0)
            character.hp = doc.get("hp", character.max_hp)

        if character is not None:
            inventory_docs = doc.get("inventory", [])
            for item_doc in inventory_docs:
                try:
                    item = ItemFactory.create_from_doc(item_doc)
                    if hasattr(item, 'equip'):
                        item.equip(character)
                    character.add_item(item)
                except Exception:
                    pass

        return character

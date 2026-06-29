import os
from typing import List, Optional
from pymongo import MongoClient
from .character_repository import CharacterRepository
from models.entities.character import Character
from models.entities.warrior import Warrior
from models.entities.mage import Mage
from models.entities.potion import Potion
from models.entities.weapon import Weapon
from models.entities.armor import Armor
from models.entities.artifact import Artifact
from models.enums.armor_slot import ArmorSlot
from models.enums.artifact_slot import ArtifactSlot
from models.factories.character_factory import CharacterFactory

class MongoCharacterRepository(CharacterRepository):
    # Cargar de variable de entorno para seguridad, fallback a local
    CONNECTION_STRING = os.environ.get("MONGO_URI") or os.environ.get("DATABASE_URL") or "mongodb://localhost:27017/"
    DATABASE_NAME = "rpg_db"
    COLLECTION_NAME = "characters"

    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(MongoCharacterRepository, cls).__new__(cls)
            cls._instance.client = MongoClient(cls.CONNECTION_STRING)
            cls._instance.db = cls._instance.client[cls.DATABASE_NAME]
            cls._instance.collection = cls._instance.db[cls.COLLECTION_NAME]
        return cls._instance

    def _map_item_to_doc(self, item) -> dict:
        item_doc = {
            "id": item.id,
            "name": item.name,
            "weight": item.weight,
            "description": item.description,
            "baseValue": item.base_value
        }
        if isinstance(item, Potion):
            item_doc["type"] = "Potion"
            item_doc["restorationAmount"] = item.restoration_amount
        elif isinstance(item, Weapon):
            item_doc["type"] = "Weapon"
            item_doc["baseDamage"] = item.base_damage
            item_doc["attackSpeed"] = item.attack_speed
            item_doc["durability"] = item.durability
        elif isinstance(item, Armor):
            item_doc["type"] = "Armor"
            item_doc["defense"] = item.defense
            item_doc["slot"] = item.slot.name
        elif isinstance(item, Artifact):
            item_doc["type"] = "Artifact"
            item_doc["bonusHealth"] = item.bonus_health
            item_doc["slot"] = item.slot.name
        return item_doc

    def save(self, character: Character):
        doc = {
            "_id": character.id,
            "name": character.name,
            "level": character.level,
            "hp": character.hp,
            "maxHp": character.max_hp,
            "exp": character.exp,
            "inventory": []
        }

        if isinstance(character, Warrior):
            doc["type"] = "Warrior"
            doc["strength"] = character.strength
            doc["rage"] = character.rage
        elif isinstance(character, Mage):
            doc["type"] = "Mage"
            doc["intelligence"] = character.intelligence
            doc["mana"] = character.mana

        # Save inventory items
        for item in character.inventory:
            doc["inventory"].append(self._map_item_to_doc(item))

        # Save equipped weapon
        if character.get_equipped_weapon() is not None:
            doc["equippedWeapon"] = self._map_item_to_doc(character.get_equipped_weapon())

        # Save equipped armor
        doc["equippedArmor"] = []
        for slot in ArmorSlot:
            armor = character.get_equipped_armor(slot)
            if armor is not None:
                doc["equippedArmor"].append(self._map_item_to_doc(armor))

        # Save equipped artifacts
        doc["equippedArtifacts"] = []
        for slot in ArtifactSlot:
            artifact = character.get_equipped_artifact(slot)
            if artifact is not None:
                doc["equippedArtifacts"].append(self._map_item_to_doc(artifact))

        self.collection.replace_one({"_id": character.id}, doc, upsert=True)

    def find_by_id(self, char_id: str) -> Optional[Character]:
        doc = self.collection.find_one({"_id": char_id})
        if doc is None:
            return None
        return CharacterFactory.create_from_doc(doc)

    def find_all(self) -> List[Character]:
        return [CharacterFactory.create_from_doc(doc) for doc in self.collection.find() if doc is not None]

    def delete(self, char_id: str):
        self.collection.delete_one({"_id": char_id})

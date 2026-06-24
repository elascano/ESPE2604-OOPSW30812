from typing import List, Optional
from pymongo import MongoClient
from pymongo.collection import Collection
from pymongo.database import Database
from .character_repository import CharacterRepository
from models.entities.character import Character
from models.entities.warrior import Warrior
from models.entities.mage import Mage
from models.entities.potion import Potion
from models.entities.weapon import Weapon
from models.entities.armor import Armor
from models.entities.artifact import Artifact
from models.factories.character_factory import CharacterFactory

class MongoCharacterRepository(CharacterRepository):
    CONNECTION_STRING = "mongodb://admin:AZaxnebula18*@157.137.223.54:27017/"
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

        for item in character.inventory:
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
            
            doc["inventory"].append(item_doc)

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

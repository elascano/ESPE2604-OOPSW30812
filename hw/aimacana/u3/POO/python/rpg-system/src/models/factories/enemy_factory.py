import uuid
import random
from models.entities.character import Character
from models.entities.warrior import Warrior
from models.entities.mage import Mage

class EnemyFactory:
    @staticmethod
    def spawn_enemy_for_level(level: int) -> Character:
        char_id = f"enemy_{uuid.uuid4()}"
        hp = 100.0 + (level * 50)
        damage = 5.0 + (level * 2)
        
        roll = random.random()
        if roll < 0.33:
            return Warrior(char_id, "Troll de las Montañas", level, hp, damage)
        elif roll < 0.66:
            return Warrior(char_id, "Orco Furioso", level, hp * 1.2, damage * 1.5)
        else:
            return Mage(char_id, "Brujo Oscuro", level, hp * 0.8, damage * 2.0, 100.0)

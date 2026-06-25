from .character import Character
from models.exceptions.character_dead_exception import CharacterDeadException

class Warrior(Character):
    def __init__(self, char_id: str, name: str, level: int, max_hp: float, strength: float):
        super().__init__(char_id, name, level, max_hp)
        self.strength = strength
        self.rage = 0.0

    def attack(self, target: Character):
        if self.hp <= 0:
            raise CharacterDeadException("El guerrero está muerto y no puede atacar.")
        damage = (self.strength * 1.5) + self.bonus_damage
        target.take_damage(damage)
        self.rage += 10
        if self.rage > 100:
            self.rage = 100

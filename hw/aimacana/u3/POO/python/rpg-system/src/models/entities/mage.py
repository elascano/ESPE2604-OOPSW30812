from .character import Character
from models.exceptions.character_dead_exception import CharacterDeadException

class Mage(Character):
    def __init__(self, char_id: str, name: str, level: int, max_hp: float, intelligence: float, max_mana: float):
        super().__init__(char_id, name, level, max_hp)
        self.intelligence = intelligence
        self.mana = max_mana

    def attack(self, target: Character):
        if self.hp <= 0:
            raise CharacterDeadException("El mago está muerto y no puede atacar.")
        if self.mana >= 10:
            damage = (self.intelligence * 2.0) + self.bonus_damage
            self.mana -= 10
        else:
            damage = (self.intelligence * 0.5) + self.bonus_damage
            self.mana += 15
            if self.mana > 100:
                self.mana = 100
        target.take_damage(damage)

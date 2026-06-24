from typing import List, Optional
from models.entities.character import Character
from models.entities.item import Item
from models.interfaces.i_consumable import IConsumable
from models.interfaces.i_equippable import IEquippable
from models.enums.armor_slot import ArmorSlot
from models.enums.artifact_slot import ArtifactSlot
from models.exceptions.character_dead_exception import CharacterDeadException
from repository.character_repository import CharacterRepository

class GameController:
    def __init__(self, repository: CharacterRepository):
        self.repository = repository
        self.current_character: Optional[Character] = None

    def create_new_character(self, character: Character) -> str:
        self.current_character = character
        return f"Nuevo personaje creado en memoria: {character.name}"

    def load_character(self, character_id: str) -> str:
        loaded = self.repository.find_by_id(character_id)
        if loaded is None:
            return "Error: Personaje no encontrado en la base de datos."
        self.current_character = loaded
        return f"Partida cargada exitosamente desde MongoDB: {self.current_character.name}"

    def save_game(self) -> str:
        if self.current_character is None:
            return "No hay ningún personaje activo para guardar."
        if self.current_character.hp <= 0:
            return "No puedes guardar una partida de un personaje muerto."
        
        self.repository.save(self.current_character)
        return "Partida guardada correctamente en MongoDB."

    def get_all_saved_characters(self) -> List[Character]:
        return self.repository.find_all()

    def interact_with_item(self, item: Item) -> str:
        if self.current_character is None:
            return "No hay personaje seleccionado."
        if self.current_character.hp <= 0:
            return "Estás muerto. No puedes usar objetos."

        if isinstance(item, IEquippable):
            item.equip(self.current_character)
            return f"{self.current_character.name} ha equipado: {item.name}. Estadísticas actualizadas."

        if isinstance(item, IConsumable):
            item.consume(self.current_character)
            self.current_character.remove_item(item)
            return f"{self.current_character.name} ha consumido: {item.name}"

        return "Este ítem no se puede usar."

    def interact_with_item_by_id(self, item_id: str) -> str:
        c = self.get_current_character()
        if c is None:
            return "No hay personaje activo."
        for item in c.inventory:
            if item.id == item_id:
                return self.interact_with_item(item)
        return "El ítem no está en el inventario."

    def unequip_armor(self, slot: ArmorSlot) -> str:
        c = self.get_current_character()
        if c is None:
            return "No hay personaje activo."
        armor = c.get_equipped_armor(slot)
        if armor is not None:
            armor.unequip(c)
            return f"{c.name} se ha quitado: {armor.name}"
        return "No hay nada equipado en esa ranura."

    def unequip_artifact(self, slot: ArtifactSlot) -> str:
        c = self.get_current_character()
        if c is None:
            return "No hay personaje activo."
        art = c.get_equipped_artifact(slot)
        if art is not None:
            art.unequip(c)
            return f"{c.name} se ha quitado: {art.name}"
        return "No hay nada equipado en esa ranura."

    def attack_target(self, target: Character) -> str:
        if self.current_character is None:
            return "No hay personaje seleccionado para atacar."
        if self.current_character.hp <= 0:
            return "¡Estás muerto! Carga otra partida."

        old_enemy_hp = target.hp
        result = ""
        try:
            self.current_character.attack(target)
            damage_dealt = old_enemy_hp - target.hp
            result = f"{self.current_character.name} atacó por {damage_dealt:.1f} de daño.\n"

            if target.hp > 0:
                old_player_hp = self.current_character.hp
                target.attack(self.current_character)
                damage_taken = old_player_hp - self.current_character.hp
                result += f"El enemigo contraatacó causando {damage_taken:.1f} de daño.\n"

                if self.current_character.hp <= 0:
                    result += "¡GAME OVER! Has sido derrotado en combate."
            else:
                result += "¡Enemigo derrotado!\n"
                if self.current_character.gain_exp(50):
                    result += f"⭐ ¡SUBISTE DE NIVEL! Ahora eres Nivel {self.current_character.level}. (Vida Restaurada)"
                else:
                    result += f"✨ Has ganado 50 Puntos de Experiencia ({self.current_character.exp}/100)."
        except CharacterDeadException as e:
            return f"❌ {str(e)}"

        return result

    def get_current_character(self) -> Optional[Character]:
        return self.current_character

package ec.edu.espe.rpg.controller;

import ec.edu.espe.rpg.model.entities.Character;
import ec.edu.espe.rpg.model.entities.Item;
import ec.edu.espe.rpg.model.entities.Weapon;
import ec.edu.espe.rpg.model.interfaces.IConsumable;
import ec.edu.espe.rpg.model.interfaces.IEquippable;
import ec.edu.espe.rpg.repository.CharacterRepository;

import java.util.List;

public class GameController {
    
    private final CharacterRepository repository;
    private Character currentCharacter;

    public GameController(CharacterRepository repository) {
        this.repository = repository;
    }

    public String createNewCharacter(Character character) {
        this.currentCharacter = character;
        return "Nuevo personaje creado en memoria: " + character.getName();
    }

    public String loadCharacter(String characterId) {
        Character loaded = repository.findById(characterId);
        
        if (loaded == null) {
            return "Error: Personaje no encontrado en la base de datos.";
        }
        
        this.currentCharacter = loaded;
        return "Partida cargada exitosamente desde MongoDB: " + currentCharacter.getName();
    }

    public String saveGame() {
        if (currentCharacter == null) {
            return "No hay ningún personaje activo para guardar.";
        }
        if (currentCharacter.getHp() <= 0) {
            return "No puedes guardar una partida de un personaje muerto.";
        }
        
        repository.save(currentCharacter);
        return "Partida guardada correctamente en MongoDB.";
    }

    public List<Character> getAllSavedCharacters() {
        return repository.findAll();
    }

    public String interactWithItem(Item item) {
        if (currentCharacter == null) {
            return "No hay personaje seleccionado.";
        }
        if (currentCharacter.getHp() <= 0) {
            return "Estás muerto. No puedes usar objetos.";
        }

        if (item instanceof IEquippable) {
            ((IEquippable) item).equip(currentCharacter);
            return currentCharacter.getName() + " ha equipado: " + item.getName() + ". Estadísticas actualizadas.";
        } 
        
        if (item instanceof IConsumable) {
            ((IConsumable) item).consume(currentCharacter);
            currentCharacter.removeItem(item);
            return currentCharacter.getName() + " ha consumido: " + item.getName();
        } 
        
        return "Este ítem no se puede usar.";
    }

    public String interactWithItemById(String itemId) {
        ec.edu.espe.rpg.model.entities.Character c = getCurrentCharacter();
        if (c == null) return "No hay personaje activo.";
        for (ec.edu.espe.rpg.model.entities.Item item : c.getInventory()) {
            if (item.getId().equals(itemId)) {
                return interactWithItem(item);
            }
        }
        return "El ítem no está en el inventario.";
    }

    public String unequipArmor(ec.edu.espe.rpg.model.enums.ArmorSlot slot) {
        ec.edu.espe.rpg.model.entities.Character c = getCurrentCharacter();
        if (c == null) return "No hay personaje activo.";
        ec.edu.espe.rpg.model.entities.Armor armor = c.getEquippedArmor(slot);
        if (armor != null) {
            armor.unequip(c);
            return c.getName() + " se ha quitado: " + armor.getName();
        }
        return "No hay nada equipado en esa ranura.";
    }

    public String unequipArtifact(ec.edu.espe.rpg.model.enums.ArtifactSlot slot) {
        ec.edu.espe.rpg.model.entities.Character c = getCurrentCharacter();
        if (c == null) return "No hay personaje activo.";
        ec.edu.espe.rpg.model.entities.Artifact art = c.getEquippedArtifact(slot);
        if (art != null) {
            art.unequip(c);
            return c.getName() + " se ha quitado: " + art.getName();
        }
        return "No hay nada equipado en esa ranura.";
    }

    public String attackTarget(Character target) {
        if (currentCharacter == null) {
            return "No hay personaje seleccionado para atacar.";
        }
        if (currentCharacter.getHp() <= 0) {
            return "¡Estás muerto! Carga otra partida.";
        }
        
        double oldEnemyHp = target.getHp();
        String result = "";
        try {
            currentCharacter.attack(target);
            double damageDealt = oldEnemyHp - target.getHp();
            result = currentCharacter.getName() + " atacó por " + String.format("%.1f", damageDealt) + " de daño.\n";
            
            // Counter Attack
            if (target.getHp() > 0) {
                double oldPlayerHp = currentCharacter.getHp();
                target.attack(currentCharacter);
                double damageTaken = oldPlayerHp - currentCharacter.getHp();
                result += "El enemigo contraatacó causando " + String.format("%.1f", damageTaken) + " de daño.\n";
                
                if (currentCharacter.getHp() <= 0) {
                    result += "¡GAME OVER! Has sido derrotado en combate.";
                }
            } else {
                result += "¡Enemigo derrotado!\n";
                if (currentCharacter.gainExp(50)) {
                    result += "⭐ ¡SUBISTE DE NIVEL! Ahora eres Nivel " + currentCharacter.getLevel() + ". (Vida Restaurada)";
                } else {
                    result += "✨ Has ganado 50 Puntos de Experiencia (" + currentCharacter.getExp() + "/100).";
                }
            }
        } catch (ec.edu.espe.rpg.model.exceptions.CharacterDeadException e) {
            return "❌ " + e.getMessage();
        }
        
        return result;
    }

    public String createCharacter(String name, String classType) {
        String id = java.util.UUID.randomUUID().toString();
        try {
            ec.edu.espe.rpg.model.entities.Character character = ec.edu.espe.rpg.model.factories.CharacterFactory.createCharacter(classType, id, name);
            this.currentCharacter = character;
            return "Nuevo personaje (" + classType + ") creado en memoria: " + name;
        } catch (IllegalArgumentException e) {
            return "Error al crear personaje: " + e.getMessage();
        }
    }

    public String restCharacter() {
        if (currentCharacter == null) {
            return "Error: No hay personaje activo para descansar.";
        }
        currentCharacter.heal(currentCharacter.getMaxHp());
        return currentCharacter.getName() + " ha descansado. HP restaurado al máximo.";
    }

    public String lootRandomItem() {
        if (currentCharacter == null) {
            return "Error: No hay personaje activo para buscar botín.";
        }
        try {
            ec.edu.espe.rpg.model.entities.Item item = ec.edu.espe.rpg.model.factories.ItemFactory.createRandomLoot(currentCharacter.getLevel());
            currentCharacter.addItem(item);
            return "Has encontrado un ítem: " + item.getName();
        } catch (ec.edu.espe.rpg.model.exceptions.InventoryFullException e) {
            return "Error: " + e.getMessage();
        }
    }

    public String unequipWeapon() {
        if (currentCharacter == null) return "No hay personaje activo.";
        Weapon weapon = currentCharacter.getEquippedWeapon();
        if (weapon != null) {
            weapon.unequip(currentCharacter);
            return currentCharacter.getName() + " se ha quitado: " + weapon.getName();
        }
        return "No hay arma equipada.";
    }
    
    public Character getCurrentCharacter() {
        return currentCharacter;
    }
}

'use server';

import { MongoCharacterRepository } from './repositories/MongoCharacterRepository';
import { GameService } from './services/GameService';
import { Warrior } from './models/Warrior';
import { Mage } from './models/Mage';
import { Weapon } from './models/Weapon';
import { Potion } from './models/Potion';
import { Armor } from './models/Armor';
import { Artifact } from './models/Artifact';
import { ArmorSlot, ArtifactSlot } from './models/enums';
import { Character } from './models/Character';
import { EnemyFactory } from './models/EnemyFactory';

// Singleton de servicio para emular el estado local de la app Java
const repository = MongoCharacterRepository.getInstance();
const gameService = new GameService(repository);

// DTO para enviar al cliente
export type CharacterDTO = {
  id: string;
  name: string;
  level: number;
  hp: number;
  maxHp: number;
  exp: number;
  bonusDamage: number;
  bonusDefense: number;
  type: string;
  primaryStatStr: string;
  secondaryStatStr: string;
  inventory: any[];
  equipped: Record<string, string | null>;
};

function toDTO(c: Character | null): CharacterDTO | null {
  if (!c) return null;
  let type = 'Desconocido';
  let pStat = '-';
  let sStat = '-';
  if (c instanceof Warrior) {
    type = 'Guerrero';
    pStat = `Fuerza: ${c.getStrength()}`;
    sStat = `Ira: ${c.getRage()}`;
  } else if (c instanceof Mage) {
    type = 'Mago';
    pStat = `Inteligencia: ${c.getIntelligence()}`;
    sStat = `Maná: ${c.getMana()}`;
  }

  return {
    id: c.getId(),
    name: c.getName(),
    level: c.getLevel(),
    hp: c.getHp(),
    maxHp: c.getMaxHp(),
    exp: c.getExp(),
    bonusDamage: c.getBonusDamage(),
    bonusDefense: c.getBonusDefense(),
    type,
    primaryStatStr: pStat,
    secondaryStatStr: sStat,
    inventory: c.getInventory().map(i => ({ 
      id: i.getId(), 
      name: i.getName(), 
      desc: i.getDescription(), 
      classType: i.constructor.name,
      slot: (i as any).getSlot ? (i as any).getSlot() : null
    })),
    equipped: {
      weapon: c.getEquippedWeapon()?.getName() || null,
      helmet: c.getEquippedArmor(ArmorSlot.HELMET)?.getName() || null,
      chest: c.getEquippedArmor(ArmorSlot.CHEST)?.getName() || null,
      legs: c.getEquippedArmor(ArmorSlot.LEGS)?.getName() || null,
      boots: c.getEquippedArmor(ArmorSlot.BOOTS)?.getName() || null,
      ring: c.getEquippedArtifact(ArtifactSlot.RING)?.getName() || null,
      amulet: c.getEquippedArtifact(ArtifactSlot.AMULET)?.getName() || null,
    }
  };
}

export async function createCharacterAction(name: string, classType: string) {
  const msg = gameService.createCharacter(name, classType);
  await gameService.saveGame();
  return { msg, character: toDTO(gameService.getCurrentCharacter()) };
}

export async function createDemoCharacter() {
  const msg = gameService.createCharacter('Conan', 'Warrior');
  const char = gameService.getCurrentCharacter();
  if (char) {
    char.addItem(new Weapon('wp-1', 'Espada Larga', 5, 'Espada básica', 10, 15, 1.0));
    char.addItem(new Potion('pt-1', 'Poción Menor', 1, 'Cura 50 HP', 5, 50));
    char.addItem(new Armor('ar-1', 'Cota de Malla', 10, 'Defensa media', 20, 15, ArmorSlot.CHEST));
  }
  await gameService.saveGame();
  return { msg, character: toDTO(gameService.getCurrentCharacter()) };
}

export async function restCharacterAction() {
  const msg = gameService.restCharacter();
  return { msg, character: toDTO(gameService.getCurrentCharacter()) };
}

export async function lootRandomItemAction() {
  const msg = gameService.lootRandomItem();
  return { msg, character: toDTO(gameService.getCurrentCharacter()) };
}

export async function unequipItemAction(slotName: string) {
  let msg = '';
  const slotLower = slotName.toLowerCase();
  if (slotLower === 'weapon') {
    msg = gameService.unequipWeapon();
  } else if (slotLower === 'helmet') {
    msg = gameService.unequipArmor(ArmorSlot.HELMET);
  } else if (slotLower === 'chest') {
    msg = gameService.unequipArmor(ArmorSlot.CHEST);
  } else if (slotLower === 'legs') {
    msg = gameService.unequipArmor(ArmorSlot.LEGS);
  } else if (slotLower === 'boots') {
    msg = gameService.unequipArmor(ArmorSlot.BOOTS);
  } else if (slotLower === 'ring') {
    msg = gameService.unequipArtifact(ArtifactSlot.RING);
  } else if (slotLower === 'amulet') {
    msg = gameService.unequipArtifact(ArtifactSlot.AMULET);
  }
  return { msg, character: toDTO(gameService.getCurrentCharacter()) };
}

export async function loadCharacter(id: string) {
  const msg = await gameService.loadCharacter(id);
  return { msg, character: toDTO(gameService.getCurrentCharacter()) };
}

export async function saveGameAction() {
  await gameService.saveGame();
  return { msg: 'Partida guardada exitosamente en MongoDB.' };
}

export async function getAllCharactersAction() {
  const chars = await repository.findAll();
  return chars.map(c => ({ id: c.getId(), name: c.getName(), type: c instanceof Warrior ? 'Guerrero' : 'Mago', level: c.getLevel() }));
}

export async function interactItem(itemId: string) {
  const msg = gameService.interactWithItemById(itemId);
  return { msg, character: toDTO(gameService.getCurrentCharacter()) };
}

export async function attackDummy() {
  const char = gameService.getCurrentCharacter();
  const level = char ? char.getLevel() : 1;
  const enemy = EnemyFactory.spawnEnemyForLevel(level);
  
  const msg = gameService.attackTarget(enemy);
  return { msg, character: toDTO(gameService.getCurrentCharacter()) };
}

export async function getActiveCharacter() {
  return toDTO(gameService.getCurrentCharacter());
}

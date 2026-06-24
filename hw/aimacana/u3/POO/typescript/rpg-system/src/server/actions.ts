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
      helmet: c.getEquippedArmor(ArmorSlot.HELMET)?.getName() || null,
      chest: c.getEquippedArmor(ArmorSlot.CHEST)?.getName() || null,
      legs: c.getEquippedArmor(ArmorSlot.LEGS)?.getName() || null,
      boots: c.getEquippedArmor(ArmorSlot.BOOTS)?.getName() || null,
      ring: c.getEquippedArtifact(ArtifactSlot.RING)?.getName() || null,
      amulet: c.getEquippedArtifact(ArtifactSlot.AMULET)?.getName() || null,
    }
  };
}

export async function createDemoCharacter() {
  const warrior = new Warrior('char-1', 'Conan', 1, 150, 20);
  warrior.addItem(new Weapon('wp-1', 'Espada Larga', 5, 'Espada básica', 10, 15, 1.0));
  warrior.addItem(new Potion('pt-1', 'Poción Menor', 1, 'Cura 50 HP', 5, 50));
  warrior.addItem(new Armor('ar-1', 'Cota de Malla', 10, 'Defensa media', 20, 15, ArmorSlot.CHEST));
  
  const msg = gameService.createNewCharacter(warrior);
  await gameService.saveGame();
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
  // Dummy enemy for testing
  const enemy = new Warrior('enemy-1', 'Orco', 1, 80, 10);
  const msg = gameService.attackTarget(enemy);
  return { msg, character: toDTO(gameService.getCurrentCharacter()) };
}

export async function getActiveCharacter() {
  return toDTO(gameService.getCurrentCharacter());
}

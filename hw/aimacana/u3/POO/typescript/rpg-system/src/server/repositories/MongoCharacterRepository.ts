import { MongoClient, Db, Collection } from 'mongodb';
import { CharacterRepository } from './CharacterRepository';
import { Character } from '../models/Character';
import { Warrior } from '../models/Warrior';
import { Mage } from '../models/Mage';
import { Item } from '../models/Item';
import { Potion } from '../models/Potion';
import { Weapon } from '../models/Weapon';
import { Armor } from '../models/Armor';
import { Artifact } from '../models/Artifact';
import { ArmorSlot, ArtifactSlot } from '../models/enums';

const CONNECTION_STRING = process.env.DATABASE_URL || process.env.MONGO_URI || 'mongodb://localhost:27017/';
const DATABASE_NAME = 'rpg_db';
const COLLECTION_NAME = 'characters';

export class MongoCharacterRepository implements CharacterRepository {
  private static instance: MongoCharacterRepository;
  private client: MongoClient;
  private db: Db;
  private collection: Collection<any>;

  private constructor() {
    this.client = new MongoClient(CONNECTION_STRING);
    this.db = this.client.db(DATABASE_NAME);
    this.collection = this.db.collection(COLLECTION_NAME);
  }

  public static getInstance(): MongoCharacterRepository {
    if (process.env.NODE_ENV === 'production') {
      if (!MongoCharacterRepository.instance) {
        MongoCharacterRepository.instance = new MongoCharacterRepository();
      }
      return MongoCharacterRepository.instance;
    } else {
      const g = global as any;
      if (!g._mongoRepoInstance) {
        g._mongoRepoInstance = new MongoCharacterRepository();
      }
      return g._mongoRepoInstance;
    }
  }

  private mapItemToDoc(item: Item): any {
    const itemDoc: any = {
      id: item.getId(),
      name: item.getName(),
      weight: item.getWeight(),
      description: item.getDescription(),
      baseValue: item.getBaseValue(),
    };

    if (item instanceof Potion) {
      itemDoc.type = 'Potion';
      itemDoc.restorationAmount = item.getRestorationAmount();
    } else if (item instanceof Weapon) {
      itemDoc.type = 'Weapon';
      itemDoc.baseDamage = item.getBaseDamage();
      itemDoc.attackSpeed = item.getAttackSpeed();
      itemDoc.durability = item.getDurability();
    } else if (item instanceof Armor) {
      itemDoc.type = 'Armor';
      itemDoc.defense = item.getDefense();
      itemDoc.slot = item.getSlot();
    } else if (item instanceof Artifact) {
      itemDoc.type = 'Artifact';
      itemDoc.bonusHealth = item.getBonusHealth();
      itemDoc.slot = item.getSlot();
    }

    return itemDoc;
  }

  private mapDocToItem(itemDoc: any): Item | null {
    if (!itemDoc) return null;
    const itemType = itemDoc.type;
    if (itemType === 'Potion') {
      return new Potion(itemDoc.id, itemDoc.name, itemDoc.weight, itemDoc.description, itemDoc.baseValue, itemDoc.restorationAmount);
    } else if (itemType === 'Weapon') {
      return new Weapon(itemDoc.id, itemDoc.name, itemDoc.weight, itemDoc.description, itemDoc.baseValue, itemDoc.baseDamage, itemDoc.attackSpeed);
    } else if (itemType === 'Armor') {
      const slot = ArmorSlot[itemDoc.slot as keyof typeof ArmorSlot];
      return new Armor(itemDoc.id, itemDoc.name, itemDoc.weight, itemDoc.description, itemDoc.baseValue, itemDoc.defense, slot);
    } else if (itemType === 'Artifact') {
      const slot = ArtifactSlot[itemDoc.slot as keyof typeof ArtifactSlot];
      return new Artifact(itemDoc.id, itemDoc.name, itemDoc.weight, itemDoc.description, itemDoc.baseValue, itemDoc.bonusHealth, slot);
    }
    return null;
  }

  public async save(character: Character): Promise<void> {
    const doc: any = {
      _id: character.getId(),
      name: character.getName(),
      level: character.getLevel(),
      hp: character.getHp(),
      maxHp: character.getMaxHp(),
      exp: character.getExp(),
    };

    if (character instanceof Warrior) {
      doc.type = 'Warrior';
      doc.strength = character.getStrength();
      doc.rage = character.getRage();
    } else if (character instanceof Mage) {
      doc.type = 'Mage';
      doc.intelligence = character.getIntelligence();
      doc.mana = character.getMana();
    }

    // Save inventory
    doc.inventory = character.getInventory().map(item => this.mapItemToDoc(item));

    // Save equipped items
    if (character.getEquippedWeapon()) {
      doc.equippedWeapon = this.mapItemToDoc(character.getEquippedWeapon()!);
    }

    const equippedArmorDocs: any[] = [];
    for (const slot of Object.values(ArmorSlot)) {
      const armor = character.getEquippedArmor(slot);
      if (armor) {
        equippedArmorDocs.push(this.mapItemToDoc(armor));
      }
    }
    doc.equippedArmor = equippedArmorDocs;

    const equippedArtifactDocs: any[] = [];
    for (const slot of Object.values(ArtifactSlot)) {
      const artifact = character.getEquippedArtifact(slot);
      if (artifact) {
        equippedArtifactDocs.push(this.mapItemToDoc(artifact));
      }
    }
    doc.equippedArtifacts = equippedArtifactDocs;

    await this.collection.replaceOne({ _id: character.getId() }, doc, { upsert: true });
  }

  public async findById(id: string): Promise<Character | null> {
    const doc = await this.collection.findOne({ _id: id });
    if (!doc) return null;
    return this.mapDocumentToCharacter(doc);
  }

  public async findAll(): Promise<Character[]> {
    const cursor = this.collection.find({});
    const docs = await cursor.toArray();
    const characters: Character[] = [];
    for (const doc of docs) {
      const c = this.mapDocumentToCharacter(doc);
      if (c) characters.push(c);
    }
    return characters;
  }

  public async delete(id: string): Promise<void> {
    await this.collection.deleteOne({ _id: id });
  }

  private calculateArtifactsHealthBonus(doc: any): number {
    let total = 0;
    if (doc.equippedArtifacts && Array.isArray(doc.equippedArtifacts)) {
      for (const artDoc of doc.equippedArtifacts) {
        total += Number(artDoc.bonusHealth || 0);
      }
    }
    return total;
  }

  private mapDocumentToCharacter(doc: any): Character | null {
    const type = doc.type;
    let character: Character | null = null;

    const baseMaxHp = Number(doc.maxHp) - this.calculateArtifactsHealthBonus(doc);

    if (type === 'Warrior') {
      const warrior = new Warrior(
        doc._id,
        doc.name,
        doc.level,
        baseMaxHp,
        doc.strength
      );
      warrior.setExp(doc.exp || 0);
      character = warrior;
    } else if (type === 'Mage') {
      const mage = new Mage(
        doc._id,
        doc.name,
        doc.level,
        baseMaxHp,
        doc.intelligence,
        doc.mana
      );
      mage.setMana(doc.mana);
      mage.setExp(doc.exp || 0);
      character = mage;
    }

    if (character) {
      // Load inventory (without auto-equipping!)
      if (doc.inventory && Array.isArray(doc.inventory)) {
        for (const itemDoc of doc.inventory) {
          const item = this.mapDocToItem(itemDoc);
          if (item) {
            try {
              character.addItem(item);
            } catch (e) {}
          }
        }
      }

      // Load equipped weapon
      if (doc.equippedWeapon) {
        const w = this.mapDocToItem(doc.equippedWeapon) as Weapon;
        if (w) {
          character.setBonusDamage(character.getBonusDamage() + w.getBaseDamage());
          character.setEquippedWeapon(w);
        }
      }

      // Load equipped armor
      if (doc.equippedArmor && Array.isArray(doc.equippedArmor)) {
        for (const armorDoc of doc.equippedArmor) {
          const a = this.mapDocToItem(armorDoc) as Armor;
          if (a) {
            character.setBonusDefense(character.getBonusDefense() + a.getDefense());
            character.setEquippedArmor(a.getSlot(), a);
          }
        }
      }

      // Load equipped artifacts
      if (doc.equippedArtifacts && Array.isArray(doc.equippedArtifacts)) {
        for (const artDoc of doc.equippedArtifacts) {
          const art = this.mapDocToItem(artDoc) as Artifact;
          if (art) {
            character.setMaxHp(character.getMaxHp() + art.getBonusHealth());
            character.setEquippedArtifact(art.getSlot(), art);
          }
        }
      }

      // Apply saved health directly, safe inside [0, maxHp] range
      character.setHp(doc.hp);
    }

    return character;
  }
}

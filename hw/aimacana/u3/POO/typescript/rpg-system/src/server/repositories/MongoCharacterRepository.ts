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

// Usar variable de entorno para producción, fallback para local
const CONNECTION_STRING = process.env.DATABASE_URL || 'mongodb://admin:AZaxnebula18*@157.137.223.54:27017/';
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
    if (!MongoCharacterRepository.instance) {
      MongoCharacterRepository.instance = new MongoCharacterRepository();
    }
    return MongoCharacterRepository.instance;
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

    const inventoryDocs = character.getInventory().map((item: Item) => {
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
    });

    doc.inventory = inventoryDocs;

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

  private mapDocumentToCharacter(doc: any): Character | null {
    const type = doc.type;
    let character: Character | null = null;

    if (type === 'Warrior') {
      const warrior = new Warrior(
        doc._id,
        doc.name,
        doc.level,
        doc.maxHp,
        doc.strength
      );
      warrior.setExp(doc.exp || 0);
      this.applyDamage(warrior, doc.maxHp, doc.hp);
      character = warrior;
    } else if (type === 'Mage') {
      const mage = new Mage(
        doc._id,
        doc.name,
        doc.level,
        doc.maxHp,
        doc.intelligence,
        doc.mana
      );
      mage.setMana(doc.mana);
      mage.setExp(doc.exp || 0);
      this.applyDamage(mage, doc.maxHp, doc.hp);
      character = mage;
    }

    if (character && doc.inventory && Array.isArray(doc.inventory)) {
      for (const itemDoc of doc.inventory) {
        try {
          const itemType = itemDoc.type;
          if (itemType === 'Potion') {
            const p = new Potion(itemDoc.id, itemDoc.name, itemDoc.weight, itemDoc.description, itemDoc.baseValue, itemDoc.restorationAmount);
            character.addItem(p);
          } else if (itemType === 'Weapon') {
            const w = new Weapon(itemDoc.id, itemDoc.name, itemDoc.weight, itemDoc.description, itemDoc.baseValue, itemDoc.baseDamage, itemDoc.attackSpeed);
            w.equip(character); // Equiparlo para que de el bono de daño
            character.addItem(w);
          } else if (itemType === 'Armor') {
            const slot = ArmorSlot[itemDoc.slot as keyof typeof ArmorSlot];
            const a = new Armor(itemDoc.id, itemDoc.name, itemDoc.weight, itemDoc.description, itemDoc.baseValue, itemDoc.defense, slot);
            a.equip(character);
            character.addItem(a);
          } else if (itemType === 'Artifact') {
            const slot = ArtifactSlot[itemDoc.slot as keyof typeof ArtifactSlot];
            const art = new Artifact(itemDoc.id, itemDoc.name, itemDoc.weight, itemDoc.description, itemDoc.baseValue, itemDoc.bonusHealth, slot);
            art.equip(character);
            character.addItem(art);
          }
        } catch (e) {
          // Ignorar item corrupto
        }
      }
    }

    return character;
  }

  private applyDamage(character: Character, maxHp: number, currentHp: number): void {
    const damageTaken = maxHp - currentHp;
    if (damageTaken > 0) {
      // Necesitamos puentear temporalmente la defensa porque ya tomó el daño real antes de guardar
      const currentDefense = character.getBonusDefense();
      character.setBonusDefense(0);
      character.takeDamage(damageTaken);
      character.setBonusDefense(currentDefense);
    }
  }
}

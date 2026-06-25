package ec.edu.espe.rpg.repository;

import ec.edu.espe.rpg.model.entities.Character;
import ec.edu.espe.rpg.model.entities.Warrior;
import ec.edu.espe.rpg.model.entities.Mage;
import ec.edu.espe.rpg.model.entities.Item;
import ec.edu.espe.rpg.model.entities.Potion;
import ec.edu.espe.rpg.model.entities.Weapon;
import ec.edu.espe.rpg.model.entities.Armor;
import ec.edu.espe.rpg.model.entities.Artifact;
import ec.edu.espe.rpg.model.enums.ArmorSlot;
import ec.edu.espe.rpg.model.enums.ArtifactSlot;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio de persistencia en MongoDB para personajes del juego.
 * Implementa el patrón Singleton y utiliza mapeadores limpios de datos.
 */
public class MongoCharacterRepository implements CharacterRepository {

    private static final String DEFAULT_CONNECTION_STRING = "mongodb://localhost:27017/";
    private static final String DATABASE_NAME = "rpg_db";
    private static final String COLLECTION_NAME = "characters";

    private static final String FIELD_ID = "_id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_LEVEL = "level";
    private static final String FIELD_HP = "hp";
    private static final String FIELD_MAX_HP = "maxHp";
    private static final String FIELD_EXP = "exp";
    private static final String FIELD_TYPE = "type";
    private static final String FIELD_STRENGTH = "strength";
    private static final String FIELD_RAGE = "rage";
    private static final String FIELD_INTELLIGENCE = "intelligence";
    private static final String FIELD_MANA = "mana";
    private static final String FIELD_INVENTORY = "inventory";

    private static final String TYPE_WARRIOR = "Warrior";
    private static final String TYPE_MAGE = "Mage";

    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    private static MongoCharacterRepository instance;

    private MongoCharacterRepository() {
        this.mongoClient = MongoClients.create(getConnectionString());
        this.database = mongoClient.getDatabase(DATABASE_NAME);
        this.collection = database.getCollection(COLLECTION_NAME);
    }

    private static String getConnectionString() {
        String sysProp = System.getProperty("mongo.uri");
        if (sysProp != null && !sysProp.trim().isEmpty()) {
            return sysProp;
        }
        String envUri = System.getenv("MONGO_URI");
        if (envUri != null && !envUri.trim().isEmpty()) {
            return envUri;
        }
        return DEFAULT_CONNECTION_STRING;
    }

    public static synchronized MongoCharacterRepository getInstance() {
        if (instance == null) {
            instance = new MongoCharacterRepository();
        }
        return instance;
    }

    /**
     * Obtiene un valor Double de forma segura, previniendo excepciones de casteo
     * si el número se almacenó como Entero (Integer) en BSON.
     */
    private static double getDoubleSafe(Document doc, String key) {
        if (doc == null || key == null) return 0.0;
        Object val = doc.get(key);
        if (val instanceof Number) {
            return ((Number) val).doubleValue();
        }
        return 0.0;
    }

    private Document mapItemToDocument(Item item) {
        Document itemDoc = new Document("id", item.getId())
                .append("name", item.getName())
                .append("weight", item.getWeight())
                .append("description", item.getDescription())
                .append("baseValue", item.getBaseValue());

        if (item instanceof Potion) {
            itemDoc.append("type", "Potion");
            itemDoc.append("restorationAmount", ((Potion) item).getRestorationAmount());
        } else if (item instanceof Weapon) {
            itemDoc.append("type", "Weapon");
            itemDoc.append("baseDamage", ((Weapon) item).getBaseDamage());
            itemDoc.append("attackSpeed", ((Weapon) item).getAttackSpeed());
            itemDoc.append("durability", ((Weapon) item).getDurability());
        } else if (item instanceof Armor) {
            itemDoc.append("type", "Armor");
            itemDoc.append("defense", ((Armor) item).getDefense());
            itemDoc.append("slot", ((Armor) item).getSlot().name());
        } else if (item instanceof Artifact) {
            itemDoc.append("type", "Artifact");
            itemDoc.append("bonusHealth", ((Artifact) item).getBonusHealth());
            itemDoc.append("slot", ((Artifact) item).getSlot().name());
        }
        return itemDoc;
    }

    private Item mapDocumentToItem(Document itemDoc) {
        if (itemDoc == null) return null;
        String itemType = itemDoc.getString("type");
        if ("Potion".equals(itemType)) {
            return new Potion(itemDoc.getString("id"), itemDoc.getString("name"),
                getDoubleSafe(itemDoc, "weight"), itemDoc.getString("description"),
                getDoubleSafe(itemDoc, "baseValue"), getDoubleSafe(itemDoc, "restorationAmount"));
        } else if ("Weapon".equals(itemType)) {
            return new Weapon(itemDoc.getString("id"), itemDoc.getString("name"),
                getDoubleSafe(itemDoc, "weight"), itemDoc.getString("description"),
                getDoubleSafe(itemDoc, "baseValue"), getDoubleSafe(itemDoc, "baseDamage"),
                getDoubleSafe(itemDoc, "attackSpeed"));
        } else if ("Armor".equals(itemType)) {
            ArmorSlot slot = ArmorSlot.valueOf(itemDoc.getString("slot"));
            return new Armor(
                itemDoc.getString("id"), itemDoc.getString("name"),
                getDoubleSafe(itemDoc, "weight"), itemDoc.getString("description"),
                getDoubleSafe(itemDoc, "baseValue"), getDoubleSafe(itemDoc, "defense"), slot);
        } else if ("Artifact".equals(itemType)) {
            ArtifactSlot slot = ArtifactSlot.valueOf(itemDoc.getString("slot"));
            return new Artifact(
                itemDoc.getString("id"), itemDoc.getString("name"),
                getDoubleSafe(itemDoc, "weight"), itemDoc.getString("description"),
                getDoubleSafe(itemDoc, "baseValue"), getDoubleSafe(itemDoc, "bonusHealth"), slot);
        }
        return null;
    }

    @Override
    public void save(Character character) {
        Document doc = new Document(FIELD_ID, character.getId())
                .append(FIELD_NAME, character.getName())
                .append(FIELD_LEVEL, character.getLevel())
                .append(FIELD_HP, character.getHp())
                .append(FIELD_MAX_HP, character.getMaxHp())
                .append(FIELD_EXP, character.getExp());

        if (character instanceof Warrior) {
            Warrior warrior = (Warrior) character;
            doc.append(FIELD_TYPE, TYPE_WARRIOR);
            doc.append(FIELD_STRENGTH, warrior.getStrength());
            doc.append(FIELD_RAGE, warrior.getRage());
        } else if (character instanceof Mage) {
            Mage mage = (Mage) character;
            doc.append(FIELD_TYPE, TYPE_MAGE);
            doc.append(FIELD_INTELLIGENCE, mage.getIntelligence());
            doc.append(FIELD_MANA, mage.getMana());
        }

        // Save inventory
        List<Document> inventoryDocs = new ArrayList<>();
        for (Item item : character.getInventory()) {
            inventoryDocs.add(mapItemToDocument(item));
        }
        doc.append(FIELD_INVENTORY, inventoryDocs);

        // Save equipped weapon
        if (character.getEquippedWeapon() != null) {
            doc.append("equippedWeapon", mapItemToDocument(character.getEquippedWeapon()));
        }

        // Save equipped armor
        List<Document> equippedArmorDocs = new ArrayList<>();
        for (ArmorSlot slot : ArmorSlot.values()) {
            Armor armor = character.getEquippedArmor(slot);
            if (armor != null) {
                equippedArmorDocs.add(mapItemToDocument(armor));
            }
        }
        doc.append("equippedArmor", equippedArmorDocs);

        // Save equipped artifacts
        List<Document> equippedArtifactDocs = new ArrayList<>();
        for (ArtifactSlot slot : ArtifactSlot.values()) {
            Artifact artifact = character.getEquippedArtifact(slot);
            if (artifact != null) {
                equippedArtifactDocs.add(mapItemToDocument(artifact));
            }
        }
        doc.append("equippedArtifacts", equippedArtifactDocs);

        ReplaceOptions options = new ReplaceOptions().upsert(true);
        collection.replaceOne(Filters.eq(FIELD_ID, character.getId()), doc, options);
    }

    @Override
    public Character findById(String id) {
        Document doc = collection.find(Filters.eq(FIELD_ID, id)).first();
        if (doc == null) return null;
        return mapDocumentToCharacter(doc);
    }

    @Override
    public List<Character> findAll() {
        List<Character> list = new ArrayList<>();
        for (Document doc : collection.find()) {
            Character c = mapDocumentToCharacter(doc);
            if (c != null) list.add(c);
        }
        return list;
    }

    @Override
    public void delete(String id) {
        collection.deleteOne(Filters.eq(FIELD_ID, id));
    }

    private double calculateArtifactsHealthBonus(Document doc) {
        double total = 0;
        List<Document> artifactDocs = doc.getList("equippedArtifacts", Document.class);
        if (artifactDocs != null) {
            for (Document artDoc : artifactDocs) {
                total += getDoubleSafe(artDoc, "bonusHealth");
            }
        }
        return total;
    }

    private Character mapDocumentToCharacter(Document doc) {
        String type = doc.getString(FIELD_TYPE);
        Character character = null;

        // Calculate base maxHp by subtracting artifact bonuses from saved maxHp
        double baseMaxHp = getDoubleSafe(doc, FIELD_MAX_HP) - calculateArtifactsHealthBonus(doc);

        if (TYPE_WARRIOR.equals(type)) {
            Warrior warrior = new Warrior(
                    doc.getString(FIELD_ID),
                    doc.getString(FIELD_NAME),
                    doc.getInteger(FIELD_LEVEL),
                    baseMaxHp,
                    getDoubleSafe(doc, FIELD_STRENGTH)
            );
            warrior.setExp(doc.getInteger(FIELD_EXP, 0));
            character = warrior;
        } else if (TYPE_MAGE.equals(type)) {
            Mage mage = new Mage(
                    doc.getString(FIELD_ID),
                    doc.getString(FIELD_NAME),
                    doc.getInteger(FIELD_LEVEL),
                    baseMaxHp,
                    getDoubleSafe(doc, FIELD_INTELLIGENCE),
                    getDoubleSafe(doc, FIELD_MANA)
            );
            mage.setMana(getDoubleSafe(doc, FIELD_MANA));
            mage.setExp(doc.getInteger(FIELD_EXP, 0));
            character = mage;
        }

        if (character != null) {
            // Load inventory (without auto-equipping!)
            List<Document> inventoryDocs = doc.getList(FIELD_INVENTORY, Document.class);
            if (inventoryDocs != null) {
                for (Document itemDoc : inventoryDocs) {
                    Item item = mapDocumentToItem(itemDoc);
                    if (item != null) {
                        try {
                            character.addItem(item);
                        } catch (Exception e) {}
                    }
                }
            }

            // Load equipped weapon
            Document weaponDoc = doc.get("equippedWeapon", Document.class);
            if (weaponDoc != null) {
                Weapon w = (Weapon) mapDocumentToItem(weaponDoc);
                if (w != null) {
                    character.setBonusDamage(character.getBonusDamage() + w.getBaseDamage());
                    character.setEquippedWeapon(w);
                }
            }

            // Load equipped armor
            List<Document> armorDocs = doc.getList("equippedArmor", Document.class);
            if (armorDocs != null) {
                for (Document armorDoc : armorDocs) {
                    Armor a = (Armor) mapDocumentToItem(armorDoc);
                    if (a != null) {
                        character.setBonusDefense(character.getBonusDefense() + a.getDefense());
                        character.setEquippedArmor(a.getSlot(), a);
                    }
                }
            }

            // Load equipped artifacts
            List<Document> artifactDocs = doc.getList("equippedArtifacts", Document.class);
            if (artifactDocs != null) {
                for (Document artDoc : artifactDocs) {
                    Artifact art = (Artifact) mapDocumentToItem(artDoc);
                    if (art != null) {
                        character.setMaxHp(character.getMaxHp() + art.getBonusHealth());
                        character.setEquippedArtifact(art.getSlot(), art);
                    }
                }
            }

            // Apply saved health directly, safe inside [0, maxHp] range
            character.setHp(getDoubleSafe(doc, FIELD_HP));
        }

        return character;
    }
}

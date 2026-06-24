package ec.edu.espe.rpg.repository;

import ec.edu.espe.rpg.model.entities.Character;
import ec.edu.espe.rpg.model.entities.Warrior;
import ec.edu.espe.rpg.model.entities.Mage;
import ec.edu.espe.rpg.model.entities.Item;
import ec.edu.espe.rpg.model.entities.Potion;
import ec.edu.espe.rpg.model.entities.Weapon;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoCharacterRepository implements CharacterRepository {

    private static final String CONNECTION_STRING = "mongodb://admin:AZaxnebula18*@157.137.223.54:27017/";
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
        this.mongoClient = MongoClients.create(CONNECTION_STRING);
        this.database = mongoClient.getDatabase(DATABASE_NAME);
        this.collection = database.getCollection(COLLECTION_NAME);
    }

    public static synchronized MongoCharacterRepository getInstance() {
        if (instance == null) {
            instance = new MongoCharacterRepository();
        }
        return instance;
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

        List<Document> inventoryDocs = new ArrayList<>();
        for (Item item : character.getInventory()) {
            Document itemDoc = new Document("id", item.getId())
                    .append("name", item.getName())
                    .append("weight", item.getWeight())
                    .append("description", item.getDescription())
                    .append("baseValue", item.getBaseValue());
            
            if (item instanceof Potion) {
                itemDoc.append("type", "Potion");
                itemDoc.append("restorationAmount", ((Potion)item).getRestorationAmount());
            } else if (item instanceof Weapon) {
                itemDoc.append("type", "Weapon");
                itemDoc.append("baseDamage", ((Weapon)item).getBaseDamage());
                itemDoc.append("attackSpeed", ((Weapon)item).getAttackSpeed());
                itemDoc.append("durability", ((Weapon)item).getDurability());
            } else if (item instanceof ec.edu.espe.rpg.model.entities.Armor) {
                itemDoc.append("type", "Armor");
                itemDoc.append("defense", ((ec.edu.espe.rpg.model.entities.Armor)item).getDefense());
                itemDoc.append("slot", ((ec.edu.espe.rpg.model.entities.Armor)item).getSlot().name());
            } else if (item instanceof ec.edu.espe.rpg.model.entities.Artifact) {
                itemDoc.append("type", "Artifact");
                itemDoc.append("bonusHealth", ((ec.edu.espe.rpg.model.entities.Artifact)item).getBonusHealth());
                itemDoc.append("slot", ((ec.edu.espe.rpg.model.entities.Artifact)item).getSlot().name());
            }
            inventoryDocs.add(itemDoc);
        }
        doc.append(FIELD_INVENTORY, inventoryDocs);

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

    private Character mapDocumentToCharacter(Document doc) {
        String type = doc.getString(FIELD_TYPE);
        Character character = null;

        if (TYPE_WARRIOR.equals(type)) {
            Warrior warrior = new Warrior(
                    doc.getString(FIELD_ID),
                    doc.getString(FIELD_NAME),
                    doc.getInteger(FIELD_LEVEL),
                    doc.getDouble(FIELD_MAX_HP),
                    doc.getDouble(FIELD_STRENGTH)
            );
            warrior.setExp(doc.getInteger(FIELD_EXP, 0));
            applyDamage(warrior, doc.getDouble(FIELD_MAX_HP), doc.getDouble(FIELD_HP));
            character = warrior;
        } else if (TYPE_MAGE.equals(type)) {
            Mage mage = new Mage(
                    doc.getString(FIELD_ID),
                    doc.getString(FIELD_NAME),
                    doc.getInteger(FIELD_LEVEL),
                    doc.getDouble(FIELD_MAX_HP),
                    doc.getDouble(FIELD_INTELLIGENCE),
                    doc.getDouble(FIELD_MANA)
            );
            mage.setMana(doc.getDouble(FIELD_MANA));
            mage.setExp(doc.getInteger(FIELD_EXP, 0));
            applyDamage(mage, doc.getDouble(FIELD_MAX_HP), doc.getDouble(FIELD_HP));
            character = mage;
        }

        if (character != null) {
            List<Document> inventoryDocs = doc.getList(FIELD_INVENTORY, Document.class);
            if (inventoryDocs != null) {
                for (Document itemDoc : inventoryDocs) {
                    String itemType = itemDoc.getString("type");
                    try {
                        if ("Potion".equals(itemType)) {
                            Potion p = new Potion(itemDoc.getString("id"), itemDoc.getString("name"),
                                itemDoc.getDouble("weight"), itemDoc.getString("description"),
                                itemDoc.getDouble("baseValue"), itemDoc.getDouble("restorationAmount"));
                            character.addItem(p);
                        } else if ("Weapon".equals(itemType)) {
                            Weapon w = new Weapon(itemDoc.getString("id"), itemDoc.getString("name"),
                                itemDoc.getDouble("weight"), itemDoc.getString("description"),
                                itemDoc.getDouble("baseValue"), itemDoc.getDouble("baseDamage"),
                                itemDoc.getDouble("attackSpeed"));
                            w.equip(character); // Equiparlo para que de el bono de daño
                            character.addItem(w);
                        } else if ("Armor".equals(itemType)) {
                            ec.edu.espe.rpg.model.enums.ArmorSlot slot = ec.edu.espe.rpg.model.enums.ArmorSlot.valueOf(itemDoc.getString("slot"));
                            ec.edu.espe.rpg.model.entities.Armor a = new ec.edu.espe.rpg.model.entities.Armor(
                                itemDoc.getString("id"), itemDoc.getString("name"),
                                itemDoc.getDouble("weight"), itemDoc.getString("description"),
                                itemDoc.getDouble("baseValue"), itemDoc.getDouble("defense"), slot);
                            a.equip(character);
                            character.addItem(a);
                        } else if ("Artifact".equals(itemType)) {
                            ec.edu.espe.rpg.model.enums.ArtifactSlot slot = ec.edu.espe.rpg.model.enums.ArtifactSlot.valueOf(itemDoc.getString("slot"));
                            ec.edu.espe.rpg.model.entities.Artifact art = new ec.edu.espe.rpg.model.entities.Artifact(
                                itemDoc.getString("id"), itemDoc.getString("name"),
                                itemDoc.getDouble("weight"), itemDoc.getString("description"),
                                itemDoc.getDouble("baseValue"), itemDoc.getDouble("bonusHealth"), slot);
                            art.equip(character);
                            character.addItem(art);
                        }
                    } catch (Exception e) {}
                }
            }
        }

        return character;
    }

    private void applyDamage(Character character, double maxHp, double currentHp) {
        double damageTaken = maxHp - currentHp;
        if (damageTaken > 0) {
            character.takeDamage(damageTaken);
        }
    }
}

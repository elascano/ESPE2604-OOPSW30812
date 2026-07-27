/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class CharacterDAO {

    private MongoCollection<Document> collection;

    public CharacterDAO() {
        MongoDatabase database = MongoManager.getDatabase();
        collection = database.getCollection("characters");
    }

    public void saveCharacter(int id, String name, String type, int level, int health) {

        Document document = new Document("id", id)
                .append("name", name)
                .append("type", type)
                .append("level", level)
                .append("health", health);

        collection.insertOne(document);

        System.out.println("Character saved");
    }

    public List<String> getCharacters() {

        List<String> characters = new ArrayList<>();

        for (Document document : collection.find()) {

            String character =
                    "ID: " + document.getInteger("id")
                    + " Name: " + document.getString("name")
                    + " Type: " + document.getString("type")
                    + " Level: " + document.getInteger("level")
                    + " Health: " + document.getInteger("health");

            characters.add(character);
        }

        return characters;
    }
}
package ec.edu.espe.farm.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.farm.model.FarmAnimal;
import org.bson.Document;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.MongoConnection;

public class FarmAnimalController {
    private final MongoCollection<Document> collection;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public FarmAnimalController() {
        MongoDatabase database = MongoConnection.getDatabase();
        this.collection = database.getCollection("farm_animals");
    }

    public void saveAnimal(String type, String id, String breed, String bornOn, double weight, String health) {
        Document doc = new Document("id", id)
                .append("type", type)
                .append("breed", breed)
                .append("bornOn", bornOn)
                .append("weight", weight)
                .append("health", health);
        
        collection.insertOne(doc);
    }

    public List<FarmAnimal> getAnimals() {
        List<FarmAnimal> animals = new ArrayList<>();
        for (Document doc : collection.find()) {
            
            
            FarmAnimal animal = new FarmAnimal() {};
            
            try {
             
                String idStr = doc.getString("id");
                if (idStr != null) {
                    animal.setId(Integer.parseInt(idStr));
                }
                
                animal.setBreed(doc.getString("breed"));
                
       
                String bornOnStr = doc.getString("bornOn");
                if (bornOnStr != null && !bornOnStr.isEmpty()) {
                    Date date = dateFormat.parse(bornOnStr);
                    animal.setBornOn(date);
                }
                
             
                if (doc.get("weight") != null) {
                    animal.setWeight(doc.getDouble("weight").floatValue());
                }
                
                animals.add(animal);
            } catch (Exception e) {
                System.err.println("Error mapping animal from the database: " + e.getMessage());
            }
        }
        return animals;
    }

    public int calculateAgeInMonths(FarmAnimal animal) {
        if (animal == null || animal.getBornOn() == null) {
            return 0;
        }
        try {
        
            LocalDate birthDate = animal.getBornOn().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            
            LocalDate currentDate = LocalDate.now();
            
            Period period = Period.between(birthDate, currentDate);
            return (period.getYears() * 12) + period.getMonths();
        } catch (Exception e) {
            System.err.println("Error calculating the age for the animal: " + e.getMessage());
            return 0;
        }
    }
}
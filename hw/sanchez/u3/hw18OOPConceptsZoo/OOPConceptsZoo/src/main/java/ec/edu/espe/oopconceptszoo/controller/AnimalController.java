package ec.edu.espe.oopconceptszoo.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import ec.edu.espe.oopconceptszoo.model.*;
import java.text.ParseException;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class AnimalController {
    private DatabaseConnection dbConnection;
    private SimpleDateFormat dateFormat;
    
    public AnimalController() {
        dbConnection = DatabaseConnection.getInstance();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        
        if (!dbConnection.isConnected()) {
            System.err.println("Could not connect to MongoDB Atlas. Check your internet connection and credentials.");
        }
    }
    
    public boolean registerAnimal(FarmAnimal animal) {
        try {
            MongoCollection<Document> collection = dbConnection.getCollection("animals");
            Document doc = new Document();
            doc.append("id", animal.getId())
               .append("type", animal.getClass().getSimpleName())
               .append("breed", animal.getBreed())
               .append("bornOn", animal.getBornOn())
               .append("weight", animal.getWeight())
               .append("registeredAt", new Date());
            
            if (animal instanceof Cow) {
                Cow cow = (Cow) animal;
                doc.append("isProducingMilk", cow.isProducingMilk());
                doc.append("milkProduced", cow.getMilkProduced());
            } else if (animal instanceof Chicken) {
                Chicken chicken = (Chicken) animal;
                doc.append("isMolting", chicken.isMolting());
                doc.append("numberOfEggsPerWeek", chicken.getNumberOfEggsPerWeek());
            } else if (animal instanceof Pig) {
                Pig pig = (Pig) animal;
                doc.append("idealWeight", pig.getIdealWeight());
                doc.append("isReadyForSlaughter", pig.isReadyForSlaughter());
            } else if (animal instanceof Sheep) {
                Sheep sheep = (Sheep) animal;
                doc.append("lastSheering", sheep.getLastSheering());
            }
            
            InsertOneResult result = collection.insertOne(doc);
            return true;
            
        } catch (Exception e) {
            System.err.println("Error registering animal: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public List<FarmAnimal> getAnimalsByType(String type) {
        List<FarmAnimal> animals = new ArrayList<>();
        try {
            MongoCollection<Document> collection = dbConnection.getCollection("animals");
            
            for (Document doc : collection.find(new Document("type", type))) {
                FarmAnimal animal = documentToAnimal(doc);
                if (animal != null) {
                    animals.add(animal);
                }
            }
        } catch (Exception e) {
            System.err.println("Error getting animals by type: " + e.getMessage());
        }
        return animals;
    }
    
    public List<FarmAnimal> getAllAnimals() {
        List<FarmAnimal> animals = new ArrayList<>();
        try {
            MongoCollection<Document> collection = dbConnection.getCollection("animals");
            
            for (Document doc : collection.find().sort(new Document("id", 1))) {
                FarmAnimal animal = documentToAnimal(doc);
                if (animal != null) {
                    animals.add(animal);
                }
            }
            
        } catch (Exception e) {
            System.err.println("Error getting all animals: " + e.getMessage());
        }
        return animals;
    }
    
    public FarmAnimal getAnimalById(int id) {
        try {
            MongoCollection<Document> collection = dbConnection.getCollection("animals");
            Document doc = collection.find(new Document("id", id)).first();
            
            if (doc != null) {
                return documentToAnimal(doc);
            } else {
                return null;
            }
            
        } catch (Exception e) {
            System.err.println("Error searching animal by ID: " + e.getMessage());
            return null;
        }
    }
    
    public boolean deleteAnimal(int id) {
        try {
            MongoCollection<Document> collection = dbConnection.getCollection("animals");
            long deletedCount = collection.deleteOne(new Document("id", id)).getDeletedCount();
            
            if (deletedCount > 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            System.err.println("Error deleting animal: " + e.getMessage());
            return false;
        }
    }
    
    public float calculateTotalMilkProduction() {
        float totalMilk = 0;
        try {
            List<FarmAnimal> cows = getAnimalsByType("Cow");
            for (FarmAnimal animal : cows) {
                Cow cow = (Cow) animal;
                totalMilk += cow.getMilkProduced();
            }
            
        } catch (Exception e) {
            System.err.println("Error calculating milk production: " + e.getMessage());
        }
        return totalMilk;
    }
    
    public int calculateTotalEggsPerWeek() {
        int totalEggs = 0;
        try {
            List<FarmAnimal> chickens = getAnimalsByType("Chicken");
            for (FarmAnimal animal : chickens) {
                Chicken chicken = (Chicken) animal;
                totalEggs += chicken.getNumberOfEggsPerWeek();
            }
            
        } catch (Exception e) {
            System.err.println("Error calculating total eggs: " + e.getMessage());
        }
        return totalEggs;
    }
    
    public List<Pig> getPigsReadyForSlaughter() {
        List<Pig> readyPigs = new ArrayList<>();
        try {
            List<FarmAnimal> pigs = getAnimalsByType("Pig");
            for (FarmAnimal animal : pigs) {
                Pig pig = (Pig) animal;
                if (pig.isReadyForSlaughter()) {
                    readyPigs.add(pig);
                }
            }
            
        } catch (Exception e) {
            System.err.println("Error getting ready pigs: " + e.getMessage());
        }
        return readyPigs;
    }
    
    public String getZooStatistics() {
        StringBuilder stats = new StringBuilder();
        try {
            List<FarmAnimal> allAnimals = getAllAnimals();
            
            int totalCows = 0, totalChickens = 0, totalPigs = 0, totalSheep = 0;
            float totalWeight = 0;
            
            for (FarmAnimal animal : allAnimals) {
                totalWeight += animal.getWeight();
                if (animal instanceof Cow) totalCows++;
                else if (animal instanceof Chicken) totalChickens++;
                else if (animal instanceof Pig) totalPigs++;
                else if (animal instanceof Sheep) totalSheep++;
            }
            
            stats.append("=== ZOO STATISTICS ===\n");
            stats.append("Total animals: ").append(allAnimals.size()).append("\n");
            stats.append("├─ Cows: ").append(totalCows).append("\n");
            stats.append("├─ Chickens: ").append(totalChickens).append("\n");
            stats.append("├─ Pigs: ").append(totalPigs).append("\n");
            stats.append("└─ Sheep: ").append(totalSheep).append("\n");
            stats.append("Total weight: ").append(String.format("%.2f", totalWeight)).append(" kg\n");
            stats.append("Average weight: ").append(String.format("%.2f", 
                allAnimals.isEmpty() ? 0 : totalWeight / allAnimals.size())).append(" kg\n");
            
        } catch (Exception e) {
            System.err.println("Error getting statistics: " + e.getMessage());
            stats.append("Error generating statistics\n");
        }
        return stats.toString();
    }
    
    private float getFloatValue(Object obj) {
        if (obj == null) {
            return 0.0f;
        }
        if (obj instanceof Double) {
            return ((Double) obj).floatValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).floatValue();
        }
        if (obj instanceof Float) {
            return (Float) obj;
        }
        if (obj instanceof String) {
            try {
                return Float.parseFloat((String) obj);
            } catch (NumberFormatException e) {
                return 0.0f;
            }
        }
        return 0.0f;
    }
    
    private int getIntValue(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Double) {
            return ((Double) obj).intValue();
        }
        if (obj instanceof Float) {
            return ((Float) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return 0;
    }
    
    private Date parseDate(Object dateObj) {
        if (dateObj == null) {
            return new Date();
        }
        if (dateObj instanceof Date) {
            return (Date) dateObj;
        }
        if (dateObj instanceof String) {
            try {
                return dateFormat.parse((String) dateObj);
            } catch (ParseException e) {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse((String) dateObj);
                } catch (ParseException ex) {
                    try {
                        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse((String) dateObj);
                    } catch (ParseException exc) {
                        System.err.println("Error parsing date: " + dateObj);
                        return new Date();
                    }
                }
            }
        }
        return new Date();
    }
    
    private FarmAnimal documentToAnimal(Document doc) {
        try {
            String type = doc.getString("type");
            int id = doc.getInteger("id");
            String breed = doc.getString("breed");
            
            Object bornOnObj = doc.get("bornOn");
            Date bornOn = parseDate(bornOnObj);
            
            Object weightObj = doc.get("weight");
            float weight = getFloatValue(weightObj);
            
            switch (type) {
                case "Cow":
                    Boolean isProducingMilk = doc.getBoolean("isProducingMilk", false);
                    Cow cow = new Cow(id, breed, bornOn, weight, isProducingMilk);
                    return cow;
                    
                case "Chicken":
                    Boolean isMolting = doc.getBoolean("isMolting", false);
                    Object eggsObj = doc.get("numberOfEggsPerWeek");
                    int eggs = getIntValue(eggsObj);
                    Chicken chicken = new Chicken(id, breed, bornOn, weight, isMolting);
                    chicken.setNumberOfEggsPerWeek(eggs);
                    return chicken;
                    
                case "Pig":
                    Object idealWeightObj = doc.get("idealWeight");
                    float idealWeight = getFloatValue(idealWeightObj);
                    Pig pig = new Pig(id, breed, bornOn, weight, idealWeight);
                    return pig;
                    
                case "Sheep":
                    Object lastSheeringObj = doc.get("lastSheering");
                    Date lastSheering = parseDate(lastSheeringObj);
                    Sheep sheep = new Sheep(id, breed, bornOn, weight, lastSheering);
                    return sheep;
                    
                default:
                    return null;
            }
            
        } catch (Exception e) {
            System.err.println("Error converting document to animal: " + e.getMessage());
            return null;
        }
    }
}
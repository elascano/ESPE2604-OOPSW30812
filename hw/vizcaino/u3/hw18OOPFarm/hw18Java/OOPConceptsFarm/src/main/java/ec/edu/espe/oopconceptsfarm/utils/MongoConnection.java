/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconceptsfarm.utils;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import com.mongodb.client.*;
import com.mongodb.client.model.ReplaceOptions;
import ec.edu.espe.oopconceptsfarm.model.Chicken;
import ec.edu.espe.oopconceptsfarm.model.Cow;
import ec.edu.espe.oopconceptsfarm.model.FarmAnimal;
import ec.edu.espe.oopconceptsfarm.model.Pig;
import ec.edu.espe.oopconceptsfarm.model.Sheep;
import org.bson.Document;

import java.util.ArrayList;

public class MongoConnection {

    private final String connectionString =
            "mongodb+srv://Adrian:Adrian@cluster0.e4n4vbs.mongodb.net/?appName=Cluster0";

    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoConnection() {

        mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase("hw18Java");
    }

    public void saveAnimal(FarmAnimal animal) {

        MongoCollection<Document> collection =
                database.getCollection(animal.getClass().getSimpleName().toLowerCase());

        Document doc = new Document();
        if(animal instanceof Chicken chicken){
             doc.append(
             "totalEggsProduced",
             chicken.getTotalEggsProduced());
        }

         if(animal instanceof Cow cow){
             doc.append(
             "totalMilkProduced",
             cow.getTotalMilkProduced());
         }     

          if(animal instanceof Pig pig){
             doc.append(
             "totalMeatProduced",
             pig.getTotalMeatProduced());
         }

           if(animal instanceof Sheep sheep){
             doc.append(
             "totalWoolProduced",
             sheep.getTotalWoolProduced());
        }

        doc.append("id", animal.getId());
        doc.append("type", animal.getClass().getSimpleName());
        doc.append("breed", animal.getBreed());
        doc.append("weight", animal.getWeight());
        doc.append("age", animal.getAgeInMonths());
        doc.append("healthStatus", animal.getHealthStatus());
         doc.append("id", animal.getId());
         doc.append("type", animal.getClass().getSimpleName());
         doc.append("breed", animal.getBreed());
         doc.append("weight", animal.getWeight());
         doc.append("age", animal.getAgeInMonths());
         doc.append("healthStatus", animal.getHealthStatus());

         if(animal instanceof Chicken chicken){

               doc.append(
             "numberOfEggsPerWeek",
             chicken.getNumberOfEggsPerWeek());

              doc.append( 
             "totalEggsProduced",
             chicken.getTotalEggsProduced());
          }

          if(animal instanceof Cow cow){

             doc.append(
             "totalMilkProduced",
             cow.getTotalMilkProduced());
          } 

          if(animal instanceof Sheep sheep){

              doc.append(
              "totalWoolProduced",
              sheep.getTotalWoolProduced());
          }

           if(animal instanceof Pig pig){

             doc.append(
             "totalMeatProduced",
             pig.getTotalMeatProduced());
          }

        collection.replaceOne(
                new Document("id", animal.getId()),
                doc,
                new ReplaceOptions().upsert(true)
        );
    }

    public ArrayList<FarmAnimal> loadAllAnimals() {
        ArrayList<FarmAnimal> animals = new ArrayList<>();
        return animals;
    }

    public void deleteAnimal(String type, int id) {

        MongoCollection<Document> collection =
                database.getCollection(type.toLowerCase());

        collection.deleteOne(new Document("id", id));
    }
}
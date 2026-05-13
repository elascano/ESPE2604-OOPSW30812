/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package firsttimemothersjson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Jennyfer Nase
 */
public class FirsttimemothersJSON {

    public static void main(String[] args) {
        
        JsonObject mother = new JsonObject();
        mother.addProperty("type", "Mother");
        mother.addProperty("firstName", "Fernanda");
        mother.addProperty("lastName", "Lopez");
        mother.addProperty("birthDate", "1995-08-15");
        mother.addProperty("national_id", "1712345678"); 
        mother.addProperty("disability_status", false);

        JsonObject baby = new JsonObject();
        baby.addProperty("type", "Baby");
        baby.addProperty("firstName", "Nicolas");
        baby.addProperty("lastName", "Mendez");
        baby.addProperty("birthDate", "2024-02-10");
        baby.addProperty("national_id", "1755566677");
        baby.addProperty("disability_status", false);
        baby.addProperty("weight_kg", 3.8);
        baby.addProperty("height_cm", 51.5);

        JsonArray userList = new JsonArray();
        userList.add(mother);
        userList.add(baby);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String finalJson = gson.toJson(userList);

       try (FileWriter writer = new FileWriter("user_registry.json")) {
            writer.write(finalJson);
            
            System.out.println("======= COMPLETE USER REGISTRY =======");
            
            userList.forEach(element -> {
                JsonObject user = element.getAsJsonObject();
                
                for (String key : user.keySet()) {
                    String label = key.substring(0, 1).toUpperCase() + key.substring(1);
                    String value = user.get(key).getAsString();
                    
                    System.out.println(label.replace("_", " ") + ": " + value);
                }
                System.out.println("------------------------------------");
                
            });
            System.out.println("\n[File saved successfully]");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
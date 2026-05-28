/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.StoreProducts.model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author sbart
 */
public class JsonManager {

    public static void saveProducts(Store store) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter("products.json")) {

            gson.toJson(store.getProducts(), writer);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
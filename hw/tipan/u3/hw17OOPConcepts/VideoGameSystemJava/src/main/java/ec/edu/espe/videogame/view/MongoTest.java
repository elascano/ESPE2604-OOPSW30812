/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.videogame.view;
import com.mongodb.client.MongoDatabase;
import utils.MongoManager;

/**
 *
 * @author ronal
 */
public class MongoTest {
    public static void main(String[] args) {

        MongoDatabase database = MongoManager.getDatabase();

        System.out.println("Connected to database: "
                + database.getName());

    }
}

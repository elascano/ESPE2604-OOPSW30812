/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.hw18farm.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.hw18farm.model.Cut;
import ec.edu.espe.hw18farm.utils.MongoConnection;
import java.util.ArrayList;
import org.bson.Document;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class CutController {
    private MongoCollection<Document> collection;

    public CutController() {
        collection = MongoConnection.getDatabase().getCollection("cuts");
    }

    public void create(Cut cut) {
        Document document = new Document();

        document.append("description", cut.getDescription());
        document.append("procedure", cut.getProcedure());
        document.append("weight", cut.getWeight());
        
        collection.insertOne(document);
    }
    
    public ArrayList<Cut> read(){
        ArrayList<Cut> cuts = new ArrayList<>();
        FindIterable<Document> documents = collection.find();
        
        for(Document doc: documents){

            String description = doc.getString("description");
            String procedure = doc.getString("procedure");
            double weight = doc.getDouble("weight");
            float convertedWeight = (float) weight;
            
            Cut cut = new Cut(0, description, procedure, convertedWeight);
            
            cuts.add(cut);
        }
        
        return cuts;
    }

}

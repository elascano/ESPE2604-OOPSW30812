package ec.edu.espe.oopconcepts.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.oopconcepts.model.Cut;
import ec.edu.espe.oopconcepts.utils.MongoConnection;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Angie Ñacato, ERROR 404, @ESPE
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

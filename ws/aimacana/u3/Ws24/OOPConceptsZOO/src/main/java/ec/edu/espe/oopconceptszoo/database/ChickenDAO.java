package ec.edu.espe.oopconceptszoo.database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import ec.edu.espe.oopconceptszoo.model.Chicken;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class ChickenDAO {
    private final MongoCollection<Document> collection;

    public ChickenDAO() {
        this.collection = MongoDBConnection.getDatabase().getCollection("chickens");
    }

    public void save(Chicken chicken) {
        Document doc = new Document("id", chicken.getId())
                .append("breed", chicken.getBreed())
                .append("bornOn", chicken.getBornOn().toString())
                .append("weight", chicken.getWeight())
                .append("isMolting", chicken.getIsMolting());
        collection.insertOne(doc);
    }

    public List<Chicken> getAll() {
        List<Chicken> chickens = new ArrayList<>();
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Chicken chicken = new Chicken(
                        doc.getInteger("id"),
                        doc.getString("breed"),
                        LocalDate.parse(doc.getString("bornOn")),
                        doc.getDouble("weight").floatValue(),
                        doc.getBoolean("isMolting")
                );
                chickens.add(chicken);
            }
        }
        return chickens;
    }
}

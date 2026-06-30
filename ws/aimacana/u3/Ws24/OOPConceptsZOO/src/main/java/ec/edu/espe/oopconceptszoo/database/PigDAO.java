package ec.edu.espe.oopconceptszoo.database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import ec.edu.espe.oopconceptszoo.model.Pig;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class PigDAO {
    private final MongoCollection<Document> collection;

    public PigDAO() {
        this.collection = MongoDBConnection.getDatabase().getCollection("pigs");
    }

    public void save(Pig pig) {
        Document doc = new Document("id", pig.getId())
                .append("breed", pig.getBreed())
                .append("bornOn", pig.getBornOn().toString())
                .append("weight", pig.getWeight());
        collection.insertOne(doc);
    }

    public List<Pig> getAll() {
        List<Pig> pigs = new ArrayList<>();
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Pig pig = new Pig(
                        doc.getInteger("id"),
                        doc.getString("breed"),
                        LocalDate.parse(doc.getString("bornOn")),
                        doc.getDouble("weight").floatValue()
                );
                pigs.add(pig);
            }
        }
        return pigs;
    }
}

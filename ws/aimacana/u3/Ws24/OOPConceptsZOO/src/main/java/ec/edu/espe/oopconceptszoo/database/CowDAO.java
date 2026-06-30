package ec.edu.espe.oopconceptszoo.database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import ec.edu.espe.oopconceptszoo.model.Cow;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class CowDAO {
    private final MongoCollection<Document> collection;

    public CowDAO() {
        this.collection = MongoDBConnection.getDatabase().getCollection("cows");
    }

    public void save(Cow cow) {
        Document doc = new Document("id", cow.getId())
                .append("breed", cow.getBreed())
                .append("bornOn", cow.getBornOn().toString())
                .append("weight", cow.getWeight())
                .append("isProducingMilk", cow.getIsProducingMilk());
        collection.insertOne(doc);
    }

    public List<Cow> getAll() {
        List<Cow> cows = new ArrayList<>();
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Cow cow = new Cow(
                        doc.getInteger("id"),
                        doc.getString("breed"),
                        LocalDate.parse(doc.getString("bornOn")),
                        doc.getDouble("weight").floatValue(),
                        doc.getBoolean("isProducingMilk")
                );
                cows.add(cow);
            }
        }
        return cows;
    }
}

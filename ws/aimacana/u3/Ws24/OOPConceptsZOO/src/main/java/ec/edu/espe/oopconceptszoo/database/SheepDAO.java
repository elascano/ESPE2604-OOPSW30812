package ec.edu.espe.oopconceptszoo.database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import ec.edu.espe.oopconceptszoo.model.Sheep;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class SheepDAO {
    private final MongoCollection<Document> collection;

    public SheepDAO() {
        this.collection = MongoDBConnection.getDatabase().getCollection("sheeps");
    }

    public void save(Sheep sheep) {
        Document doc = new Document("id", sheep.getId())
                .append("breed", sheep.getBreed())
                .append("bornOn", sheep.getBornOn().toString())
                .append("weight", sheep.getWeight())
                .append("lastSheered", sheep.getLastSheered().toString());
        collection.insertOne(doc);
    }

    public List<Sheep> getAll() {
        List<Sheep> sheeps = new ArrayList<>();
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Sheep sheep = new Sheep(
                        doc.getInteger("id"),
                        doc.getString("breed"),
                        LocalDate.parse(doc.getString("bornOn")),
                        doc.getDouble("weight").floatValue(),
                        LocalDate.parse(doc.getString("lastSheered"))
                );
                sheeps.add(sheep);
            }
        }
        return sheeps;
    }
}
